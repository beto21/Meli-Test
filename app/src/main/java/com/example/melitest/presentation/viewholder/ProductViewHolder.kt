package com.example.melitest.presentation.viewholder

import com.example.melitest.base.BaseViewHolder
import com.example.melitest.databinding.ItemProductBinding
import com.example.melitest.model.Product

class ProductViewHolder(
    private val binding: ItemProductBinding,
    override val onClick: (data: Int) -> Unit
) : BaseViewHolder<Product>(binding) {
    override fun bindTo(data: Product) {
        binding.product = data
        itemView.setOnClickListener { onClick(bindingAdapterPosition) }
        binding.executePendingBindings()
    }
}