package com.example.melitest.presentation.products

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import com.example.melitest.base.BaseFragment
import com.example.melitest.databinding.FragmentProductsBinding
import com.example.melitest.extensions.collectLastestLyfeCycleFlow
import com.example.melitest.extensions.showToast
import com.example.melitest.model.Product
import com.example.melitest.presentation.LoadStateAdapter
import com.example.melitest.presentation.adapter.ProductsAdapter
import com.example.melitest.utils.UIState
import com.example.melitest.utils.decoration.SpaceItemDecorationVertical
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ProductsFragment
    : BaseFragment<ProductsViewModel,
        FragmentProductsBinding>(FragmentProductsBinding::inflate) {
    override val vm: ProductsViewModel by viewModels()
    override val TAG: String = ProductsFragment::class.java.name

    private val moviePageAdapter by lazy {
        ProductsAdapter { product: Product ->
            val action = ProductsFragmentDirections.actionProductsFragmentToDetailFragment(product)
            findNavController().navigate(action)
        }
    }

    companion object {
        const val KEY_SEARCH = "search"
    }

    private var query: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            query = it.getString(KEY_SEARCH) ?: ""
        }
    }


    override fun setupUI() {
        super.setupUI()
        initRecyclerview()
        initSearch()
    }


    private fun initSearch() {
        binding.toolbar.menuSearchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                vm.getProducts(query ?: "")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true

            }

        })
    }


    private fun initRecyclerview() {
        moviePageAdapter.withLoadStateFooter(footer = LoadStateAdapter())
        binding.recycler.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(8)
            addItemDecoration(SpaceItemDecorationVertical(32))
            adapter = moviePageAdapter
        }


    }


    override fun setupVM() {
        super.setupVM()
        observerPage()


    }


    @Suppress("UNCHECKED_CAST")
    private fun observerPage() {
        requireActivity().collectLastestLyfeCycleFlow(vm.productsFlow) { uiState ->
            when (uiState) {
                is UIState.Success<*> -> {
                    binding.itemProgressBar.visibility = View.GONE
                    moviePageAdapter.submitData((uiState.data as PagingData<Product>))
                }

                is UIState.Loading -> {
                    binding.itemProgressBar.visibility = View.VISIBLE

                }

                is UIState.Error -> {
                    binding.itemProgressBar.visibility = View.GONE
                    uiState.message?.let { requireActivity().showToast(it) }
                }

                else -> {}


            }

        }
    }


}