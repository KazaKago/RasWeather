package com.kazkago.rasweather.data.api

import com.kazkago.rasweather.domain.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by weath on 2016/11/15.
 */
interface WeatherApi {

    @GET("json/v1")
    operator fun get(@Query("city") cityId: String): Observable<WeatherModel>

}