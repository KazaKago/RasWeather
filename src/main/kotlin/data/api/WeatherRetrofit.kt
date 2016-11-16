package data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by weath on 2016/11/15.
 */
object WeatherRetrofit {

    val instance: Retrofit
        get() = Retrofit.Builder()
                .baseUrl("http://weather.livedoor.com/forecast/webservice/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
}
