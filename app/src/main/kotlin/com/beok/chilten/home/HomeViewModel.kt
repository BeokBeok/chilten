package com.beok.chilten.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beok.chilten.domain.ChiltenRepository
import com.beok.chilten.domain.banner.BannerRequest
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val chiltenRepository: ChiltenRepository
) : ViewModel() {

    private val _bannerUrlList = MutableLiveData<List<String>>()
    val bannerUrlList: LiveData<List<String>> get() = _bannerUrlList

    fun fetchBannerUrlList() = viewModelScope.launch {
        val response = chiltenRepository.fetchBanner(BannerRequest(location = "MB"))
        _bannerUrlList.value = response.data
            .map {
                "${PREFIX_BANNER_IMAGE_URL}/${it.imagePath.removePrefix("//")}"
            }
    }

    companion object {
        private const val PREFIX_BANNER_IMAGE_URL = "https://m.chilten.com/upload/image"
    }
}
