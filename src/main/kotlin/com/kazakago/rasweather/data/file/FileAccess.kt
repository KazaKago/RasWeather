package com.kazakago.rasweather.data.file

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/**
 * Created by tamura_k on 2016/11/30.
 */
abstract class FileAccess {

    @Throws(IOException::class)
    fun readAll(path: String): String {
        val stream = this.javaClass.classLoader.getResourceAsStream(path)
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
            val strBuilder = StringBuilder()
            var str = reader.readLine()
            while (str != null) {
                strBuilder.append(str)
                str = reader.readLine()
            }
            return strBuilder.toString()
        } finally {
            reader?.close()
        }
    }

}