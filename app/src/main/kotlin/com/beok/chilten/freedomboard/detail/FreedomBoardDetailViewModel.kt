package com.beok.chilten.freedomboard.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beok.chilten.domain.ChiltenRepository
import com.beok.chilten.domain.common.Params
import kotlinx.coroutines.launch

class FreedomBoardDetailViewModel @ViewModelInject constructor(
    private val chiltenRepository: ChiltenRepository
) : ViewModel() {

    private val _freedomBoardDetailItem = MutableLiveData<FreedomBoardDetailItem>()
    val freedomBoardDetailItem: LiveData<FreedomBoardDetailItem> get() = _freedomBoardDetailItem

    fun fetchFreedomBoardDetail(boardIdx: Int, postIdx: Int) = viewModelScope.launch {
        val response = chiltenRepository.fetchFreedomBoardDetail(
            params = Params(boardIdx = boardIdx, postIdx = postIdx)
        )

        _freedomBoardDetailItem.value = FreedomBoardDetailItem.toItem(response)
    }
}
