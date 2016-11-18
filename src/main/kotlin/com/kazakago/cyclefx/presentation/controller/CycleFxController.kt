package com.kazakago.cyclefx.presentation.controller

import com.kazakago.cyclefx.ICycleFxApplication
import com.kazakago.cyclefx.presentation.value.ViewInfo
import java.util.*

/**
 * Created by weath on 2016/11/17.
 */
abstract class CycleFxController : ICycleFxController {

    override var cycleFxApplication: ICycleFxApplication? = null

    protected val currentViewInfo: ViewInfo?
        get() = cycleFxApplication?.currentViewInfo
    protected val viewInfoBackStack: Deque<ViewInfo>
        get() {
            val sceneInfoBackStack =  cycleFxApplication?.viewInfoBackStack?.let { it } ?: ArrayDeque<ViewInfo>()
            return Collections.unmodifiableCollection(sceneInfoBackStack) as Deque<ViewInfo>
        }

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onDestory() {
    }

    override fun createViewInfo(resourcePath: String): ViewInfo? {
        return cycleFxApplication?.createViewInfo(resourcePath)
    }

    override fun pushView(viewInfo: ViewInfo, isAddBackStack: Boolean) {
        cycleFxApplication?.pushView(viewInfo, isAddBackStack)
    }

    override fun popView() {
        cycleFxApplication?.popView()
    }

}