package com.kazakago.rasweather.presentation.controller

import com.kazakago.rasweather.ICycleFxApplication
import javafx.fxml.FXML

/**
 * Created by tamura_k on 2016/11/17.
 */
class SettingsController() : CycleFxController() {

    companion object {
        @JvmStatic fun createSceneInfo(application: ICycleFxApplication?): SceneInfo? {
            return application?.createSceneInfo("fxml/settings.fxml")
        }
    }

    @FXML
    fun onClickBack() {
        popScene()
    }

    @FXML
    fun onClickAbout() {
        AboutController.createSceneInfo(cycleFxApplication)?.let {
            pushScene(it, true)
        }
    }

}