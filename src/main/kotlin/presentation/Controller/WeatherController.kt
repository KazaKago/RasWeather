package presentation.Controller

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import java.net.URL
import java.util.*

/**
 * Created by tamura_k on 2016/11/08.
 */
class WeatherController : Initializable {

    @FXML
    lateinit var rootPane: AnchorPane
    @FXML
    lateinit var weatherImage: ImageView
    @FXML
    lateinit var refreshButton: Button

    override fun initialize(location: URL?, resources: ResourceBundle?) {
    }

    @FXML
    fun onClickRefresh() {
    }

}
