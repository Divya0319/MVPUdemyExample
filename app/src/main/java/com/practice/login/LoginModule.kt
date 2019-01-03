package com.practice.login

import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginActivityPresenter(model: LoginActivityMVP.Model): LoginActivityMVP.Presenter {
        return LoginActivityPresenter(model)

    }

    @Provides
    fun provideLoginActivityModel(repository: LoginRepository): LoginActivityMVP.Model {
        return LoginModel(repository)

    }

    @Provides
    fun provideLoginActivityRepository(): LoginRepository {
        return MemoryRepository()

    }


}