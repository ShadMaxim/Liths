package com.example.serenitysoul.data.mappers

import com.example.serenitysoul.data.enums.Space

class SpaceMapper {
    companion object{
        fun spaceMapToEnum(space: String): Space {
            return when (space) {
                "MIDDLE" -> Space.MIDDLE
                "TOP" -> Space.TOP
                else -> {
                    Space.DOWN
                }
            }
        }
    }
}