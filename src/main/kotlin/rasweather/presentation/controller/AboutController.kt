package rasweather.presentation.controller

import rasweather.ICycleFxApplication
import javafx.fxml.FXML

/**
 * Created by tamura_k on 2016/11/17.
 */
class AboutController() : CycleFxController() {

    companion object {
        @JvmStatic fun createSceneInfo(application: ICycleFxApplication?): SceneInfo? {
            return application?.createSceneInfo("fxml/about.fxml")
        }
    }

    @FXML
    fun onClickBack() {
        popScene()
    }

}