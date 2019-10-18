package com.anenigmatic.apogee19.screens.notices.core

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalTime

/**
 * Represents a notice which can be sent to the users.
 * */
@Entity(tableName = "Notices")
data class Notice(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val heading: String,
    val content: String,
    val date: LocalDate,
    val time: LocalTime
)