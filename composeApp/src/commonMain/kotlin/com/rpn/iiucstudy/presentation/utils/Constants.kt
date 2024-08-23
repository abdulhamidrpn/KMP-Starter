package com.rpn.iiucstudy.presentation.utils

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import kmp_starter.composeapp.generated.resources.Res
import kmp_starter.composeapp.generated.resources.*
import org.jetbrains.compose.resources.StringResource


enum class Theme(val title: StringResource) {
    SYSTEM_DEFAULT(Res.string.system_default),
    LIGHT_MODE(Res.string.light_mode),
    DARK_MODE(Res.string.dark_mode)
}

enum class Type {
    Mobile, Desktop, Browser
}

enum class WindowSizeClass { Compact, Medium, Expanded }

val FadeIn = fadeIn(animationSpec = tween(220, delayMillis = 90)) +
        scaleIn(
            initialScale = 0.92f,
            animationSpec = tween(220, delayMillis = 90)
        )

val FadeOut = fadeOut(animationSpec = tween(90))

