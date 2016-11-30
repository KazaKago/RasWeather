package com.kazakago.rasweather.domain.usecase

import com.kazakago.rasweather.domain.model.weather.ForecastModel
import com.kazakago.rasweather.domain.model.weather.WeatherModel
import com.kazakago.rasweather.domain.repository.WeatherRepository
import rx.Observable

/**
 * Created by tamura_k on 2016/11/11.
 */
class WeatherUseCaseImpl(private val weatherRepository: WeatherRepository) : WeatherUseCase {

    override fun fetch(cityId: String): Observable<WeatherModel> {
        return weatherRepository.fetch(cityId)
    }

    override fun getImageUri(forecast: ForecastModel): String? {
        if (forecast.telop == "晴" || forecast.telop == "晴れ") {
            return "images/54 Sun.png"
        } else if (forecast.telop == "晴れ時々曇り" || forecast.telop == "晴時々曇り" || forecast.telop == "晴れ時々曇" || forecast.telop == "晴時々曇") {
            return "images/28 Cloud Sun.png"
        } else if (forecast.telop == "晴れ時々雨" || forecast.telop == "晴時々雨") {
            return "images/31 Cloud Rain Sun.png"
        } else if (forecast.telop == "晴れ時々雪" || forecast.telop == "晴時々雪") {
            return "images/34 Cloud Snow Sun.png"
        } else if (forecast.telop == "晴れのち曇り" || forecast.telop == "晴のち曇り" || forecast.telop == "晴れのち曇" || forecast.telop == "晴のち曇") {
            return "images/28 Cloud Sun.png"
        } else if (forecast.telop == "晴れのち雨" || forecast.telop == "晴のち雨") {
            return "images/31 Cloud Rain Sun.png"
        } else if (forecast.telop == "晴れのち雪" || forecast.telop == "晴のち雪") {
            return "images/34 Cloud Snow Sun.png"
        } else if (forecast.telop == "曇り" || forecast.telop == "曇") {
            return "images/46 Clouds.png"
        } else if (forecast.telop == "曇り時々晴れ" || forecast.telop == "曇時々晴れ" || forecast.telop == "曇り時々晴" || forecast.telop == "曇時々晴") {
            return "images/28 Cloud Sun.png"
        } else if (forecast.telop == "曇り時々雨" || forecast.telop == "曇時々雨") {
            return "images/30 Cloud Rain.png"
        } else if (forecast.telop == "曇り時々雪" || forecast.telop == "曇時々雪") {
            return "images/33 Cloud Snow.png"
        } else if (forecast.telop == "曇りのち晴れ" || forecast.telop == "曇のち晴れ" || forecast.telop == "曇りのち晴" || forecast.telop == "曇のち晴") {
            return "images/28 Cloud Sun.png"
        } else if (forecast.telop == "曇りのち雨" || forecast.telop == "曇のち雨") {
            return "images/30 Cloud Rain.png"
        } else if (forecast.telop == "曇りのち雪" || forecast.telop == "曇のち雪") {
            return "images/33 Cloud Snow.png"
        } else if (forecast.telop == "雨") {
            return "images/62 Raindrops.png"
        } else if (forecast.telop == "雨時々晴れ" || forecast.telop == "雨時々晴") {
            return "images/31 Cloud Rain Sun.png"
        } else if (forecast.telop == "雨時々止む(曇り)" || forecast.telop == "雨時々止む(曇)" || forecast.telop == "雨時々止む" || forecast.telop == "雨時々曇り" || forecast.telop == "雨時々曇") {
            return "images/30 Cloud Rain.png"
        } else if (forecast.telop == "雨時々雪") {
            return "images/30 Cloud Rain.png"
        } else if (forecast.telop == "雨のち晴れ" || forecast.telop == "雨のち晴") {
            return "images/31 Cloud Rain Sun.png"
        } else if (forecast.telop == "雨のち曇り" || forecast.telop == "雨のち曇") {
            return "images/30 Cloud Rain.png"
        } else if (forecast.telop == "雨のち雪") {
            return "images/30 Cloud Rain.png"
        } else if (forecast.telop == "雨で暴風を伴う") {
            return "images/62 Raindrops.png"
        } else if (forecast.telop == "雪") {
            return "images/88 Snowflake.png"
        } else if (forecast.telop == "雪時々晴れ" || forecast.telop == "雪時々晴") {
            return "images/34 Cloud Snow Sun.png"
        } else if (forecast.telop == "雪時々止む(曇り)" || forecast.telop == "雪時々止む(曇)" || forecast.telop == "雪時々止む" || forecast.telop == "雪時々曇り" || forecast.telop == "雪時々曇") {
            return "images/33 Cloud Snow.png"
        } else if (forecast.telop == "雪時々雨") {
            return "images/33 Cloud Snow.png"
        } else if (forecast.telop == "雪のち晴れ" || forecast.telop == "雪のち晴") {
            return "images/34 Cloud Snow Sun.png"
        } else if (forecast.telop == "雪のち曇り" || forecast.telop == "雪のち曇") {
            return "images/33 Cloud Snow.png"
        } else if (forecast.telop == "雪のち雨") {
            return "images/33 Cloud Snow.png"
        } else if (forecast.telop == "暴風雪") {
            return "images/88 Snowflake.png"
        } else {
            return forecast.image?.url
        }
    }

}