package com.kazkago.rasweather.presentation.controller

import com.kazkago.rasweather.ICycleFxApplication
import javafx.fxml.FXML

/**
 * Created by tamura_k on 2016/11/17.
 */
class AboutController() : CycleFxController() {

    companion object {
        @JvmStatic fun createSceneInfo(application: ICycleFxApplication?): SceneInfo? {
            return application?.createSceneInfo("../../../about.fxml")
        }
    }

    @FXML
    fun onClickBack() {
        popScene()
    }

}