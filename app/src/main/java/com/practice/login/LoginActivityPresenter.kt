package com.practice.login

import org.jetbrains.annotations.Nullable

class LoginActivityPresenter(private var model: LoginActivityMVP.Model) : LoginActivityMVP.Presenter {

    @Nullable
    private var view: LoginActivityMVP.View? = null

    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }


    override fun loginButtonClicked() {
        if (view != null) {
            if (view?.getFirstName().toString().trim() == "" || view?.getLastName().toString().trim() == "") {
                view?.showInputError()
            } else {
                model.createUser(view?.getFirstName().toString(), view?.getLastName().toString())
                view?.showUserSavedMessage()
            }
        }
    }

    override fun getCurrentUser() {
        val user = model.getUser()

        if (view != null) {
            view?.setFirstName(user?.firstName.toString())
            view?.setLastName(user?.lastName.toString())
        } else {
            view?.showUserNotAvailable()

        }


    }

    override fun saveUser() {
        if (view != null) {
            if (view?.getFirstName()?.trim().equals("") || view?.getLastName()?.trim().equals("")) {
                view?.showInputError()
            } else {

                model.createUser(view?.getFirstName().toString(), view?.getLastName().toString())
                view?.showUserSavedMessage()

            }
        }
    }
}