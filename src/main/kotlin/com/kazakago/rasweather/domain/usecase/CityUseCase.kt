package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.city.CityModel
import rx.Observable
import java.io.IOException


/**
 * City UseCase
 *
 * @author Kensuke
 */
interface CityUseCase {

    @Throws(IOException::class)
    fun findAll(): Observable<CityModel>

    @Throws(IOException::class)
    fun getCityId(): Observable<String>

    @Throws(IOException::class)
    fun setCityId(cityId: String)

}