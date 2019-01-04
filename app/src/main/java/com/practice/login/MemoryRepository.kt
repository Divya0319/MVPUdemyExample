package com.practice.login

class MemoryRepository : LoginRepository {
    private var user: User? = null
    override fun getUser(): User? {
        return if (user == null) {
            val user = User("Divya", "Gupta")
            user.id = 0
            this.user = user
            this.user
        } else {
            user
        }
    }

    override fun saveUser(user: User) {
        if (this.user == null) {
            this.user = getUser()
        }
        this.user = user
    }
}