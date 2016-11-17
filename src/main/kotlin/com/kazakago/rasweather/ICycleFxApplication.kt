package com.kazakago.rasweather

import com.kazakago.rasweather.presentation.controller.SceneInfo

/**
 * Created by weath on 2016/11/17.
 */
interface ICycleFxApplication {

    fun createSceneInfo(resourcePath: String): SceneInfo?

    fun pushScene(sceneInfo: SceneInfo, isAddBackStack: Boolean)

    fun popScene()

}