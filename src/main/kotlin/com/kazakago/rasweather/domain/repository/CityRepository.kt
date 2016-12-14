package com.kazakago.rasweather.domain.repository

import com.kazakago.rasweather.domain.model.city.CityModel
import io.reactivex.Observable
import io.reactivex.Single
import java.io.IOException

/**
 * Created by tamura_k on 2016/11/30.
 */
interface CityRepository {

    @Throws(IOException::class)
    fun findAll(): Observable<CityModel>

    @Throws(IOException::class)
    fun getCityId(): Single<String>

    @Throws(IOException::class)
    fun setCityId(cityId: String)

}