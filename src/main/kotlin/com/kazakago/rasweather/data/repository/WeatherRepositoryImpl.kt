package com.kazakago.rasweather.data.repository

import com.kazakago.rasweather.data.api.WeatherApi
import com.kazakago.rasweather.data.api.WeatherRetrofit
import com.kazakago.rasweather.domain.model.weather.WeatherModel
import com.kazakago.rasweather.domain.repository.WeatherRepository
import io.reactivex.Single
import org.modelmapper.ModelMapper

/**
 * Created by weath on 2016/11/15.
 */
class WeatherRepositoryImpl() : WeatherRepository {

    override fun fetch(cityId: String): Single<WeatherModel> {
        val retrofit = WeatherRetrofit.instance
        val weatherApi = retrofit.create(WeatherApi::class.java)
        val modelMapper = ModelMapper()
        return weatherApi[cityId]
                .map { weatherEntity -> modelMapper.map(weatherEntity, WeatherModel::class.java) }
    }

}