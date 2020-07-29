package com.example.apollokoin.data

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val dataModule = module {

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            )
            .build()
    }

    single<ApolloClient> {
        ApolloClient.builder()
            .serverUrl("https://api.graph.cool/simple/v1/ciyz901en4j590185wkmexyex")
            .okHttpClient(get())
            .build()
    }

    single<ApiGateway> {
        ApolloApiGateway(
            get()
        )
    }
}
