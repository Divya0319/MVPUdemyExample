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
                model.createUser(view?.getFirstName(), view?.getLastName())
                view?.showUserSavedMessage()
            }
        }
    }

    override fun getCurrentUser() {
        var user = model.getUser()
        if (user == null) {
            if (view != null) {
                view?.showUserNotAvailable()
            }
        } else {
            if (view != null) {
                view?.setFirstName(view!!.getFirstName())
                view?.setLastName(view!!.getLastName())
            }
        }

    }
}