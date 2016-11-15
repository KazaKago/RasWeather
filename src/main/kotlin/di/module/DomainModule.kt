package di.module

import dagger.Module
import dagger.Provides
import domain.repository.WeatherRepository
import domain.usecase.WeatherUseCase
import domain.usecase.WeatherUseCaseImpl
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