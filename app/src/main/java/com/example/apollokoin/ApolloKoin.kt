package com.example.apollokoin

import android.app.Application
import com.example.apollokoin.data.dataModule
import com.example.apollokoin.main.mainModule
import com.example.apollokoin.post.postModule
import com.example.apollokoin.usecases.useCasesModule
import com.example.apollokoin.utils.apolloKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApolloKoin : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeDependencyInjection(this)
    }

    private fun initializeDependencyInjection(application: Application) {
        startKoin {
            androidContext(application)
            androidLogger()
            androidFileProperties()
            modules(
                listOf(
                    apolloKoinModule,
                    dataModule,
                    useCasesModule,
                    mainModule,
                    postModule
                )
            )
        }
    }
}
