package com.uesleiramos.digio.presentation.spotlight

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uesleiramos.digio.R
import com.uesleiramos.digio.data.model.Spotlight
import kotlinx.android.synthetic.main.item_spotlight.view.*

class SpotlightAdapter(
    private val spotlights: List<Spotlight>
) : RecyclerView.Adapter<SpotlightAdapter.SpotlightViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotlightViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_spotlight, parent, false)
        return SpotlightViewHolder(itemView)
    }

    override fun getItemCount() = spotlights.count()

    override fun onBindViewHolder(holder: SpotlightViewHolder, position: Int) {
        return holder.bindView(spotlights[position])
    }

    class SpotlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val bannerURL = view.img_spotlight

        fun bindView(spotlights: Spotlight) {

            Glide
                .with(itemView)
                .load(spotlights.bannerURL)
                //.placeholder(R.drawable.loading_spinner)
                .into(bannerURL)
        }
    }
}
