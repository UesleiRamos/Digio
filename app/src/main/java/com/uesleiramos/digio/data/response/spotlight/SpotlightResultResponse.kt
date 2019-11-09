package com.uesleiramos.digio.data.response.spotlight

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpotlightResultResponse(
    @Json(name = "name")
    val name: String,
    @Json(name = "bannerURL")
    val URL: String,
    @Json(name = "description")
    val descricao: String
)