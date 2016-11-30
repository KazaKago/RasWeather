package com.kazakago.rasweather.data.properties

/**
 * Created by weath on 2016/12/01.
 */
class AppPropertiesManager : PropertiesManager() {

    val CITY_ID = "city_id"

    public fun getCityId(): String {
        return properties.getProperty(CITY_ID)
    }

    public fun setCityId(cityId: String) {
        properties.setProperty(CITY_ID, cityId)
    }

}