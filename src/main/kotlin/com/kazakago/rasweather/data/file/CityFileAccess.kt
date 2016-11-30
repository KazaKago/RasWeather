package com.kazakago.rasweather.data.file

import java.io.IOException


/**
 * Created by tamura_k on 2016/11/30.
 */
class CityFileAccess : FileAccess() {

    @Throws(IOException::class)
    fun readText(): String {
        return readAll("json/city.json")
    }

}