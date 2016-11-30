package com.kazakago.rasweather.data.file

import java.io.IOException
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors


/**
 * Created by tamura_k on 2016/11/30.
 */
abstract class FileAccess {

    @Throws(IOException::class)
    fun readAll(path: String): String {
        return Files
                .lines(Paths.get(javaClass.classLoader.getResource(path).toURI()), Charset.forName("UTF-8"))
                .collect(Collectors.joining(System.getProperty("line.separator")))
    }

}