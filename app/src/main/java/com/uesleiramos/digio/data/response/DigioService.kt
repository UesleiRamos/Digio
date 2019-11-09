package com.uesleiramos.digio.data.response

import retrofit2.Call
import retrofit2.http.GET

interface DigioService {

    @GET("products/")
    fun dashboard(): Call<DashboardResponse>

}