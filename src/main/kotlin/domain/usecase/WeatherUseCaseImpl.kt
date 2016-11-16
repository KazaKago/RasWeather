package domain.usecase

import domain.model.WeatherModel
import domain.repository.WeatherRepository
import rx.Observable

/**
 * Created by tamura_k on 2016/11/11.
 */
class WeatherUseCaseImpl(private val weatherRepository: WeatherRepository) : WeatherUseCase {

    override fun fetch(cityId: String): Observable<WeatherModel> {
        return weatherRepository.fetch(cityId)
    }

}