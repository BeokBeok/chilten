package com.beok.chilten.freedomboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beok.chilten.domain.ChiltenRepository
import com.beok.chilten.domain.freedomboard.Params
import kotlinx.coroutines.launch

class FreedomBoardViewModel @ViewModelInject constructor(
    private val chiltenRepository: ChiltenRepository
) : ViewModel() {

    private val _freedomBoardList = MutableLiveData<List<FreedomBoardItem>>()
    val freedomBoardList: LiveData<List<FreedomBoardItem>> get() = _freedomBoardList

    fun fetchFreedomBoard(page: Int = 1) = viewModelScope.launch {
        _freedomBoardList.value = chiltenRepository
            .fetchFreedomBoard(Params(boardIdx = 2, page = page))
            .data
            .map(FreedomBoardItem::toItem)
    }
}
