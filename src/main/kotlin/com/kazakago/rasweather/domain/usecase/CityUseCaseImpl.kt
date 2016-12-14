package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.city.CityModel
import com.kazakago.rasweather.domain.repository.CityRepository
import io.reactivex.Observable
import io.reactivex.Single
import java.io.IOException

/**
 * City UseCase Implement
 *
 * @author Kensuke
 */
class CityUseCaseImpl(private val cityRepository: CityRepository) : CityUseCase {

    @Throws(IOException::class)
    override fun findAll(): Observable<CityModel> {
        return cityRepository.findAll()
    }

    @Throws(IOException::class)
    override fun getCityId(): Single<String> {
        return cityRepository.getCityId()
    }

    @Throws(IOException::class)
    override fun setCityId(cityId: String) {
        cityRepository.setCityId(cityId)
    }

}
