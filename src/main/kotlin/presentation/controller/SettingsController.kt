package presentation.controller

import WeatherApplication
import javafx.fxml.FXML
import javafx.fxml.Initializable
import java.net.URL
import java.util.*

/**
 * Created by tamura_k on 2016/11/17.
 */
class SettingsController() : Initializable {

    override fun initialize(location: URL?, resources: ResourceBundle?) {
    }

    @FXML
    fun onClickBack() {
        WeatherApplication.application.backScene()
    }

    @FXML
    fun onClickAbout() {
        WeatherApplication.application.setAboutScene(true)
    }

}