package com.beok.chilten

enum class BottomNavigationType {
    HOME, BOWLING_GYM, CLUB, MY_BOWLING;

    companion object {
        fun findByOrdinal(ordinal: Int) = values()
            .first { it.ordinal == ordinal }
    }
}
