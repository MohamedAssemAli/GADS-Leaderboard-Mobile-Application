package com.assem.gadsleaderboard.data.repository

import com.assem.gadsleaderboard.data.api.ServiceAPI
import com.assem.gadsleaderboard.data.api.ServiceBuilder


/**
 * Created by Mohamed Assem on 03-Sep-20.
 * mohamed.assem.ali@gmail.com
 */

class LeaderBoardRepository {

    suspend fun getLeaderBoard(filter: String) =
        ServiceBuilder.api.getLeaderBoard(filter)
}