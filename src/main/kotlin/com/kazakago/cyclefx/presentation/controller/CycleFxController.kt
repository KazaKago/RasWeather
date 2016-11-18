package com.kazakago.cyclefx.presentation.controller

import com.kazakago.cyclefx.ICycleFxApplication
import com.kazakago.cyclefx.presentation.value.SceneInfo
import java.util.*

/**
 * Created by weath on 2016/11/17.
 */
abstract class CycleFxController : ICycleFxController {

    override var cycleFxApplication: ICycleFxApplication? = null

    protected val currentSceneInfo: SceneInfo?
        get() = cycleFxApplication?.currentSceneInfo
    protected val sceneInfoBackStack: Deque<SceneInfo>
        get() {
            val sceneInfoBackStack =  cycleFxApplication?.sceneInfoBackStack?.let { it } ?: ArrayDeque<SceneInfo>()
            return Collections.unmodifiableCollection(sceneInfoBackStack) as Deque<SceneInfo>
        }

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onDestory() {
    }

    override fun createSceneInfo(resourcePath: String): SceneInfo? {
        return cycleFxApplication?.createSceneInfo(resourcePath)
    }

    override fun pushScene(sceneInfo: SceneInfo, isAddBackStack: Boolean) {
        cycleFxApplication?.pushScene(sceneInfo, isAddBackStack)
    }

    override fun popScene() {
        cycleFxApplication?.popScene()
    }

}