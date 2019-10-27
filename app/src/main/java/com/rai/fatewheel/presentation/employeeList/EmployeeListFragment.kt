package com.rai.fatewheel.presentation.employeeList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rai.fatewheel.Constant
import com.rai.fatewheel.MainActivity

import com.rai.fatewheel.R
import com.rai.fatewheel.ScheduleService
import com.rai.fatewheel.data.entities.Engineer
import kotlinx.android.synthetic.main.employee_list_fragment.view.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class EmployeeListFragment : Fragment() {


    private lateinit var viewParent: View
    private lateinit var adapter: EngineerAdapter
    val viewModel: EmployeeListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewParent = inflater.inflate(R.layout.employee_list_fragment, container, false)
        return viewParent
    }

    override fun onStart() {
        super.onStart()
        initView()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getEngineers()
    }

    private fun initView() {
        viewParent.rclrEnggineer.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = EngineerAdapter()
        viewParent.rclrEnggineer.adapter = adapter

        viewParent.buttonCreateSchedule.setOnClickListener {
            val args = Bundle()
            args.putParcelableArrayList(Constant.ENGINEER_LIST, viewModel.engineerList.value!!)
            findNavController().navigate(R.id.action_employeeListFragment_to_scheduleFragment, args)
        }
    }

    private fun initViewModel() {
        viewModel.showLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                (activity as MainActivity).showProgress()
            } else {
                (activity as MainActivity).hideProgress()
            }
        })

        viewModel.engineerList.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }
}
