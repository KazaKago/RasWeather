package di.component

import dagger.Component
import di.module.ApplicationModule
import di.module.DataModule
import di.module.DomainModule
import WeatherApplication
import javax.inject.Singleton

/**
 * Created by tamura_k on 2016/11/11.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DomainModule::class, DataModule::class))
interface ApplicationComponent {

    fun inject(weatherApplication: WeatherApplication)

}
