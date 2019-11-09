package com.uesleiramos.digio.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.uesleiramos.digio.data.response.cash.CashResultResponse
import com.uesleiramos.digio.data.response.product.ProductsResultResponse
import com.uesleiramos.digio.data.response.spotlight.SpotlightResultResponse

@JsonClass(generateAdapter = true)
data class DashboardResponse(
    @Json(name = "spotlight")
    val spotlightResult: List<SpotlightResultResponse>,

    @Json(name = "products")
    val productsResult: List<ProductsResultResponse>,

    @Json(name = "cash")
    val cashResult: CashResultResponse
)