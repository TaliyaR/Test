package com.example.rickandmortyapp.ui.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.entities.Result
import com.example.rickandmortyapp.entities.Status
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_character.*

class CharacterViewHolder(
    override val containerView: View,
    private val clickLambda: (Result) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(result: Result?) {
        tv_name.text = result?.name
        tv_status.text = result?.status
        tv_location.text = result?.location?.name
        tv_species.text = result?.species

        Glide.with(containerView.context).load(result?.image).centerCrop().into(iv_image)

        when(result?.status){
            Status.ALIVE.name -> iv_status.setColorFilter(R.color.teal_700)
            Status.DEAD.name -> iv_status.setColorFilter(R.color.red)
            Status.ALIVE.name -> iv_status.setColorFilter(R.color.yellow)
        }

        itemView.setOnClickListener { result?.let { it1 -> clickLambda(it1) } }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Result) -> Unit) = CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false),
            clickLambda
        )
    }
}