package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.weather.ForecastModel
import com.kazakago.rasweather.domain.model.weather.WeatherModel
import io.reactivex.Single

/**
 * Created by tamura_k on 2016/11/11.
 */
interface WeatherUseCase {

    fun fetch(cityId: String): Single<WeatherModel>

    fun getImageUri(forecast: ForecastModel): String?

}