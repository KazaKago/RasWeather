
import di.component.ApplicationComponent
import di.component.DaggerApplicationComponent
import di.module.ApplicationModule
import di.module.DataModule
import di.module.DomainModule
import domain.model.WeatherModel
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import presentation.controller.AboutController
import presentation.controller.DescriptionController
import presentation.controller.SettingsController
import presentation.controller.WeatherController
import java.util.*

fun main(args: Array<String>) {
    Application.launch(WeatherApplication::class.java, *args)
}

/**
 * Created by tamura_k on 2016/11/08.
 */
class WeatherApplication : Application() {

    data class SceneInfo(val scene: Scene, val controller: Any?)

    companion object {
        @JvmStatic lateinit var application: WeatherApplication
    }

    lateinit var primaryStage: Stage
    lateinit var applicationComponent: ApplicationComponent
    var currentSceneInfo: SceneInfo? = null
    var sceneBackStack = ArrayDeque<SceneInfo>()

    init {
        application = this
        initializeInjector()
    }

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        this.primaryStage = primaryStage
        primaryStage.title = "RasWeather"

        setWeatherScene(false)
        primaryStage.show()
    }

    @Throws(Exception::class)
    override fun stop() {
        super.stop()
    }

    fun setWeatherScene(isAddBackStack: Boolean) {
        val fxmlLoader = FXMLLoader(javaClass.getResource("weather.fxml"))
        val root = fxmlLoader.load<Parent>()
        val controller = fxmlLoader.getController<WeatherController>()

        setScene(root, controller, isAddBackStack)
    }

    fun setDescriptionScene(isAddBackStack: Boolean, weather: WeatherModel?) {
        val fxmlLoader = FXMLLoader(javaClass.getResource("description.fxml"))
        val root = fxmlLoader.load<Parent>()
        val controller = fxmlLoader.getController<DescriptionController>()
        controller.weather = weather

        setScene(root, controller, isAddBackStack)
    }

    fun setSettingsScene(isAddBackStack: Boolean) {
        val fxmlLoader = FXMLLoader(javaClass.getResource("settings.fxml"))
        val root = fxmlLoader.load<Parent>()
        val controller = fxmlLoader.getController<SettingsController>()

        setScene(root, controller, isAddBackStack)
    }

    fun setAboutScene(isAddBackStack: Boolean) {
        val fxmlLoader = FXMLLoader(javaClass.getResource("about.fxml"))
        val root = fxmlLoader.load<Parent>()
        val controller = fxmlLoader.getController<AboutController>()

        setScene(root, controller, isAddBackStack)
    }

    fun backScene() {
        if (sceneBackStack.isNotEmpty()) {
            setScene(sceneBackStack.pop(), false)
        }
    }

    private fun setScene(root: Parent, controller: Any?, isAddBackStack: Boolean) {
        setScene(SceneInfo(Scene(root), controller), isAddBackStack)
    }

    private fun setScene(sceneInfo: SceneInfo, isAddBackStack: Boolean) {
        if (isAddBackStack && currentSceneInfo != null) {
            sceneBackStack.push(currentSceneInfo)
        }
        primaryStage.scene = sceneInfo.scene
        currentSceneInfo = sceneInfo
    }

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule())
                .domainModule(DomainModule())
                .dataModule(DataModule())
                .build()
    }

}