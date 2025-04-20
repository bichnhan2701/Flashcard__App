package com.example.flashlearn.data.local

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromIntList(list: List<Int>): String {
        return list.joinToString(",") // Chuyển List<Int> thành String
    }

    @TypeConverter
    fun toIntList(data: String): List<Int> {
        return if (data.isEmpty()) emptyList() else data.split(",").map { it.toInt() } // Chuyển String thành List<Int>
    }
}