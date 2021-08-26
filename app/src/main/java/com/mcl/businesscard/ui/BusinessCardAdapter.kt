package com.mcl.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mcl.businesscard.data.BusinessCardEntity
import com.mcl.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter : ListAdapter<BusinessCardEntity, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: BusinessCardEntity){
            binding.tvNome.text = item.name
            binding.tvTelefone.text = item.phone
            binding.tvEmail.text = item.email
            binding.tvEmpresa.text = item.company
  //          binding.cardContent.setBackgroundColor(Color.parseColor(item.customBackground))
            binding.cardContent.setOnClickListener{
                listenerShare(it)
            }
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<BusinessCardEntity>(){
    override fun areItemsTheSame(
        oldItem: BusinessCardEntity,
        newItem: BusinessCardEntity
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: BusinessCardEntity,
        newItem: BusinessCardEntity
    ) = oldItem.id == newItem.id
}