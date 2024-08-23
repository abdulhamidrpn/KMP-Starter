package com.rpn.iiucstudy.di

import com.rpn.iiucstudy.presentation.ui.home.HomeViewModel

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val viewmodelModule = module {
    viewModelOf(::HomeViewModel)
}
