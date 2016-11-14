package domain.usecase

import domain.model.Weather
import domain.repository.WeatherRepository
import rx.Observable

/**
 * Created by tamura_k on 2016/11/11.
 */
class WeatherUseCaseImpl(val weatherRepository: WeatherRepository) : WeatherUseCase {

    override fun fetch(cityId: String): Observable<Weather> {
        return weatherRepository.fetch(cityId)
    }

}