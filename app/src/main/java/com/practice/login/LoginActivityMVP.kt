package com.practice.login

interface LoginActivityMVP {
    interface View {

        fun getFirstName(): String
        fun getLastName(): String

        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSavedMessage()

        fun setFirstName(fname: String)
        fun setLastName(lname: String)

    }

    interface Presenter {

        fun setView(view: View)

        fun loginButtonClicked()

        fun getCurrentUser()

    }

    interface Model {
        fun createUser(fname: String?, lname: String?)
        fun getUser(): User
    }
}