package com.kazakago.rasweather.di.module

import com.kazakago.rasweather.domain.repository.CityRepository
import com.kazakago.rasweather.domain.repository.WeatherRepository
import com.kazakago.rasweather.domain.usecase.CityUseCase
import com.kazakago.rasweather.domain.usecase.CityUseCaseImpl
import com.kazakago.rasweather.domain.usecase.WeatherUseCase
import com.kazakago.rasweather.domain.usecase.WeatherUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tamura_k on 2016/11/11.
 */
@Module
class DomainModule() {

    @Provides
    @Singleton
    fun provideWeatherUseCase(weatherRepository: WeatherRepository): WeatherUseCase {
        return WeatherUseCaseImpl(weatherRepository)
    }

    @Provides
    @Singleton
    fun provideCityUseCase(cityRepository: CityRepository): CityUseCase {
        return CityUseCaseImpl(cityRepository)
    }

}