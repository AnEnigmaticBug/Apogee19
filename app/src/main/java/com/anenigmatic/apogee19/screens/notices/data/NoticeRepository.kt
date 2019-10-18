package com.anenigmatic.apogee19.screens.notices.data

import com.anenigmatic.apogee19.screens.notices.core.Notice
import io.reactivex.Flowable

interface NoticeRepository {

    /**
     * Gives all the notices sent to the user in descending
     * order of datetime.
     * */
    fun getAllNotices(): Flowable<List<Notice>>
}