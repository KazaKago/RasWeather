package com.kazkago.rasweather.presentation.controller

import com.kazkago.rasweather.ICycleFxApplication
import com.kazkago.rasweather.domain.model.WeatherModel
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea

/**
 * Created by tamura_k on 2016/11/17.
 */
class DescriptionController() : CycleFxController() {

    companion object {
        @JvmStatic fun createSceneInfo(application: ICycleFxApplication?, weather: WeatherModel?): SceneInfo? {
            val sceneInfo = application?.createSceneInfo("../../../description.fxml")
            sceneInfo?.controller<DescriptionController>()?.weather = weather
            return sceneInfo
        }
    }

    @FXML
    lateinit var titleLabel: Label
    @FXML
    lateinit var descriptionArea: TextArea

    var weather: WeatherModel? = null
    set(value) {
        titleLabel.text = value?.title
        descriptionArea.text = value?.description?.text
    }

    @FXML
    fun onClickBack() {
        popScene()
    }

}