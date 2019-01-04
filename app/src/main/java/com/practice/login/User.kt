package com.practice.login

class User(firstName: String, lastName: String) {
    var id: Int = -1
    var firstName: String? = null
    var lastName: String? = null

    init {
        this.firstName = firstName
        this.lastName = lastName

    }
}