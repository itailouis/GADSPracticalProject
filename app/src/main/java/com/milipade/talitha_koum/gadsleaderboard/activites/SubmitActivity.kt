package com.milipade.talitha_koum.gadsleaderboard.activites

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.milipade.talitha_koum.gadsleaderboard.R
import com.milipade.talitha_koum.gadsleaderboard.adapters.LeaderAdapter
import com.milipade.talitha_koum.gadsleaderboard.models.UserHours
import com.milipade.talitha_koum.gadsleaderboard.networks.GADSClient

import kotlinx.android.synthetic.main.activity_submit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivity : AppCompatActivity() {
    private val apiClient = GADSClient()

    private lateinit var submitBtn: Button

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var githubLink: EditText
    private lateinit var emailAddress: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        submitBtn = findViewById(R.id.submit_project) as Button

        firstName = findViewById(R.id.first_name) as EditText
        lastName = findViewById(R.id.last_name) as EditText
        githubLink = findViewById(R.id.github_link) as EditText
        emailAddress = findViewById(R.id.email_address) as EditText





        submitBtn.setOnClickListener { view ->
            val callback = object : Callback<Void> {
                override fun onFailure(call: Call<Void>?, t:Throwable?) {
                    Log.e("First", "Problem calling  API {${t?.message}}")
                }

                override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                    response?.isSuccessful.let {
                        Log.e("First", "Done calling  Api ")
                    }
                }
            }


            apiClient.submitForm(callback,"itai louis","zulu","https://github.com/itailouis/GADSPracticalProject","itaizulu@gmail.coom")
        }
    }

}
