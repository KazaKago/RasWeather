package com.kazakago.rasweather.presentation.controller

import com.kazakago.cyclefx.CycleFx
import com.kazakago.cyclefx.presentation.controller.CycleFxController
import com.kazakago.cyclefx.presentation.value.ViewInfo
import com.kazakago.rasweather.WeatherApplication
import com.kazakago.rasweather.domain.usecase.CityUseCase
import javafx.fxml.FXML
import javax.inject.Inject

/**
 * Created by tamura_k on 2016/11/17.
 */
class SettingsController() : CycleFxController() {

    companion object {
        @JvmStatic fun createViewInfo(cycleFx: CycleFx): ViewInfo? {
            return cycleFx.createViewInfo("fxml/settings.fxml")
        }
    }

    @Inject
    lateinit var cityUseCase: CityUseCase

    init {
        WeatherApplication.application.applicationComponent.inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        val cityList = cityUseCase.findAll()
    }

    @FXML
    fun onClickBack() {
        popView()
    }

    @FXML
    fun onClickAbout() {
        AboutController.createViewInfo(this)?.let {
            pushView(it, true)
        }
    }

}