package com.rpn.iiucstudy.ui.navigation


object Graph {
    const val rootScreenGraph = "root_screen_graph"
    const val mainScreenGraph = "main_screen_graph"
}

sealed class MainScreenRoutes(val route: String) {
    data object Home : MainScreenRoutes("home")
    data object Search : MainScreenRoutes("search")
    data object Bookmark : MainScreenRoutes("bookmark")
}

sealed class Routes(val route: String) {
    data object Setting : Routes("setting")
    data object ArticleDetail : Routes("articleDetail")
}

