package com.kazakago.rasweather.di.module

import dagger.Module
import dagger.Provides
import com.kazakago.rasweather.domain.repository.WeatherRepository
import com.kazakago.rasweather.domain.usecase.WeatherUseCase
import com.kazakago.rasweather.domain.usecase.WeatherUseCaseImpl
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

}