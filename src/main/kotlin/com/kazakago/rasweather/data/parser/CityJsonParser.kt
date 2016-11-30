package com.kazakago.rasweather.data.parser

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kazakago.rasweather.data.entity.city.PrefEntity
import com.oracle.javafx.jmx.json.JSONException


/**
 * Created by tamura_k on 2016/11/30.
 */
class CityJsonParser {

    @Throws(JSONException::class)
    fun parse(jsonStr: String): List<PrefEntity> {
        val gson = Gson()
        val entityList = gson.fromJson<List<PrefEntity>>(jsonStr, object : TypeToken<List<PrefEntity>>() {
        }.type)

        return entityList
    }

}