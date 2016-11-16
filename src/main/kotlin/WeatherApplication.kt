
import di.component.ApplicationComponent
import di.component.DaggerApplicationComponent
import di.module.ApplicationModule
import di.module.DataModule
import di.module.DomainModule
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

fun main(args: Array<String>) {
    Application.launch(WeatherApplication::class.java, *args)
}

/**
 * Created by tamura_k on 2016/11/08.
 */
class WeatherApplication : Application() {

    companion object {
        @JvmStatic lateinit var application: WeatherApplication
    }

    lateinit var applicationComponent: ApplicationComponent

    init {
        application = this
        initializeInjector()
    }

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("weather.fxml"))
        primaryStage.title = "Hello World"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }

    private fun initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule())
                .domainModule(DomainModule())
                .dataModule(DataModule())
                .build()
    }

}
