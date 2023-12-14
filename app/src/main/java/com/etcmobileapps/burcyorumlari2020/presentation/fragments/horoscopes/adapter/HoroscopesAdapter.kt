package com.etcmobileapps.burcyorumlari2020.presentation.fragments.horoscopes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.etcmobileapps.burcyorumlari2020.databinding.HoroscopeItemBinding
import com.etcmobileapps.burcyorumlari2020.domain.model.HoroscopeModel
import com.squareup.picasso.Picasso


class HoroscopesAdapter(private val horoscopeList: List<HoroscopeModel>, private val onItemClicked: (HoroscopeModel) -> Unit) : RecyclerView.Adapter<HoroscopesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = HoroscopeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentHoroscope = horoscopeList.get(position)

        // Set Item Specs
        Picasso.get().load(currentHoroscope.horoscopeImage).into(holder.itemBinding.horoscopeIV);
        holder.itemBinding.horoscopeNameTV.text = currentHoroscope.horoscopeName

        //Responsive Witdh & Height
        val screenWidth = holder.itemView.resources.displayMetrics.widthPixels
        val scaledWidth = screenWidth / 3

        val screenHeight = holder.itemView.resources.displayMetrics.heightPixels
        val scaledHeight = screenHeight / 4.7

        holder.itemBinding.itemModelView.layoutParams.width = scaledWidth.toInt()
        holder.itemBinding.itemModelView.layoutParams.height = scaledHeight.toInt()

        // Set OnClick
        holder.itemBinding.itemModelView.setOnClickListener {
            onItemClicked(currentHoroscope)
        }
    }

    override fun getItemCount(): Int {
        return horoscopeList.size
    }

    class ViewHolder(val itemBinding: HoroscopeItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    }
}