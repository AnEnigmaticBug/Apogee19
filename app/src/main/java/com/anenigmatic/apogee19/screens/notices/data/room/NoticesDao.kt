package com.anenigmatic.apogee19.screens.notices.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anenigmatic.apogee19.screens.notices.core.Notice
import io.reactivex.Flowable

@Dao
interface NoticesDao {

    @Query("SELECT * FROM Notices ORDER BY date, time")
    fun getAllNotices(): Flowable<List<Notice>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotice(notice: Notice)
}