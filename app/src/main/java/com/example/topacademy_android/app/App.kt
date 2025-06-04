package com.example.topacademy_android.app

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext
import com.example.topacademy_android.app.di.dataModule
import com.example.topacademy_android.app.di.domainModule
import com.example.topacademy_android.app.di.presentationModule
import com.example.topacademy_android.app.di.networkModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                dataModule,
                domainModule,
                presentationModule,
                networkModule
            )
        }
    }
}
