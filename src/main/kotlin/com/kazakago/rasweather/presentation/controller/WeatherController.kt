package com.kazakago.rasweather.presentation.controller

import com.kazakago.cyclefx.CycleFx
import com.kazakago.cyclefx.presentation.controller.CycleFxController
import com.kazakago.cyclefx.presentation.value.ViewInfo
import com.kazakago.rasweather.WeatherApplication
import com.kazakago.rasweather.domain.model.weather.WeatherModel
import com.kazakago.rasweather.domain.usecase.CityUseCase
import com.kazakago.rasweather.domain.usecase.WeatherUseCase
import javafx.application.Platform
import javafx.fxml.FXML
import javafx.scene.Parent
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.Button
import javafx.scene.control.Hyperlink
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
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
    @FXML
    lateinit var loadingView: Parent

    @Inject
    lateinit var weatherUseCase: WeatherUseCase
    @Inject
    lateinit var cityUseCase: CityUseCase
    private val subscriptions: CompositeSubscription
    private var weather: WeatherModel? = null
    private var refreshTimer: Timer? = null

    init {
        WeatherApplication.application.applicationComponent.inject(this)
        subscriptions = CompositeSubscription()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStart() {
        super.onCreate()
        fetchWeather()
    }

    override fun onStop() {
        super.onStop()
        refreshTimer?.cancel()
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
        val cityId = cityUseCase
                .getCityId()
                .toBlocking()
                .single()
        fetchWeather(cityId)
    }

    private fun fetchWeather(cityId: String) {
        loadingView.isVisible = true
        subscriptions.add(weatherUseCase.fetch(cityId)
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                        { weather ->
                            this.weather = weather
                            Platform.runLater { refreshView(weather) }
                        },
                        { error ->
                            Platform.runLater { showError() }
                            resetTimer()
                        },
                        {
                            Platform.runLater { loadingView.isVisible = false }
                            resetTimer()
                        }
                ))
    }

    private fun refreshView(weather: WeatherModel) {
        locationLabel.text = weather.title
        descriptionLabel.text = weather.description?.text
        publishTimeLabel.text = formatPublicTime(weather.publicTime)
        weather.forecasts?.let {
            if (0 < it.count()) {
                val forecast = it[0]
                todayDateLabel.text = formatForecastDate(forecast.dateLabel, forecast.date)
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
                tomorrowDateLabel.text = formatForecastDate(forecast.dateLabel, forecast.date)
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

    private fun formatPublicTime(originalTime: String?): String? {
        var formattedTime: String? = null
        try {
            val timeParser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
            val time = timeParser.parse(originalTime)
            val timeFormatter = SimpleDateFormat("発表日時 yyyy/MM/dd HH:mm E")
            formattedTime = timeFormatter.format(time)
        } catch (e: ParseException) { }
        return formattedTime
    }

    private fun formatForecastDate(dateLabel: String?, originalTime: String?): String? {
        var formattedTime: String? = null
        try {
            val timeParser = SimpleDateFormat("yyyy-MM-dd")
            val time = timeParser.parse(originalTime)
            val timeFormatter = SimpleDateFormat(dateLabel + " (yyyy/MM/dd E)")
            formattedTime = timeFormatter.format(time)
        } catch (e: ParseException) { }
        return formattedTime
    }

    private fun showError() {
        val alert = Alert(AlertType.ERROR)
        alert.title = "エラー"
        alert.dialogPane.headerText = "通信エラー"
        alert.dialogPane.contentText = "情報の更新に失敗しました"
        alert.show()
    }

    private fun resetTimer() {
        refreshTimer?.cancel()
        refreshTimer = Timer()
        refreshTimer?.schedule(object : TimerTask() {
            override fun run() {
                fetchWeather()
            }
        }, TimeUnit.HOURS.toMillis(1))
    }

}
