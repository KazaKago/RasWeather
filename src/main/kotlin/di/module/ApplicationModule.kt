package di.module

import dagger.Module
import WeatherApplication

/**
 * Created by tamura_k on 2016/11/11.
 */
@Module
class ApplicationModule(private val cleanApplication: WeatherApplication) {

//    @Provides
//    @Singleton
//    fun provideApplicationContext(): Context {
//        return cleanApplication.getApplicationContext()
//    }

}