package com.beok.chilten.freedomboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beok.chilten.domain.ChiltenRepository
import com.beok.chilten.domain.freedomboard.FreedomBoardResponse
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
            .also(::setupIfLastPage)
        cachedFreedomBoardGroup += FreedomBoardGroup.toGroup(response)
        _freedomBoardGroup.value = cachedFreedomBoardGroup
    }

    private fun setupIfLastPage(response: FreedomBoardResponse) {
        if (response.length == 0 && response.params.page > 1) isLastPage = true
    }

    fun getFreedomBoardCount() = _freedomBoardGroup.value?.length ?: 0

    fun getCurrentPage() = _freedomBoardGroup.value?.page ?: 0
}
