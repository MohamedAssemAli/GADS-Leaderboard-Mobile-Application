package com.assem.gadsleaderboard.data.api

import com.assem.gadsleaderboard.data.models.LeaderBoardResponse
import retrofit2.Response
import retrofit2.http.*


/**
 * Created by Mohamed Assem on 03-Sep-2020.
 * mo7mad.assim@gmail.com
 * https://github.com/MohamedAssemAli
 */

interface ServiceAPI {

    @GET("{filter}")
    suspend fun getLeaderBoard(@Path("filter") filter: String): Response<LeaderBoardResponse>

    @POST
    @FormUrlEncoded
    suspend fun submitProject(
        @Url url: String,
        @Field("entry.1824927963") email: String,
        @Field("entry.1877115667") firstName: String,
        @Field("entry.2006916086") lastName: String,
        @Field("entry.284483984") projectLink: String
    ): Response<Void>

}