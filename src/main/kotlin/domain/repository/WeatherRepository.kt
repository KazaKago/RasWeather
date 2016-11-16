package domain.repository

import domain.model.WeatherModel
import rx.Observable

/**
 * Created by weath on 2016/11/15.
 */
interface WeatherRepository {

    fun fetch(cityId: String): Observable<WeatherModel>

}