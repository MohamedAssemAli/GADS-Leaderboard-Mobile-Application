package com.assem.gadsleaderboard.utils

/**
 * Created by Mohamed Assem on 03-Sep-2020.
 * mo7mad.assim@gmail.com
 * https://github.com/MohamedAssemAli
 */


sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}