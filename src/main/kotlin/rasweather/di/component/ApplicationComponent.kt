package rasweather.di.component

import dagger.Component
import rasweather.di.module.ApplicationModule
import rasweather.di.module.DataModule
import rasweather.di.module.DomainModule
import rasweather.presentation.controller.WeatherController
import javax.inject.Singleton

/**
 * Created by tamura_k on 2016/11/11.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DomainModule::class, DataModule::class))
interface ApplicationComponent {

    fun inject(weatherController: WeatherController)

}
