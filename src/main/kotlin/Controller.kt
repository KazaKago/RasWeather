import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane

/**
 * Created by tamura_k on 2016/11/08.
 */
class Controller {

    @FXML
    lateinit var rootPane: AnchorPane
    @FXML
    lateinit var weatherImage: ImageView
    @FXML
    lateinit var refreshButton: Button

    @FXML
    private fun initialize() {
        weatherImage.fitWidthProperty().bind(rootPane.widthProperty())
        weatherImage.fitHeightProperty().bind(rootPane.heightProperty())
    }


}
