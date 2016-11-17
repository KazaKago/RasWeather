package com.kazkago.rasweather.presentation.controller

import javafx.scene.Scene

/**
 * Created by weath on 2016/11/17.
 */
class SceneInfo(val scene: Scene, val controller: ICycleFxController) {

    fun <T> controller(): T? {
        return controller as? T
    }

}
