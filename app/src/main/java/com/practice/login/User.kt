package com.practice.login

class User(private var firstName: String?, private var lastName: String?) {
    private var id: Int = -1
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }
}