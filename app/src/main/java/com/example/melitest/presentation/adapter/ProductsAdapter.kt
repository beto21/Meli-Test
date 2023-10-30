package com.example.melitest.presentation.adapter

import androidx.paging.PagingData
import com.example.melitest.base.BasePageAdapter
import com.example.melitest.base.BaseViewHolder
import com.example.melitest.databinding.ItemProductBinding
import com.example.melitest.model.Product
import com.example.melitest.presentation.viewholder.ProductViewHolder

class ProductsAdapter(override val onItemClicked: (data: Product) -> Unit) :
    BasePageAdapter<Product,
            ItemProductBinding>(ItemProductBinding::inflate) {


    override suspend fun set(data: PagingData<Product>) {
        submitData(data)
    }

    override fun viewHolder(binding: ItemProductBinding): BaseViewHolder<Product> {
        return ProductViewHolder(binding) { getItem(it)?.let { it1 -> onItemClicked(it1) } }
    }
}



