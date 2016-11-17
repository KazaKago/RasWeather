package rasweather.data.repository

import rasweather.data.api.WeatherApi
import rasweather.data.api.WeatherRetrofit
import rasweather.domain.model.WeatherModel
import rasweather.domain.repository.WeatherRepository
import rx.Observable

/**
 * Created by weath on 2016/11/15.
 */
class WeatherRepositoryImpl() : WeatherRepository {

    override fun fetch(cityId: String): Observable<WeatherModel> {
        val retrofit = WeatherRetrofit.instance
        val weatherApi = retrofit.create(WeatherApi::class.java)
        return weatherApi[cityId]
    }

}