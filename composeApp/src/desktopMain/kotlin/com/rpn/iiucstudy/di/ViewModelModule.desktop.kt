package com.rpn.iiucstudy.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

import com.rpn.iiucstudy.presentation.ui.home.HomeViewModel

actual val viewmodelModule = module {
    singleOf(::HomeViewModel)
}

