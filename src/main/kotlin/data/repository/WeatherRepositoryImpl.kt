package data.repository

import data.api.WeatherApi
import data.api.WeatherRetrofit
import domain.model.WeatherModel
import domain.repository.WeatherRepository
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