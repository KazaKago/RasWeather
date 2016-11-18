package com.kazakago.cyclefx

import com.kazakago.cyclefx.presentation.value.SceneInfo

/**
 * Created by tamura_k on 2016/11/18.
 */
interface CycleFx {

    var cycleFxApplication: ICycleFxApplication?

    fun createSceneInfo(resourcePath: String): SceneInfo?

    fun pushScene(sceneInfo: SceneInfo, isAddBackStack: Boolean)

    fun popScene()

}