package com.kazakago.rasweather.presentation.controller

import com.kazakago.cyclefx.CycleFx
import com.kazakago.cyclefx.presentation.controller.CycleFxController
import com.kazakago.cyclefx.presentation.value.SceneInfo
import javafx.fxml.FXML

/**
 * Created by tamura_k on 2016/11/17.
 */
class SettingsController() : CycleFxController() {

    companion object {
        @JvmStatic fun createSceneInfo(cycleFx: CycleFx?): SceneInfo? {
            return cycleFx?.createSceneInfo("fxml/settings.fxml")
        }
    }

    @FXML
    fun onClickBack() {
        popScene()
    }

    @FXML
    fun onClickAbout() {
        AboutController.createSceneInfo(this)?.let {
            pushScene(it, true)
        }
    }

}