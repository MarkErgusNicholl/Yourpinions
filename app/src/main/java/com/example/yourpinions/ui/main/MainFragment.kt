package com.example.yourpinions.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yourpinions.MainActivity
import com.example.yourpinions.R
import com.example.yourpinions.data.Yourpinion

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: YourpinionRecyclerViewAdapter

    // DUMMY DATA
    private val dummyYourpinionList = ArrayList<Yourpinion>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        dummyYourpinionList.add(Yourpinion("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 255))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        dummyYourpinionList.add(Yourpinion("This"))
        dummyYourpinionList.add(Yourpinion("App"))
        dummyYourpinionList.add(Yourpinion("Is"))
        dummyYourpinionList.add(Yourpinion("Kinda"))
        dummyYourpinionList.add(Yourpinion("Sus"))
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.mainRecyclerView)
        linearLayoutManager = LinearLayoutManager(activity)
        adapter = YourpinionRecyclerViewAdapter(dummyYourpinionList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}