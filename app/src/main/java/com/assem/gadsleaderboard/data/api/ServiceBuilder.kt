package com.assem.gadsleaderboard.data.api

import com.assem.gadsleaderboard.utils.ConstantsK.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Mohamed Assem on 03-Sep-2020.
 * mo7mad.assim@gmail.com
 * https://github.com/MohamedAssemAli
 */

class ServiceBuilder {
    companion object {
        private val retrofit by lazy {
            // Create OkHttp Client
            val okHttp = OkHttpClient.Builder()
                .callTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp)
                .build()
        }
        val api: ServiceAPI by lazy {
            retrofit.create(
                ServiceAPI::class.java
            )
        }
    }
}