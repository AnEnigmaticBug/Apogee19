package com.anenigmatic.apogee19.screens.notices.data

import com.anenigmatic.apogee19.screens.notices.core.Notice
import com.anenigmatic.apogee19.screens.notices.data.room.NoticesDao
import io.reactivex.Flowable

class NoticeRepositoryImpl(private val nDao: NoticesDao) : NoticeRepository {

    override fun getAllNotices(): Flowable<List<Notice>> {
        return nDao.getAllNotices()
    }
}