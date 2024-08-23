package com.rpn.iiucstudy.presentation.navigation.graphs

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rpn.iiucstudy.di.koinViewModel
import com.rpn.iiucstudy.presentation.ui.home.HomeScreen
import com.rpn.iiucstudy.presentation.ui.home.HomeViewModel
import com.rpn.iiucstudy.ui.navigation.Graph
import com.rpn.iiucstudy.ui.navigation.MainScreenRoutes

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()
    SharedTransitionLayout {
        val sharedTransitionScope = this
        NavHost(
            navController = rootNavController,
            route = Graph.rootScreenGraph,
            startDestination = MainScreenRoutes.Home.route,
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            composable(route = MainScreenRoutes.Home.route) {
                val homeViewModel = koinViewModel<HomeViewModel>()
                val state by homeViewModel.state.collectAsState()
                HomeScreen(
                    animatedVisibilityScope = this,
                    sharedTransactionScope = sharedTransitionScope,
                    navController = rootNavController,
                    state = state,
                    onEvent = homeViewModel::onEvent

                )
            }
        }
    }
}