package com.milipade.talitha_koum.gadsleaderboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milipade.talitha_koum.gadsleaderboard.R
import com.milipade.talitha_koum.gadsleaderboard.adapters.LeaderAdapter
import com.milipade.talitha_koum.gadsleaderboard.adapters.SkillsAdapter
import com.milipade.talitha_koum.gadsleaderboard.models.UserHours
import com.milipade.talitha_koum.gadsleaderboard.models.UserScore
import com.milipade.talitha_koum.gadsleaderboard.networks.GADSClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val apiClient = GADSClient()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById(R.id.skills) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)


        val callback = object : Callback<List<UserScore>> {
            override fun onFailure(call: Call<List<UserScore>>?, t:Throwable?) {
                //Log.e("MainActivity", "Problem calling Github API {${t?.message}}")
            }

            override fun onResponse(call: Call<List<UserScore>>?, response: Response<List<UserScore>>?) {
                response?.isSuccessful.let {
                    val resultList = response?.body() ?: emptyList()
                    recyclerView.adapter = SkillsAdapter(ArrayList(resultList))
                }
            }
        }

        apiClient.getSkillIQ(callback)

    }
}
