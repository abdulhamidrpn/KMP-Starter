package com.rpn.iiucstudy.di

import org.koin.core.module.Module
import com.rpn.iiucstudy.presentation.ui.home.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val viewmodelModule = module {
    singleOf(::HomeViewModel)
}
