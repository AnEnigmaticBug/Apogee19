package com.anenigmatic.apogee19.screens.notices.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anenigmatic.apogee19.ApogeeApp
import com.anenigmatic.apogee19.screens.notices.data.NoticeRepository
import javax.inject.Inject

class NoticesViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var noticeRepository: NoticeRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        ApogeeApp.appComponent.newNoticesComponent().inject(this)
        return NoticesViewModel(noticeRepository) as T
    }
}