package com.kazakago.rasweather.presentation.controller

import com.kazakago.cyclefx.CycleFx
import com.kazakago.cyclefx.presentation.controller.CycleFxController
import com.kazakago.cyclefx.presentation.value.ViewInfo
import javafx.fxml.FXML

/**
 * Created by tamura_k on 2016/11/17.
 */
class AboutController() : CycleFxController() {

    companion object {
        @JvmStatic fun createViewInfo(cycleFx: CycleFx): ViewInfo? {
            return cycleFx.createViewInfo("fxml/about.fxml")
        }
    }

    @FXML
    fun onClickBack() {
        popView()
    }

}