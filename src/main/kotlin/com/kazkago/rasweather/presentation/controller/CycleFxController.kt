package com.kazkago.rasweather.presentation.controller

import com.kazkago.rasweather.presentation.controller.ICycleFxController
import com.kazkago.rasweather.ICycleFxApplication

/**
 * Created by weath on 2016/11/17.
 */
abstract class CycleFxController : ICycleFxController {

    override var cycleFxApplication: ICycleFxApplication? = null

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onDestory() {
    }

    protected fun createSceneInfo(resourceName: String): SceneInfo? {
        return cycleFxApplication?.createSceneInfo(resourceName)
    }

    protected fun pushScene(sceneInfo: SceneInfo, isAddBackStack: Boolean) {
        cycleFxApplication?.pushScene(sceneInfo, isAddBackStack)
    }

    protected fun popScene() {
        cycleFxApplication?.popScene()
    }

}