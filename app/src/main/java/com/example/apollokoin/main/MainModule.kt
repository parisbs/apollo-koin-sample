package com.example.apollokoin.main

import com.example.apollokoin.utils.BACKGROUND_DISPATCHER
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        MainViewModel(
            get(named(BACKGROUND_DISPATCHER)),
            get()
        )
    }
}
