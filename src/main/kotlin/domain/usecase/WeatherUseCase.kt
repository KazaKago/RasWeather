package domain.usecase

import domain.model.Weather
import rx.Observable

/**
 * Created by tamura_k on 2016/11/11.
 */
interface WeatherUseCase {

    fun fetch(cityId: String): Observable<Weather>

}