package com.milipade.talitha_koum.gadsleaderboard.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milipade.talitha_koum.gadsleaderboard.R
import com.milipade.talitha_koum.gadsleaderboard.models.UserHours
import com.milipade.talitha_koum.gadsleaderboard.models.UserScore
import com.squareup.picasso.Picasso

class SkillsAdapter (val userScoreList: ArrayList<UserScore>) : RecyclerView.Adapter<SkillsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.skills_list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: SkillsAdapter.ViewHolder, position: Int) {
        holder.bindItems(userScoreList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userScoreList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(userScore: UserScore) {
            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
            val imageBarge  = itemView.findViewById(R.id.image_barge) as ImageView

            Picasso.get().load(userScore.badgeUrl).into(imageBarge)
            textViewName.text = userScore.name
            textViewAddress.text = StringBuilder().append(userScore.score).append("  Skill QI Scores  ").append(userScore.country).toString()
        }
    }
}