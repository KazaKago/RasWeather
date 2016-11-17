package com.kazkago.rasweather.di.component

import dagger.Component
import com.kazkago.rasweather.di.module.ApplicationModule
import com.kazkago.rasweather.di.module.DataModule
import com.kazkago.rasweather.di.module.DomainModule
import com.kazkago.rasweather.presentation.controller.WeatherController
import javax.inject.Singleton

/**
 * Created by tamura_k on 2016/11/11.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DomainModule::class, DataModule::class))
interface ApplicationComponent {

    fun inject(weatherController: WeatherController)

}
