package com.milipade.talitha_koum.gadsleaderboard.networks

import com.milipade.talitha_koum.gadsleaderboard.models.UserHours
import com.milipade.talitha_koum.gadsleaderboard.models.UserScore
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GADSClient {
    private val service: APIService
    private val serviceForm: APIService

    companion object {
        const val BASE_URL = "https://gadsapi.herokuapp.com/"
        const val BASE_URL_FORM = "https://docs.google.com/forms/d/e/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitTwo = Retrofit.Builder()
            .baseUrl(BASE_URL_FORM)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(APIService::class.java)
        serviceForm = retrofitTwo.create(APIService::class.java)
    }
    fun getLearningLeaders(callback: Callback<List<UserHours>>){
        val call = service.retrieveLearners()
        call.enqueue(callback)
    }

    fun getSkillIQ(callback: Callback<List<UserScore>>){
        val call = service.retrieveSkilliq()
        call.enqueue(callback)
    }

    fun submitForm(callback: Callback<Void>,firstName:String,lastName:String,githubLink:String,emailAddress:String){
        val call = serviceForm.submitProject(firstName,lastName,githubLink,emailAddress)
        call.enqueue(callback)
    }
}