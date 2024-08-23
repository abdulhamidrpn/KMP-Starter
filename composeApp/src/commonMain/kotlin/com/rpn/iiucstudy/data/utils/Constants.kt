package com.rpn.iiucstudy.data.utils

import com.rpn.iiucstudy.BuildKonfig


object Constants {

    const val LOG_TAG = "KMP_App"
    const val DB_NAME = "myNewsDB"

    const val dataStoreFileName = "setting.preferences_pb"

    val API_KEY = BuildKonfig.API_KEY
    const val BASE_URL = "https://newsapi.org/v2/"

    const val ITEMS_PER_PAGE = 20


    /*
    * This keywords are prohibited
    * If any image related to this keyword shows in feed that will ber removed from list.
    * and also nobody can search related to this keyword.
    * Filtering Halal Content.
    */
    val prohibitedKeywords =
        listOf(
            "woman", "adult", "naughty", "sex", "porn", "lady", "girl", "nude",
            "bikini", "lingerie", "swimsuit", "underwear", "gay", "lesbian",
            "erotic", "provocative", "seductive", "flirt", "romance", "kissing",
            "xxx", "explicit", "hardcore",
            "scantily clad", "revealing", "intimate", "sensual", "adult film"
        )

}