package com.kazkago.rasweather

import com.kazkago.rasweather.presentation.controller.ICycleFxController
import com.kazkago.rasweather.presentation.controller.SceneInfo
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import java.util.*

/**
 * Created by weath on 2016/11/17.
 */
abstract class CycleFxApplication() : Application(), ICycleFxApplication {

    private var currentSceneInfo: SceneInfo? = null
    private val sceneBackStack = ArrayDeque<SceneInfo>()
    private lateinit var primaryStage: Stage

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        this.primaryStage = primaryStage
    }

    @Throws(Exception::class)
    override fun stop() {
        super.stop()
        currentSceneInfo?.controller?.onStop()
        currentSceneInfo?.controller?.onDestory()
        sceneBackStack.map {
            it?.controller?.onStop()
            it?.controller?.onDestory()
        }
    }

    override fun createSceneInfo(resourceName: String): SceneInfo {
        val fxmlLoader = FXMLLoader(javaClass.getResource(resourceName))
        val root = fxmlLoader.load<Parent>()
        val controller = fxmlLoader.getController<ICycleFxController>()
        controller.cycleFxApplication = this
        controller.onCreate()

        return SceneInfo(Scene(root), controller)
    }

    override fun pushScene(sceneInfo: SceneInfo, isAddBackStack: Boolean) {
        primaryStage.scene = sceneInfo.scene
        currentSceneInfo?.controller?.onStop()
        if (isAddBackStack) {
            currentSceneInfo.let { sceneBackStack.push(it) }
        } else {
            currentSceneInfo?.controller?.onDestory()
        }
        currentSceneInfo = sceneInfo
        currentSceneInfo?.controller?.onStart()
    }

    override fun popScene() {
        if (sceneBackStack.isNotEmpty()) {
            pushScene(sceneBackStack.pop(), false)
        }
    }
}