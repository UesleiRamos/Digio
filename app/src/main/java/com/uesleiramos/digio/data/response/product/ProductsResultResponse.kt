package com.uesleiramos.digio.data.response.product

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ProductsResultResponse(
    @Json(name = "name")
    val name: String,
    @Json(name = "imageURL")
    val imageURL: String,
    @Json(name = "description")
    val description: String

)