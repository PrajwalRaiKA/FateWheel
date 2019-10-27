package com.rai.fatewheel.presentation.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rai.fatewheel.R
import com.rai.fatewheel.data.entities.Schedule
import kotlinx.android.synthetic.main.row_schedule.view.*

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    private var scheduleList: List<Schedule> = listOf()


    fun setData(scheduleList: List<Schedule>) {
        this.scheduleList = scheduleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_schedule, parent, false)
        return ScheduleViewHolder(v)
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.populateView(scheduleList[position])
    }


    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateView(schedule: Schedule) {
            itemView.textDayNum.text = (schedule.day + 1).toString()
            itemView.textDayName.text = schedule.shiftEngineers[0].name
            itemView.textNightName.text = schedule.shiftEngineers[1].name
        }
    }
}