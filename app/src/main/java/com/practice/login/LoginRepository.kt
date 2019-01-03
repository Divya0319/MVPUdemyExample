package com.practice.login

interface LoginRepository {

    fun getUser(): User
    fun saveUser(user: User)
}