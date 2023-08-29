package com.example.serenitysoul.data.mappers

import com.example.serenitysoul.data.enums.Colors

class ColorMapper {
    companion object{
        fun colorMapToEnum(color: String): Colors {
            return when (color) {
                "ORANGE" -> Colors.ORANGE
                "YELLOW" -> Colors.YELLOW
                "GREEN" -> Colors.GREEN
                else -> {
                    Colors.BLUE
                }
            }
        }
    }
}