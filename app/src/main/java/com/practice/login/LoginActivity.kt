package com.practice.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.practice.mvpwithdagger_udemy.App
import com.practice.mvpwithdagger_udemy.R
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {

    @Inject
    lateinit var presenter: LoginActivityMVP.Presenter
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).getComponent().inject(this)

        firstName = findViewById(R.id.fname_et)
        lastName = findViewById(R.id.lname_et)
        loginButton = findViewById(R.id.login_bt)

        loginButton.setOnClickListener {
            presenter.loginButtonClicked()

        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getCurrentUser()
    }

    override fun getFirstName(): String {
        return firstName.text.toString()
    }

    override fun getLastName(): String {
        return lastName.text.toString()
    }

    override fun showUserNotAvailable() {
        Toast.makeText(this, "Error,user is not available", Toast.LENGTH_SHORT).show()
    }

    override fun showInputError() {
        Toast.makeText(this, "First or last name cannot be empty", Toast.LENGTH_SHORT).show()
    }

    override fun showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show()
    }

    override fun setFirstName(fname: String) {
        firstName.setText(fname)
    }

    override fun setLastName(lname: String) {
        lastName.setText(lname)
    }

}
