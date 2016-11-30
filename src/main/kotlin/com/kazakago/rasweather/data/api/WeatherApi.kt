package com.kazakago.rasweather.data.api

import com.kazakago.rasweather.data.entity.weather.WeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by weath on 2016/11/15.
 */
interface WeatherApi {

    @GET("json/v1")
    operator fun get(@Query("city") cityId: String): Observable<WeatherEntity>

}