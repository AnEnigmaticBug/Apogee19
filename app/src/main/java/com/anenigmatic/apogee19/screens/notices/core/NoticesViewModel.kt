package com.anenigmatic.apogee19.screens.notices.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anenigmatic.apogee19.screens.notices.data.NoticeRepository
import com.anenigmatic.apogee19.screens.shared.util.SingleLiveEvent
import com.anenigmatic.apogee19.screens.shared.util.asMut
import com.anenigmatic.apogee19.screens.shared.util.extractMessage
import com.anenigmatic.apogee19.screens.shared.util.set
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NoticesViewModel(nRepo: NoticeRepository) : ViewModel() {

    sealed class UiOrder {

        object ShowLoadingState : UiOrder()

        data class ShowWorkingState(val notices: List<Notice>) : UiOrder()
    }

    val orderData: LiveData<UiOrder> = MutableLiveData()
    val toastData: LiveData<String?> = SingleLiveEvent()


    private val d1 = CompositeDisposable()


    init {
        orderData.asMut().value = UiOrder.ShowLoadingState

        d1.set(nRepo.getAllNotices()
            .map { notices -> UiOrder.ShowWorkingState(notices) }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { order ->
                    orderData.asMut().postValue(order)
                },
                {
                    orderData.asMut().postValue(UiOrder.ShowWorkingState(listOf()))
                    toastData.asMut().postValue(it.extractMessage())
                }
            ))
    }


    override fun onCleared() {
        super.onCleared()
        d1.clear()
    }
}