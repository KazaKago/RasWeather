package presentation.controller

import WeatherApplication
import domain.model.WeatherModel
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import java.net.URL
import java.util.*

/**
 * Created by tamura_k on 2016/11/17.
 */
class DescriptionController() : Initializable {

    @FXML
    lateinit var titleLabel: Label
    @FXML
    lateinit var descriptionArea: TextArea

    var weather: WeatherModel? = null
    set(value) {
        titleLabel.text = value?.title
        descriptionArea.text = value?.description?.text
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
    }

    @FXML
    fun onClickBack() {
        WeatherApplication.application.backScene()
    }

}