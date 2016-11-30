package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.city.CityModel
import com.kazakago.rasweather.domain.repository.CityRepository
import com.oracle.javafx.jmx.json.JSONException
import java.io.IOException


/**
 * City UseCase Implement
 *
 * @author Kensuke
 */
class CityUseCaseImpl(private val cityRepository: CityRepository) : CityUseCase {

    @Throws(IOException::class, JSONException::class)
    override fun findAll(): List<CityModel> {
        return cityRepository.findAll()
    }

}
