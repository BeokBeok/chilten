package com.beok.chilten.freedomboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beok.chilten.domain.ChiltenRepository
import com.beok.chilten.domain.freedomboard.Params
import kotlinx.coroutines.launch

class FreedomBoardViewModel @ViewModelInject constructor(
    private val chiltenRepository: ChiltenRepository
) : ViewModel() {

    private val _freedomBoardGroup = MutableLiveData<FreedomBoardGroup>()

    val freedomBoardList: LiveData<List<FreedomBoardItem>> =
        Transformations.map(_freedomBoardGroup) {
            it.data
        }

    private var cachedFreedomBoardGroup: FreedomBoardGroup = FreedomBoardGroup()
    private var isLastPage = false

    fun fetchFreedomBoard(page: Int = 1) = viewModelScope.launch {
        if (isLastPage) return@launch
        val response = chiltenRepository
            .fetchFreedomBoard(Params(boardIdx = 2, page = page))
            .also {
                if (it.length == 0 && it.params.page > 1) isLastPage = true
            }
        if (page == 1 && cachedFreedomBoardGroup.data.isEmpty()) {
            FreedomBoardGroup.toGroup(response).let {
                cachedFreedomBoardGroup = it
                _freedomBoardGroup.value = it
            }
            return@launch
        }
        val freedomBoardGroup = FreedomBoardGroup.toGroup(response)
        cachedFreedomBoardGroup += freedomBoardGroup
        _freedomBoardGroup.value = cachedFreedomBoardGroup
    }

    fun getFreedomBoardCount() = _freedomBoardGroup.value?.length ?: 0

    fun getCurrentPage() = _freedomBoardGroup.value?.page ?: 0
}
