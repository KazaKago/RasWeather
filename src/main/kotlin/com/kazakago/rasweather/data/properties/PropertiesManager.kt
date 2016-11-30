package com.kazakago.rasweather.data.properties

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

/**
 * Created by weath on 2016/12/01.
 */
abstract class PropertiesManager {

    protected val properties = Properties()
    open protected var savePath = "properties/" + javaClass

    init {
        try {
            load()
        } catch (e: IOException) {
        }
    }

    @Throws(IOException::class)
    public fun load() {
        properties.load(FileInputStream(savePath))
    }

    @Throws(IOException::class)
    public fun store() {
        properties.store(FileOutputStream(savePath), null)
    }

}