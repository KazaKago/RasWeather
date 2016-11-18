package com.kazakago.cyclefx.presentation.controller

import com.kazakago.cyclefx.CycleFx

/**
 * Created by tamura_k on 2016/11/17.
 */
interface ICycleFxController : CycleFx {

    fun onCreate()

    fun onStart()

    fun onStop()

    fun onDestory()

}