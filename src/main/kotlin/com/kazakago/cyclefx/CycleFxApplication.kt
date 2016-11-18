package com.kazakago.cyclefx

import com.kazakago.cyclefx.presentation.controller.ICycleFxController
import com.kazakago.cyclefx.presentation.value.SceneInfo
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

    override var cycleFxApplication: ICycleFxApplication? = null

    override var currentSceneInfo: SceneInfo? = null
    override val sceneInfoBackStack = ArrayDeque<SceneInfo>()
    private lateinit var primaryStage: Stage

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        this.cycleFxApplication = this
        this.primaryStage = primaryStage
    }

    @Throws(Exception::class)
    override fun stop() {
        super.stop()
        currentSceneInfo?.controller?.onStop()
        currentSceneInfo?.controller?.onDestory()
        sceneInfoBackStack.map {
            it?.controller?.onStop()
            it?.controller?.onDestory()
        }
    }

    override fun createSceneInfo(resourcePath: String): SceneInfo? {
        val fxmlLoader = FXMLLoader(javaClass.classLoader.getResource(resourcePath))
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
            currentSceneInfo.let { sceneInfoBackStack.push(it) }
        } else {
            currentSceneInfo?.controller?.onDestory()
        }
        currentSceneInfo = sceneInfo
        currentSceneInfo?.controller?.onStart()
    }

    override fun popScene() {
        if (sceneInfoBackStack.isNotEmpty()) {
            pushScene(sceneInfoBackStack.pop(), false)
        }
    }
}