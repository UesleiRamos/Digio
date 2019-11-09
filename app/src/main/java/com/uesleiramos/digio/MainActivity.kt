package com.uesleiramos.digio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uesleiramos.digio.presentation.DashboardViewModel
import com.uesleiramos.digio.presentation.product.ProductAdapter
import com.uesleiramos.digio.presentation.spotlight.SpotlightAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.digio_cash.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        viewModel.cashLiveData.observe(this, Observer {
            val url = it.bannerURL

            Glide.with(this)
                .load(url)
                .into(img_cash)
        })

        viewModel.productsLiveData.observe(this, Observer { products ->
            recycleProducts.apply {
                this.layoutManager =  LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = ProductAdapter(products)
            }
        })

        viewModel.vfLiveDate.observe(this, Observer {
                        it?.let { viewFlipper ->
                view_flipper_product.displayedChild = viewFlipper.first

                viewFlipper.second?.let { erroMessagerResId ->
                    text_erro_product.text = getString(erroMessagerResId)
                }
            }
        })

        viewModel.sportlightLiveData.observe(this, Observer {
            recycleSpotlight.apply {
                this.layoutManager =  LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = SpotlightAdapter(it)
            }
        })

        viewModel.vfLiveDate.observe(this, Observer {
            it?.let { viewFlipper ->
                view_flipper_spotlight.displayedChild = viewFlipper.first

                viewFlipper.second?.let { erroMessagerResId ->
                    text_erro_spotlight.text = getString(erroMessagerResId)

                }
            }
        })
    }
}
