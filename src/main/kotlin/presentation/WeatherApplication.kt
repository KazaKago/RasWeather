package presentation

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Created by tamura_k on 2016/11/08.
 */
class WeatherApplication : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("../weather.fxml"))
        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }

}
