package com.milipade.talitha_koum.gadsleaderboard.networks

import androidx.annotation.Nullable
import com.milipade.talitha_koum.gadsleaderboard.models.UserHours
import com.milipade.talitha_koum.gadsleaderboard.models.UserScore
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface APIService {

    @GET("/api/hours")
    fun retrieveLearners(): Call<List<UserHours>>

    @GET("/api/skilliq")
    fun retrieveSkilliq(): Call<List<UserScore>>

    @POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    @Nullable
    fun submitProject(
        @Field("entry.1877115667") @Nullable firstName: String?,
        @Field("entry.2006916086") @Nullable lastName: String?,
        @Field("entry.284483984") @Nullable githubLink: String?,
        @Field("entry.1824927963") @Nullable emailAddress: String?
    ): Call<Void>
}