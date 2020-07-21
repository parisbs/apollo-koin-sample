package com.example.apollokoin.post

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postModule = module {
    viewModel {
        PostViewModel()
    }
}
