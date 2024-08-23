package com.rpn.iiucstudy.presentation.ui.home

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.rpn.iiucstudy.presentation.ui.common.EmptyContent
import com.rpn.iiucstudy.presentation.ui.common.ShimmerEffect
import kmp_starter.composeapp.generated.resources.Res
import kmp_starter.composeapp.generated.resources.ic_browse
import kmp_starter.composeapp.generated.resources.ic_network_error
import kmp_starter.composeapp.generated.resources.no_news
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    sharedTransactionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    state: HomeScreenState,
    onEvent: (HomeScreenEvents) -> Unit
) {
    state.articles.DisplayResult(
        onIdle = {
            EmptyContent(
                message = stringResource(Res.string.no_news),
                icon = Res.drawable.ic_browse,
                onRetryClick = null
            )
        },
        onLoading = {
            ShimmerEffect()
        },
        onSuccess = { articles ->
            if (articles.isEmpty()) EmptyContent(
                message = stringResource(Res.string.no_news),
                icon = Res.drawable.ic_browse,
                onRetryClick = {
                    onEvent(HomeScreenEvents.LoadHomeData)
                }
            ) else {
                /*Show List in different compose function*/
            }
        },
        onError = {
            EmptyContent(
                message = it,
                icon = Res.drawable.ic_network_error,
                onRetryClick = {
                    onEvent(HomeScreenEvents.LoadHomeData)
                }
            )
        }
    )
}