package com.assem.gadsleaderboard.data.api

import com.assem.gadsleaderboard.data.models.LeaderBoardResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Mohamed Assem on 03-Sep-2020.
 * mo7mad.assim@gmail.com
 * https://github.com/MohamedAssemAli
 */

interface ServiceAPI {

    @GET("{filter}")
    suspend fun getLeaderBoard(@Path("filter") filter: String): Response<LeaderBoardResponse>
}