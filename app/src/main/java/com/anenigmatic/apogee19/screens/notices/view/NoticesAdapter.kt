package com.anenigmatic.apogee19.screens.notices.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anenigmatic.apogee19.R
import com.anenigmatic.apogee19.screens.notices.core.Notice
import kotlinx.android.synthetic.main.row_notice.view.*
import org.threeten.bp.format.DateTimeFormatter

class NoticesAdapter : RecyclerView.Adapter<NoticesAdapter.NoticeVHolder>() {

    var notices = listOf<Notice>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = notices.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeVHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoticeVHolder(inflater.inflate(R.layout.row_notice, parent, false))
    }

    override fun onBindViewHolder(holder: NoticeVHolder, position: Int) {
        val notice = notices[position]

        holder.headingLBL.text = notice.heading
        holder.contentLBL.text = notice.content

        val dayName = notice.date.dayOfWeek.name.take(3).toUpperCase()
        val time = notice.time.format(DateTimeFormatter.ofPattern("hh:mm a"))
        holder.datetimeLBL.text = "$dayName $time"
    }

    class NoticeVHolder(rootPOV: View) : RecyclerView.ViewHolder(rootPOV) {

        val headingLBL: TextView = rootPOV.headingLBL
        val contentLBL: TextView = rootPOV.contentLBL
        val datetimeLBL: TextView = rootPOV.datetimeLBL
    }
}