package com.kazakago.rasweather.domain.repository

import com.kazakago.rasweather.domain.model.weather.WeatherModel
import io.reactivex.Single

/**
 * Created by weath on 2016/11/15.
 */
interface WeatherRepository {

    fun fetch(cityId: String): Single<WeatherModel>

}