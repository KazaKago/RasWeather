package com.kazakago.rasweather.presentation.controller

import com.kazakago.cyclefx.CycleFx
import com.kazakago.cyclefx.presentation.controller.CycleFxController
import com.kazakago.cyclefx.presentation.value.ViewInfo
import com.kazakago.rasweather.WeatherApplication
import com.kazakago.rasweather.domain.model.city.CityModel
import com.kazakago.rasweather.domain.usecase.CityUseCase
import com.kazakago.rasweather.presentation.view.CityCell
import javafx.application.Platform
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.ListView
import java.io.IOException
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

    @FXML
    lateinit var cityListView: ListView<CityModel>

    @Inject
    lateinit var cityUseCase: CityUseCase

    init {
        WeatherApplication.application.applicationComponent.inject(this)
    }

    override fun onCreate() {
        super.onCreate()

        cityListView.setCellFactory({ param -> CityCell() })
        refreshCityListView()
        loadSelected()

        cityListView.selectionModel.selectedItemProperty().addListener {
            observableValue, oldItem, newItem ->
            saveSelected(newItem)
        }
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

    private fun refreshCityListView() {
        try {
            val cityList = cityUseCase
                    .findAll()
                    .toList()
                    .map {
                        FXCollections.observableList(it)
                    }
                    .toBlocking()
                    .single()
            cityListView.items = cityList
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun selectedCityIndex(index: Int?) {
        index?.let {
            Platform.runLater({
                cityListView.scrollTo(it)
                cityListView.selectionModel.select(it)
            })
        }
    }

    private fun loadSelected() {
        val cityId = cityUseCase
                .getCityId()
                .toBlocking()
                .single()
        cityListView.items.forEachIndexed { i, city ->
            if (city.id == cityId) {
                selectedCityIndex(i)
            }
        }
    }

    private fun saveSelected(city: CityModel) {
        city.id?.let {
            cityUseCase.setCityId(it)
        }
    }

}