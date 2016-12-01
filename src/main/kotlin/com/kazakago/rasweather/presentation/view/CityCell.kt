package com.kazakago.rasweather.presentation.view

import com.jfoenix.controls.JFXListCell
import com.kazakago.rasweather.domain.model.city.CityModel


/**
 * Created by weath on 2016/11/30.
 */
class CityCell : JFXListCell<CityModel>() {

    override fun updateItem(item: CityModel?, empty: Boolean) {
        super.updateItem(item, empty)
        graphic = null
        if (!empty) {
            text = item?.name
        }
    }
}
