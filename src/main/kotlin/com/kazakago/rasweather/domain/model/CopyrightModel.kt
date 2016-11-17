package com.kazakago.rasweather.domain.model

/**
 * Copyright Model
 *
 *
 * Created by tamura_k on 2016/06/03.
 */
class CopyrightModel {

    //コピーライトの文言
    var title: String? = null
    //livedoor 天気情報のURL
    var link: String? = null
    //livedoor 天気情報へのURL、アイコンなど
    var image: ImageModel? = null
    //livedoor 天気情報で使用している気象データの配信元
    var provider: List<LinkModel>? = null

}
