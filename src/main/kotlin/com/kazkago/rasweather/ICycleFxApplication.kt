package com.kazkago.rasweather

import com.kazkago.rasweather.presentation.controller.SceneInfo

/**
 * Created by weath on 2016/11/17.
 */
interface ICycleFxApplication {

    fun createSceneInfo(resourceName: String): SceneInfo?

    fun pushScene(sceneInfo: SceneInfo, isAddBackStack: Boolean)

    fun popScene()

}