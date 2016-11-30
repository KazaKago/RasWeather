package com.kazakago.rasweather.presentation.view

import com.kazakago.rasweather.domain.model.city.CityModel
import javafx.scene.control.ListCell


/**
 * Created by weath on 2016/11/30.
 */
class CityCell : ListCell<CityModel>() {

    override fun updateItem(item: CityModel?, empty: Boolean) {
        super.updateItem(item, empty)
        if (!empty) {
            text = item?.name
        }
    }
}
