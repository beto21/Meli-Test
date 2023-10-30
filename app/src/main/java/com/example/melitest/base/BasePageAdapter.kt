package com.example.melitest.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter

abstract class BasePageAdapter<T : Any, VB>(private val inflate: Inflate<VB>) :
    PagingDataAdapter<T, BaseViewHolder<T>>(BaseAdapter.BaseItemCallback()) {
    abstract val onItemClicked: (data: T) -> Unit

    abstract suspend fun set(data: PagingData<T>)

    protected abstract fun viewHolder(binding: VB): BaseViewHolder<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = inflate.invoke(layoutInflater, parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        getItem(position)?.let { holder.bindTo(it) }
    }
}