package com.practice.login

class MemoryRepository : LoginRepository {
    private var user: User? = null
    override fun getUser(): User {
        if (user == null) {
            val user = User("Divya", "Gupta")
            user.setId(0)
            return user
        } else {
            return user as User
        }
    }

    override fun saveUser(user: User) {
        if (user == null) {
            this.user = getUser()
        }
        this.user = user
    }
}