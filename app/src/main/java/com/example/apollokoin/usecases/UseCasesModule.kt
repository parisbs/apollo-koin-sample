package com.example.apollokoin.usecases

import org.koin.dsl.module

val useCasesModule = module {
    factory { AllPost(get()) }
}