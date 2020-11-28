package com.example.yourpinions.ui.main

import android.app.LauncherActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourpinions.R
import com.example.yourpinions.data.Yourpinion
import com.example.yourpinions.inflate

class YourpinionRecyclerViewAdapter(private val yourpinionsList: ArrayList<Yourpinion>)
    : RecyclerView.Adapter<YourpinionRecyclerViewAdapter.YourpinionHolder>() {

    class YourpinionHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var yourpinion: Yourpinion? = null
        var opinion: TextView
        var voteCount: TextView

        init {
            v.setOnClickListener(this)
            opinion = view.findViewById(R.id.yourpinion)
            voteCount = view.findViewById(R.id.votecount)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindYourpinion(yourpinion: Yourpinion) {
            this.yourpinion = yourpinion
            voteCount.text = yourpinion.vote_count.toString()
            opinion.text = yourpinion.opinion
        }

    }

    override fun getItemCount(): Int {
        return yourpinionsList.count()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YourpinionHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_yourpinion_item, false)
        return YourpinionHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: YourpinionHolder, position: Int) {
        val itemYourpinion = yourpinionsList[position]
        Log.d("RecyclerView", "onBindViewHolder")
        holder.bindYourpinion(itemYourpinion)
    }
}