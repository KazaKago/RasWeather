package com.kazakago.cyclefx

import com.kazakago.cyclefx.presentation.value.SceneInfo
import java.util.*

/**
 * Created by weath on 2016/11/17.
 */
interface ICycleFxApplication : CycleFx {

    var currentSceneInfo: SceneInfo?
    val sceneInfoBackStack: Deque<SceneInfo>

}