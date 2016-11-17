package com.kazakago.rasweather.presentation.controller

import com.kazakago.rasweather.ICycleFxApplication

/**
 * Created by tamura_k on 2016/11/17.
 */
interface ICycleFxController {

    var cycleFxApplication: ICycleFxApplication?

    fun onCreate()

    fun onStart()

    fun onStop()

    fun onDestory()

}