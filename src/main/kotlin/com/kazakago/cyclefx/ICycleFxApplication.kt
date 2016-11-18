package com.kazakago.cyclefx

import com.kazakago.cyclefx.presentation.value.ViewInfo
import java.util.*

/**
 * Created by weath on 2016/11/17.
 */
interface ICycleFxApplication : CycleFx {

    var currentViewInfo: ViewInfo?
    val viewInfoBackStack: Deque<ViewInfo>

}