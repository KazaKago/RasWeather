package rasweather

import javafx.application.Application
import javafx.stage.Stage
import rasweather.di.component.ApplicationComponent
import rasweather.di.component.DaggerApplicationComponent
import rasweather.di.module.ApplicationModule
import rasweather.di.module.DataModule
import rasweather.di.module.DomainModule
import rasweather.presentation.controller.WeatherController

fun main(args: Array<String>) {
    Application.launch(WeatherApplication::class.java, *args)
}

/**
 * Created by tamura_k on 2016/11/08.
 */
class WeatherApplication() : CycleFxApplication() {

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
        super.start(primaryStage)

        WeatherController.createSceneInfo(this)?.let {
            pushScene(it, false)
        }
        primaryStage.title = "RasWeather"
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