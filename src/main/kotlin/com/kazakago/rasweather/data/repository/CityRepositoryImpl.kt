package com.kazakago.rasweather.data.repository

import com.kazakago.rasweather.data.file.CityFileAccess
import com.kazakago.rasweather.data.parser.CityJsonParser
import com.kazakago.rasweather.data.properties.AppPropertiesManager
import com.kazakago.rasweather.domain.model.city.CityModel
import com.kazakago.rasweather.domain.repository.CityRepository
import io.reactivex.Observable
import io.reactivex.Single
import java.io.IOException
import java.util.*

/**
 * Created by tamura_k on 2016/11/30.
 */
class CityRepositoryImpl : CityRepository {

    @Throws(IOException::class)
    override fun findAll(): Observable<CityModel> {
        val cityModelList = ArrayList<CityModel>()

        val cityFileAccess = CityFileAccess()
        val cityJsonParser = CityJsonParser()

        val cityJsonStr = cityFileAccess.readText()
        val prefEntityList = cityJsonParser.parse(cityJsonStr)
        prefEntityList.forEach({
            val prefTitle = it.title
            it.cityList?.forEach {
                val cityModel = CityModel()
                cityModel.id = it.id
                cityModel.name = prefTitle + " " + it.title
                cityModelList.add(cityModel)
            }
        })

        return Observable.fromIterable(cityModelList)
    }

    @Throws(IOException::class)
    override fun getCityId(): Single<String> {
        val appPropertiesManager = AppPropertiesManager()
        return Single.create {
            it.onSuccess(appPropertiesManager.getCityId())
        }
    }

    @Throws(IOException::class)
    override fun setCityId(cityId: String) {
        val appPropertiesManager = AppPropertiesManager()
        appPropertiesManager.setCityId(cityId)
        appPropertiesManager.store()
    }

}