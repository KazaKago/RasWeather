package rasweather.presentation.controller

import rasweather.ICycleFxApplication

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