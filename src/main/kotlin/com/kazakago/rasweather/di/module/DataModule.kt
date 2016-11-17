package com.kazakago.rasweather.di.module

import dagger.Module
import dagger.Provides
import com.kazakago.rasweather.data.repository.WeatherRepositoryImpl
import com.kazakago.rasweather.domain.repository.WeatherRepository
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

}