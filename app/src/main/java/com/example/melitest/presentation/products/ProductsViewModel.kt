package com.example.melitest.presentation.products

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.melitest.base.BaseViewModel
import com.example.melitest.data.repository.ProductsRepository
import com.example.melitest.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : BaseViewModel() {


    private val _productsFlow = MutableStateFlow<UIState>(UIState.Empty)
    val productsFlow: StateFlow<UIState> = _productsFlow.asStateFlow()


    fun getProducts(query: String) {
        _productsFlow.value = UIState.Loading
        viewModelScope.launch {
            productsRepository.search(query).cachedIn(viewModelScope).catch {
                _productsFlow.value = UIState.Error(it.message)
            }.collect {
                _productsFlow.value = UIState.Success(it)
            }
        }
    }


}