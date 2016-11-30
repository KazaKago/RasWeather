package com.kazakago.rasweather.domain.repository

import com.kazakago.rasweather.domain.model.city.CityModel
import com.oracle.javafx.jmx.json.JSONException
import java.io.IOException


/**
 * Created by tamura_k on 2016/11/30.
 */
interface CityRepository {

    @Throws(IOException::class, JSONException::class)
    fun findAll(): List<CityModel>

}