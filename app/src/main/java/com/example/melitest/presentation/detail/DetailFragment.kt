package com.example.melitest.presentation.detail

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.melitest.base.BaseFragment
import com.example.melitest.databinding.FragmentDetailBinding
import com.example.melitest.model.Product
import com.example.melitest.presentation.detail.DetailFragmentArgs.Companion.fromBundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailFragment :
    BaseFragment<ProductDetailViewModel, FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    override val vm: ProductDetailViewModel by viewModels()
    override val TAG: String = DetailFragment::class.java.name
    var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            product = fromBundle(it).product
        }
    }


    override fun setupUI() {
        super.setupUI()
        binding.product = product
    }


}