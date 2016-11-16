package presentation.controller

import WeatherApplication
import domain.model.WeatherModel
import domain.usecase.WeatherUseCase
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.net.URL
import java.util.*
import javax.inject.Inject

/**
 * Created by tamura_k on 2016/11/08.
 */
class WeatherController : Initializable {

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
    lateinit var refreshButton: Button

    @Inject
    lateinit var weatherUseCase: WeatherUseCase
    private val subscriptions: CompositeSubscription

    init {
        WeatherApplication.application.applicationComponent.inject(this)
        subscriptions = CompositeSubscription()
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        fetchWeather()
    }

    @FXML
    fun onClickRefresh() {
        fetchWeather()
    }

    private fun fetchWeather() {
        subscriptions.add(weatherUseCase.fetch("400040")
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.immediate())
                .subscribe(
                        { weather ->
                            refreshView(weather)
                        },
                        { error ->
                        },
                        {
                        }
                ))
    }

    private fun refreshView(weather: WeatherModel) {
        locationLabel.text = weather.title
        weather.forecasts?.let {
            if (0 < it.count()) {
                val forecast = it[0]
                todayDateLabel.text = forecast.dateLabel + " (" + forecast.date + ")"
                todayWeatherImage.image = forecast.image?.url?.let(::Image)
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
                tomorrowWeatherImage.image = forecast.image?.url?.let(::Image)
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

}
