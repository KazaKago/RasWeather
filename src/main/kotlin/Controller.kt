import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane

/**
 * Created by tamura_k on 2016/11/08.
 */
class Controller {

    @FXML
    lateinit private var rootPane: AnchorPane
    @FXML
    lateinit private var weatherImage: ImageView
    @FXML
    lateinit private var refreshButton: Button

}
