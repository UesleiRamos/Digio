package com.uesleiramos.digio.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uesleiramos.digio.R
import com.uesleiramos.digio.data.model.Cash
import com.uesleiramos.digio.data.model.Product
import com.uesleiramos.digio.data.model.Spotlight
import com.uesleiramos.digio.data.response.ApiService
import com.uesleiramos.digio.data.response.DashboardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel() {
    val sportlightLiveData: MutableLiveData<List<Spotlight>> = MutableLiveData()
    val productsLiveData: MutableLiveData<List<Product>> = MutableLiveData()
    val cashLiveData: MutableLiveData<Cash> = MutableLiveData()

    val vfLiveDate: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    init {
        ApiService.service.dashboard().enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>,response: Response<DashboardResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { dashboardResponse ->

                        cash(dashboardResponse)
                        spotlight(dashboardResponse)
                        product(dashboardResponse)
                    }
                    vfLiveDate.value = Pair(VIEW_FLIPPER_SPOTILIGHT, null)
                } else if (response.code() == 401) {
                    vfLiveDate.value = Pair(VIEW_FLIPPER_ERROR, R.string.erro_401)
                } else {
                    vfLiveDate.value = Pair(VIEW_FLIPPER_ERROR, R.string.erro_400_generic)
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                vfLiveDate.value = Pair(VIEW_FLIPPER_ERROR, R.string.erro_500_generic)
            }
        })
    }

    private fun cash(dashboardResponse: DashboardResponse) {
        val cashResult = dashboardResponse.cashResult
        cashLiveData.value = Cash(
            cashResult.title,
            cashResult.bannerURL,
            cashResult.description
        )
    }

    private fun spotlight(dashboardResponse: DashboardResponse) {
        val sportlightMutableList: MutableList<Spotlight> = mutableListOf()
        val spotlightList = dashboardResponse.spotlightResult
        spotlightList.forEach {
            sportlightMutableList.add(
                Spotlight(
                    it.name,
                    it.URL,
                    it.descricao
                )
            )
        }
        sportlightLiveData.value = sportlightMutableList
    }

    private fun product(dashboardResponse: DashboardResponse) {
        val productMutableList: MutableList<Product> = mutableListOf()
        val productList = dashboardResponse.productsResult
        productList.forEach {
            productMutableList.add(
                Product(
                    it.name,
                    it.imageURL,
                    it.description
                )
            )
        }
        productsLiveData.value = productMutableList
    }

    companion object {
        private const val VIEW_FLIPPER_SPOTILIGHT = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}