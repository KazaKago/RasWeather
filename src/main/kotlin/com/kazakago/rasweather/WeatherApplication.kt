package com.kazakago.rasweather

import com.kazakago.rasweather.di.component.ApplicationComponent
import com.kazakago.rasweather.di.component.DaggerApplicationComponent
import com.kazakago.rasweather.di.module.ApplicationModule
import com.kazakago.rasweather.di.module.DataModule
import com.kazakago.rasweather.di.module.DomainModule
import com.kazakago.rasweather.presentation.controller.WeatherController
import javafx.application.Application
import javafx.stage.Stage

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