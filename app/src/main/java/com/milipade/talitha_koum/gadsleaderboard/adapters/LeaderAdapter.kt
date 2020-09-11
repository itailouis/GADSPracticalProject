package com.milipade.talitha_koum.gadsleaderboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milipade.talitha_koum.gadsleaderboard.R
import com.milipade.talitha_koum.gadsleaderboard.models.UserHours
import com.squareup.picasso.Picasso

class LeaderAdapter (val userHoursList: ArrayList<UserHours>) : RecyclerView.Adapter<LeaderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.leader_list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: LeaderAdapter.ViewHolder, position: Int) {
        holder.bindItems(userHoursList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userHoursList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(userHours: UserHours) {

            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
            val imageBarge  = itemView.findViewById(R.id.image_barge) as ImageView

            Picasso.get().load(userHours.badgeUrl).into(imageBarge)
            textViewName.text = userHours.name
            textViewAddress.text = StringBuilder().append(userHours.hours).append(" Learning  hours,  ").append(userHours.country).toString()
        }
    }
}