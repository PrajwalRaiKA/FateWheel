package com.rai.fatewheel.presentation.employeeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rai.fatewheel.R
import com.rai.fatewheel.application.Constant
import com.rai.fatewheel.presentation.MainActivity
import kotlinx.android.synthetic.main.employee_list_fragment.view.*
import org.koin.android.ext.android.inject

class EmployeeListFragment : Fragment() {


    private lateinit var viewParent: View
    private lateinit var adapter: EngineerAdapter
    private val viewModel: EmployeeListViewModel by inject()

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
        viewParent.listEngineer.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = EngineerAdapter()
        viewParent.listEngineer.adapter = adapter

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

        viewModel.showError.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.engineerList.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                viewParent.buttonCreateSchedule.visibility = View.GONE
            }else{
                viewParent.buttonCreateSchedule.visibility = View.VISIBLE
            }
            adapter.setData(it)
        })
    }
}
