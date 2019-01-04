package com.practice.login

class LoginModel(private var repository: LoginRepository) : LoginActivityMVP.Model {

    override fun createUser(fname: String, lname: String) {
        repository.saveUser(User(fname, lname))
    }

    override fun getUser(): User? {
        return repository.getUser()
    }
}