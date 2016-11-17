package rasweather.di.module

import dagger.Module
import dagger.Provides
import rasweather.data.repository.WeatherRepositoryImpl
import rasweather.domain.repository.WeatherRepository
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