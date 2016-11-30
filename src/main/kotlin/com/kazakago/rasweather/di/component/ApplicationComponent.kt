package com.kazakago.rasweather.di.component

import com.kazakago.rasweather.di.module.ApplicationModule
import com.kazakago.rasweather.di.module.DataModule
import com.kazakago.rasweather.di.module.DomainModule
import com.kazakago.rasweather.presentation.controller.SettingsController
import com.kazakago.rasweather.presentation.controller.WeatherController
import dagger.Component
import javax.inject.Singleton

/**
 * Created by tamura_k on 2016/11/11.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DomainModule::class, DataModule::class))
interface ApplicationComponent {

    fun inject(weatherController: WeatherController)

    fun inject(settingsController: SettingsController)

}
