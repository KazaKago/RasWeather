package com.kazakago.rasweather.di.module

import com.kazakago.rasweather.data.repository.CityRepositoryImpl
import com.kazakago.rasweather.data.repository.WeatherRepositoryImpl
import com.kazakago.rasweather.domain.repository.CityRepository
import com.kazakago.rasweather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tamura_k on 2016/11/11.
 */
@Module
class DataModule() {

    @Provides
    @Singleton
    fun provideWeatherRepository(): WeatherRepository {
        return WeatherRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCityRepository(): CityRepository {
        return CityRepositoryImpl()
    }

}