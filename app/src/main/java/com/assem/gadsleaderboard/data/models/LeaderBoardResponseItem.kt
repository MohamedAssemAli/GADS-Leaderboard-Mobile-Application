package com.assem.gadsleaderboard.data.models


import com.google.gson.annotations.SerializedName

data class LeaderBoardResponseItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("hours")
    val hours: Int,
    @SerializedName("name")
    val name: String
)