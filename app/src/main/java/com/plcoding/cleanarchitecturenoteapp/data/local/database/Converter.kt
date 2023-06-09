package com.plcoding.cleanarchitecturenoteapp.data.local.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.plcoding.cleanarchitecturenoteapp.domain.model.WordInfor
import com.plcoding.cleanarchitecturenoteapp.domain.model.WordOfLesson

class Converter {
    @TypeConverter
    fun fromVocabluaryJson(json: String): ArrayList<WordInfor> {
        val listType = object : TypeToken<List<WordInfor>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toVocabularyJson(list: ArrayList<WordInfor>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
    @TypeConverter
    fun fromJson(json: String): ArrayList<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toJson(list: ArrayList<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromJson_WordOfLesson(json: String): List<WordOfLesson> {
        val listType = object : TypeToken<List<WordOfLesson>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toJson_WordOfLesson(list: List<WordOfLesson>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}