package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.ForecastModel
import com.kazakago.rasweather.domain.model.WeatherModel
import rx.Observable

/**
 * Created by tamura_k on 2016/11/11.
 */
interface WeatherUseCase {

    fun fetch(cityId: String): Observable<WeatherModel>

    fun getImageUri(forecast: ForecastModel): String?

}