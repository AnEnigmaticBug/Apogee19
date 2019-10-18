package com.anenigmatic.apogee19.di.notices

import com.anenigmatic.apogee19.screens.notices.core.NoticesViewModelFactory
import dagger.Subcomponent

@Subcomponent
interface NoticesComponent {

    fun inject(factory: NoticesViewModelFactory)
}