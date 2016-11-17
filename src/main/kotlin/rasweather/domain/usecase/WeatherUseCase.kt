package rasweather.domain.usecase

import rasweather.domain.model.ForecastModel
import rasweather.domain.model.WeatherModel
import rx.Observable

/**
 * Created by tamura_k on 2016/11/11.
 */
interface WeatherUseCase {

    fun fetch(cityId: String): Observable<WeatherModel>

    fun getImageUri(forecast: ForecastModel): String?

}