package com.uesleiramos.digio.presentation.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uesleiramos.digio.R
import com.uesleiramos.digio.data.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductAdapter.ProductViewHolder(itemView)
    }

    override fun getItemCount() = products.count()

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        return holder.bindView(products[position])
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val url = view.img_product

        fun bindView(product: Product) {
            Glide
                .with(itemView)
                .load(product.imageURL)
                //.placeholder(R.drawable.loading_spinner)
                .into(url)
        }
    }
}