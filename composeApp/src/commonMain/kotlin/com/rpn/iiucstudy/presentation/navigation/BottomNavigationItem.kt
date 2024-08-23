package com.rpn.iiucstudy.ui.navigation

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class BottomNavigationItem(
    val icon: DrawableResource,
    val label: StringResource,
    val route: String,
    val selectedIcon: DrawableResource,
    val unselectedIcon: DrawableResource,
    val hasNews: Boolean = false,
    val enabled: Boolean = true,
    val badgeCount: Int? = null,
)
