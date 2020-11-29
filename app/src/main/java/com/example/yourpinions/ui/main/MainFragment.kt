package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yourpinions.R
import com.example.yourpinions.data.Yourpinion
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: YourpinionRecyclerViewAdapter
    private lateinit var addYoupinion: FloatingActionButton
    private var data = ArrayList<Yourpinion>()

    // DUMMY DATA
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.mainRecyclerView)
        addYoupinion = view.findViewById(R.id.addYourpinion)
        initAddYourpinionButtonListener()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupRecyclerView()
        // TODO: Use the ViewModel
    }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(activity)
        adapter = YourpinionRecyclerViewAdapter(data, activity as (YourpinionClickListener))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
        // Observe LiveData on viewmodel retrieved from repo
        viewModel.loadData().observe(
            this,
            Observer {
                // Remove old data
                data.removeAll(data)
                // Add new data, only take the first 20
                data.addAll(it.take(20))
                // Notify recycler view to refresh
                recyclerView.adapter!!.notifyDataSetChanged()
            }
        )
    }

    private fun initAddYourpinionButtonListener() {
        addYoupinion.setOnClickListener {
            //TODO: Use show/hide to save compute resource??
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.container, YourpinionSubmissionFragment.newInstance())
                .addToBackStack("")
                .commit()
        }
    }

}