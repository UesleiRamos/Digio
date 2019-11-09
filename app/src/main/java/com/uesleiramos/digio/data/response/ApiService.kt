package com.uesleiramos.digio.data.response

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://7hgi9vtkdc.execute-api.sa-east-1.amazonaws.com/sandbox/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service = initRetrofit().create(DigioService::class.java)
}