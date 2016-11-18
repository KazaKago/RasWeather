package com.kazakago.rasweather.presentation.controller

import com.kazakago.cyclefx.CycleFx
import com.kazakago.cyclefx.presentation.controller.CycleFxController
import com.kazakago.cyclefx.presentation.value.ViewInfo
import com.kazakago.rasweather.WeatherApplication
import com.kazakago.rasweather.domain.model.WeatherModel
import com.kazakago.rasweather.domain.usecase.WeatherUseCase
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.Button
import javafx.scene.control.Hyperlink
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by tamura_k on 2016/11/08.
 */
class WeatherController() : CycleFxController() {

    companion object {
        @JvmStatic fun createViewInfo(cycleFx: CycleFx): ViewInfo? {
            return cycleFx.createViewInfo("fxml/weather.fxml")
        }
    }

    @FXML
    lateinit var locationLabel: Label
    @FXML
    lateinit var todayDateLabel: Label
    @FXML
    lateinit var tomorrowDateLabel: Label
    @FXML
    lateinit var todayWeatherImage: ImageView
    @FXML
    lateinit var tomorrowWeatherImage: ImageView
    @FXML
    lateinit var todayWeatherLabel: Label
    @FXML
    lateinit var tomorrowWeatherLabel: Label
    @FXML
    lateinit var todayTemperatureMaxLabel: Label
    @FXML
    lateinit var tomorrowTemperatureMaxLabel: Label
    @FXML
    lateinit var todayTemperatureMinLabel: Label
    @FXML
    lateinit var tomorrowTemperatureMinLabel: Label
    @FXML
    lateinit var descriptionLabel: Hyperlink
    @FXML
    lateinit var publishTimeLabel: Label
    @FXML
    lateinit var refreshButton: Button
    @FXML
    lateinit var settingsButton: Button

    @Inject
    lateinit var weatherUseCase: WeatherUseCase
    private val subscriptions: CompositeSubscription
    private var weather: WeatherModel? = null

    init {
        WeatherApplication.application.applicationComponent.inject(this)
        subscriptions = CompositeSubscription()
    }

    override fun onStart() {
        super.onCreate()
        fetchWeather()
    }

    @FXML
    fun onClickRefresh() {
        fetchWeather()
    }

    @FXML
    fun onClickSettings() {
        SettingsController.createViewInfo(this)?.let {
            pushView(it, true)
        }
    }

    @FXML
    fun onClickDescription() {
        DescriptionController.createViewInfo(this, weather)?.let {
            pushView(it, true)
        }
    }

    private fun fetchWeather() {
        subscriptions.add(weatherUseCase.fetch("130010")
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                        { weather ->
                            this.weather = weather
                            Platform.runLater { refreshView(weather) }
                        },
                        { error ->
                            Platform.runLater { showError() }
                        },
                        {
                        }
                ))
    }

    private fun refreshView(weather: WeatherModel) {
        locationLabel.text = weather.title
        descriptionLabel.text = weather.description?.text
        publishTimeLabel.text = weather.publicTime
        weather.forecasts?.let {
            if (0 < it.count()) {
                val forecast = it[0]
                todayDateLabel.text = forecast.dateLabel + " (" + forecast.date + ")"
                todayWeatherImage.image = weatherUseCase.getImageUri(forecast)?.let(::Image)
                todayWeatherLabel.text = forecast.telop
                todayTemperatureMaxLabel.text = forecast.temperature?.max?.celsius?.toString()?.let { it + "℃" } ?: "-℃"
                todayTemperatureMinLabel.text = forecast.temperature?.min?.celsius?.toString()?.let { it + "℃" } ?: "-℃"
            } else {
                todayDateLabel.text = "-"
                todayWeatherImage.image = null
                todayWeatherLabel.text = "-"
                todayTemperatureMaxLabel.text = "-℃"
                todayTemperatureMinLabel.text = "-℃"
            }
            if (1 < it.count()) {
                val forecast = it[1]
                tomorrowDateLabel.text = forecast.dateLabel + " (" + forecast.date + ")"
                tomorrowWeatherImage.image = weatherUseCase.getImageUri(forecast)?.let(::Image)
                tomorrowWeatherLabel.text = forecast.telop
                tomorrowTemperatureMaxLabel.text = forecast.temperature?.max?.celsius?.toString()?.let { it + "℃" } ?: "-℃"
                tomorrowTemperatureMinLabel.text = forecast.temperature?.min?.celsius?.toString()?.let { it + "℃" } ?: "-℃"
            } else {
                tomorrowDateLabel.text = "-"
                tomorrowWeatherImage.image = null
                tomorrowWeatherLabel.text = "-"
                tomorrowTemperatureMaxLabel.text = "-℃"
                tomorrowTemperatureMinLabel.text = "-℃"
            }
        }
    }

    private fun showError() {
        val alert = Alert(AlertType.ERROR)
        alert.title = "エラー"
        alert.dialogPane.headerText = "通信エラー"
        alert.dialogPane.contentText = "情報の更新に失敗しました"
        alert.show()
    }

}
