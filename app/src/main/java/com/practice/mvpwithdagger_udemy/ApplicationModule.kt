package com.practice.mvpwithdagger_udemy

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ApplicationModule {

    private var application: Application

    constructor(application: Application) {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}