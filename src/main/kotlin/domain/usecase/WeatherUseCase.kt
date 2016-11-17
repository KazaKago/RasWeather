package domain.usecase

import domain.model.ForecastModel
import domain.model.WeatherModel
import rx.Observable

/**
 * Created by tamura_k on 2016/11/11.
 */
interface WeatherUseCase {

    fun fetch(cityId: String): Observable<WeatherModel>

    fun getImageUri(forecast: ForecastModel): String?

}