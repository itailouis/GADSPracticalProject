package com.milipade.talitha_koum.gadsleaderboard.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milipade.talitha_koum.gadsleaderboard.R
import com.milipade.talitha_koum.gadsleaderboard.adapters.LeaderAdapter
import com.milipade.talitha_koum.gadsleaderboard.models.UserHours
import com.milipade.talitha_koum.gadsleaderboard.networks.GADSClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val apiClient = GADSClient()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById(R.id.leaders) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)


        val callback = object : Callback<List<UserHours>> {
            override fun onFailure(call: Call<List<UserHours>>?, t:Throwable?) {
                Log.e("First", "Problem calling  API {${t?.message}}")
            }

            override fun onResponse(call: Call<List<UserHours>>?, response: Response<List<UserHours>>?) {
                response?.isSuccessful.let {
                    val resultList = response?.body()  ?: emptyList()
                    recyclerView.adapter = LeaderAdapter(ArrayList(resultList))
                }
            }
        }

        apiClient.getLearningLeaders(callback)

        //crating an arraylist to store users using the data class user
        /*val users = ArrayList<UserHours>()

        //adding some dummy data to the list
        users.add(UserHours("Belal Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Ramiz Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Faiz Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Yashar Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Belal Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Ramiz Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Faiz Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Yashar Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Belal Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Ramiz Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Faiz Khan", "Ranchi Jharkhand"))
        users.add(UserHours("Yashar Khan", "Ranchi Jharkhand"))

        //creating our adapter
        val adapter = LeaderAdapter(users)*/

        //now adding the adapter to recyclerview
        //recyclerView.adapter = adapter


    }
}
