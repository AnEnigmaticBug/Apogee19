package com.anenigmatic.apogee19.screens.notices.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anenigmatic.apogee19.R
import com.anenigmatic.apogee19.screens.notices.core.Notice
import com.anenigmatic.apogee19.screens.notices.core.NoticesViewModel
import com.anenigmatic.apogee19.screens.notices.core.NoticesViewModel.UiOrder
import com.anenigmatic.apogee19.screens.notices.core.NoticesViewModelFactory
import kotlinx.android.synthetic.main.fra_notices.view.*

class NoticesFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, NoticesViewModelFactory())[NoticesViewModel::class.java]
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootPOV = inflater.inflate(R.layout.fra_notices, container, false)

        rootPOV.noticesRCY.adapter = NoticesAdapter()

        viewModel.orderData.observe(viewLifecycleOwner, Observer { order ->
            when(order) {
                is UiOrder.ShowLoadingState -> showLoadingState()
                is UiOrder.ShowWorkingState -> showWorkingState(order.notices)
            }
        })

        return rootPOV
    }


    private fun showLoadingState() {

    }

    private fun showWorkingState(notices: List<Notice>) {
        view?.let { view ->
            (view.noticesRCY.adapter as NoticesAdapter).notices = notices
        }
    }
}