package com.kazakago.cyclefx

import com.kazakago.cyclefx.presentation.value.ViewInfo

/**
 * Created by tamura_k on 2016/11/18.
 */
interface CycleFx {

    var cycleFxApplication: ICycleFxApplication?

    fun createViewInfo(resourcePath: String): ViewInfo?

    fun pushView(viewInfo: ViewInfo, isAddBackStack: Boolean)

    fun popView()

}