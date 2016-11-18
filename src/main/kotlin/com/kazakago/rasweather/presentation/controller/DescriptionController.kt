package com.kazakago.rasweather.presentation.controller

import com.kazakago.cyclefx.CycleFx
import com.kazakago.cyclefx.presentation.controller.CycleFxController
import com.kazakago.cyclefx.presentation.value.ViewInfo
import com.kazakago.rasweather.domain.model.WeatherModel
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea

/**
 * Created by tamura_k on 2016/11/17.
 */
class DescriptionController() : CycleFxController() {

    companion object {
        @JvmStatic fun createViewInfo(cycleFx: CycleFx, weather: WeatherModel?): ViewInfo? {
            val viewInfo = cycleFx.createViewInfo("fxml/description.fxml")
            viewInfo?.controller<DescriptionController>()?.weather = weather
            return viewInfo
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
        popView()
    }

}