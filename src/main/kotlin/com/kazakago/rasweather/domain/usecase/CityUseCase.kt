package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.city.CityModel
import io.reactivex.Observable
import io.reactivex.Single
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
    fun getCityId(): Single<String>

    @Throws(IOException::class)
    fun setCityId(cityId: String)

}