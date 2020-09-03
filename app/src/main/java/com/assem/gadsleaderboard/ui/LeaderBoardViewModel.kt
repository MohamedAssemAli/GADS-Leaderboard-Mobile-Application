package com.assem.gadsleaderboard.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assem.gadsleaderboard.data.models.LeaderBoardResponseItem
import com.assem.gadsleaderboard.data.repository.LeaderBoardRepository
import com.assem.gadsleaderboard.utils.Resource
import kotlinx.coroutines.launch
import java.lang.Exception


/**
 * Created by Mohamed Assem on 03-Sep-20.
 * mohamed.assem.ali@gmail.com
 */

class LeaderBoardViewModel : ViewModel() {

    // repo
    val leaderBoardRepository = LeaderBoardRepository()

    // liveData
    var leaderBoardMutableLiveData: MutableLiveData<Resource<ArrayList<LeaderBoardResponseItem>>> =
        MutableLiveData()
    var filterBoardMutableLiveData: MutableLiveData<String> = MutableLiveData()

    fun getLeaderBoard() = viewModelScope.launch {
        try {
            leaderBoardMutableLiveData.postValue(Resource.Loading())
            val response = leaderBoardRepository.getLeaderBoard(filterBoardMutableLiveData.value!!)
            if (response.isSuccessful) {
                response.body()?.let { leaderBoardResponse ->
                    leaderBoardMutableLiveData.postValue(Resource.Success(leaderBoardResponse))
                }
            } else {
                leaderBoardMutableLiveData.postValue(Resource.Error("Response Failed"))
            }
        } catch (e: Exception) {
            leaderBoardMutableLiveData.postValue(Resource.Error(e.message.toString()))

        }

    }
}