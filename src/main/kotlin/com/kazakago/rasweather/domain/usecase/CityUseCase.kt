package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.city.CityModel
import com.oracle.javafx.jmx.json.JSONException
import java.io.IOException


/**
 * City UseCase
 *
 * @author Kensuke
 */
interface CityUseCase {

    @Throws(IOException::class, JSONException::class)
    fun findAll(): List<CityModel>

}