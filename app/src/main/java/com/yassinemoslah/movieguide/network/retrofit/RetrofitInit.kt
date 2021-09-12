package com.yassinemoslah.movieguide.network.retrofit

import com.yassinemoslah.movieguide.BuildConfig
import com.yassinemoslah.movieguide.network.adapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * This class creates the main Retrofit instance to access the backend.
 * A [HttpLoggingInterceptor] to log all requests and responses
 */
internal object RetrofitInit {

    private const val baseUrl = "https://yassinemoslah.com/api/"

    fun getApi(): MovieGuideApi = createRetrofit().create(MovieGuideApi::class.java)

    private val loggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private fun getClient() : OkHttpClient {
        val client  = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            client.apply { this.addInterceptor(loggingInterceptor) }
        }
        return client.build()
    }

    private fun createRetrofit(): Retrofit {

        return Retrofit.Builder()
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .baseUrl(baseUrl)
            .build()
    }

}