package com.example.yourpinions.ui.main

import android.app.Activity
import android.app.LauncherActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourpinions.MainActivity
import com.example.yourpinions.R
import com.example.yourpinions.data.Yourpinion
import com.example.yourpinions.inflate

class YourpinionRecyclerViewAdapter(private val yourpinionsList: ArrayList<Yourpinion>, private val clickListener: YourpinionClickListener)
    : RecyclerView.Adapter<YourpinionRecyclerViewAdapter.YourpinionHolder>() {

    class YourpinionHolder(v: View, clickListener: YourpinionClickListener) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var yourpinion: Yourpinion? = null
        private var opinion: TextView
        private var voteCount: TextView
        private val clickListener: YourpinionClickListener = clickListener


        init {
            v.setOnClickListener(this)
            opinion = view.findViewById(R.id.yourpinion)
            voteCount = view.findViewById(R.id.votecount)
        }

        override fun onClick(v: View) {
            clickListener.onClick(12345,
                formatOpinion(yourpinion!!.opinion),
                formatVoteCount(yourpinion!!.vote_count))
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindYourpinion(yourpinion: Yourpinion) {
            this.yourpinion = yourpinion
            voteCount.text = formatVoteCount(yourpinion.vote_count)
            opinion.text = formatOpinion(yourpinion.opinion)
        }

        private fun formatVoteCount(voteCount: Int): String {
            if (voteCount > 0) {
                return "+$voteCount"
            }
            else return voteCount.toString()
        }

        private fun formatOpinion(opinion: String): String {
            return "\"" + opinion + "\""
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
        return YourpinionHolder(inflatedView, clickListener)
    }

    override fun onBindViewHolder(holder: YourpinionHolder, position: Int) {
        val itemYourpinion = yourpinionsList[position]
        Log.d("RecyclerView", "onBindViewHolder")
        holder.bindYourpinion(itemYourpinion)
    }
}