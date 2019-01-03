package com.practice.mvpwithdagger_udemy

import com.practice.login.LoginActivity
import com.practice.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LoginModule::class])
interface ApplicationComponent {

    fun inject(target: LoginActivity)
}