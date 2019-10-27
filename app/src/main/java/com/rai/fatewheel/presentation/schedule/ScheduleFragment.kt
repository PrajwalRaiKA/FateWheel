package com.rai.fatewheel.presentation.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rai.fatewheel.application.Constant
import com.rai.fatewheel.R
import com.rai.fatewheel.data.entities.Engineer
import kotlinx.android.synthetic.main.schedule_fragment.view.*
import org.koin.android.ext.android.inject

class ScheduleFragment : Fragment() {


    private lateinit var adapter: ScheduleAdapter
    private lateinit var engineerList: ArrayList<Engineer>
    private lateinit var viewParent: View
    private val viewModel: ScheduleViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null)
            engineerList = arguments!!.getParcelableArrayList<Engineer>(Constant.ENGINEER_LIST)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewParent = inflater.inflate(R.layout.schedule_fragment, container, false)

        return viewParent
    }


    override fun onStart() {
        super.onStart()
        initView()
        initViewModel()
        viewModel.getSchedule(engineerList.clone() as ArrayList<Engineer>)
    }

    private fun initView() {
        viewParent.listSchedule.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = ScheduleAdapter()
        viewParent.listSchedule.adapter = adapter

    }

    private fun initViewModel() {
        viewModel.scheduleList.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }


}
