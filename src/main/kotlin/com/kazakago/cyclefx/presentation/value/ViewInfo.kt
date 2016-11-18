package com.kazakago.cyclefx.presentation.value

import com.kazakago.cyclefx.presentation.controller.ICycleFxController
import javafx.scene.Parent

/**
 * Created by weath on 2016/11/17.
 */
class ViewInfo(val root: Parent, val controller: ICycleFxController) {

    fun <T> controller(): T? {
        return controller as? T
    }

}
