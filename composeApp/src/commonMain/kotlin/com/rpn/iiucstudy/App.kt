package com.rpn.iiucstudy

import androidx.compose.runtime.Composable
import com.rpn.iiucstudy.presentation.navigation.graphs.RootNavGraph
import com.rpn.iiucstudy.presentation.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        AppTheme() {
            RootNavGraph()
        }
    }
}