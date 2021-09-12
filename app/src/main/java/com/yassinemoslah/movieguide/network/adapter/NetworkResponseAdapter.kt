package com.yassinemoslah.movieguide.network.adapter

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

/**
 * A Retrofit adapter that converts the Call into a [NetworkResponse].
 * @param S The class type of the network result
 **/
class NetworkResponseAdapter<S : Any, E : Any>(private val successType: Type, private val errorBodyConverter: Converter<ResponseBody, E>) : CallAdapter<S, Call<NetworkResponse<S, E>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<S>): Call<NetworkResponse<S, E>> {
        return NetworkResponseCall(call, errorBodyConverter)
    }
}
