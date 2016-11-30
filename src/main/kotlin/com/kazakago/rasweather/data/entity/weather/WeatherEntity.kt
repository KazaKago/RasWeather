package com.kazakago.rasweather.data.entity.weather

/**
 * Weather Entity
 *
 *
 * Created by tamura_k on 2016/05/31.
 */
class WeatherEntity {

    //地域ID
    var cityId: String? = null

    //予報を発表した地域を定義
    var location: LocationEntity? = null
    //タイトル・見出し
    var title: String? = null
    //リクエストされたデータの地域に該当するlivedoor 天気情報のURL
    var link: String? = null
    //予報の発表日時
    var publicTime: String? = null
    //天気概況文
    var description: DescriptionEntity? = null
    //府県天気予報の予報日毎の配列
    var forecasts: List<ForecastEntity>? = null
    //ピンポイント予報の発表地点の配列
    var pinpointLocations: List<LinkEntity>? = null
    //コピーライト
    var copyright: CopyrightEntity? = null

}
