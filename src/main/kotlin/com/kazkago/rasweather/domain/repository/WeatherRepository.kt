package com.kazkago.rasweather.domain.repository

import com.kazkago.rasweather.domain.model.WeatherModel
import rx.Observable

/**
 * Created by weath on 2016/11/15.
 */
interface WeatherRepository {

    fun fetch(cityId: String): Observable<WeatherModel>

}