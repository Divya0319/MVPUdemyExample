package com.practice.mvpwithdagger_udemy

import android.app.Application
import com.practice.login.LoginModule
import javax.inject.Inject

class App : Application() {
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .loginModule(LoginModule())
            .build()
    }

    fun getComponent(): ApplicationComponent {
        return component
    }
}