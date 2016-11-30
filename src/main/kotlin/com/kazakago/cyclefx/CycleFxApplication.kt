package com.kazakago.cyclefx

import com.kazakago.cyclefx.presentation.controller.ICycleFxController
import com.kazakago.cyclefx.presentation.value.ViewInfo
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

    override var currentViewInfo: ViewInfo? = null
    override val viewInfoBackStack = ArrayDeque<ViewInfo>()
    private lateinit var primaryStage: Stage

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        this.cycleFxApplication = this
        this.primaryStage = primaryStage
    }

    @Throws(Exception::class)
    override fun stop() {
        super.stop()
        currentViewInfo?.controller?.onStop()
        currentViewInfo?.controller?.onDestory()
        viewInfoBackStack.forEach {
            it?.controller?.onStop()
            it?.controller?.onDestory()
        }
    }

    override fun createViewInfo(resourcePath: String): ViewInfo? {
        val fxmlLoader = FXMLLoader(javaClass.classLoader.getResource(resourcePath))
        val root = fxmlLoader.load<Parent>()
        val controller = fxmlLoader.getController<ICycleFxController>()
        controller.cycleFxApplication = this
        controller.onCreate()

        return ViewInfo(root, controller)
    }

    override fun pushView(viewInfo: ViewInfo, isAddBackStack: Boolean) {
        if (primaryStage.scene != null) {
            primaryStage.scene.root = viewInfo.root
        } else {
            primaryStage.scene = Scene(viewInfo.root)
        }
        currentViewInfo?.controller?.onStop()
        if (isAddBackStack) {
            currentViewInfo.let { viewInfoBackStack.push(it) }
        } else {
            currentViewInfo?.controller?.onDestory()
        }
        currentViewInfo = viewInfo
        currentViewInfo?.controller?.onStart()
    }

    override fun popView() {
        if (viewInfoBackStack.isNotEmpty()) {
            pushView(viewInfoBackStack.pop(), false)
        }
    }
}