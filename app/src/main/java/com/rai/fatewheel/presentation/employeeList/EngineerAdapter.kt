package com.rai.fatewheel.presentation.employeeList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rai.fatewheel.R
import com.rai.fatewheel.data.entities.Engineer
import kotlinx.android.synthetic.main.row_engineer.view.*

class EngineerAdapter : RecyclerView.Adapter<EngineerAdapter.EngineerViewHolder>() {

    private var engineerList: List<Engineer> = listOf()


    fun setData(engineerList: List<Engineer>) {
        this.engineerList = engineerList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_engineer, parent, false)
        return EngineerViewHolder(v)
    }

    override fun getItemCount(): Int {
        return engineerList.size
    }

    override fun onBindViewHolder(holder: EngineerViewHolder, position: Int) {
        holder.populateView(engineerList[position])
    }


    class EngineerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateView(engineer: Engineer) {
            itemView.textEngineerName.text = engineer.name
        }
    }
}