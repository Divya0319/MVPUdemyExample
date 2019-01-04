package com.practice.mvpwithdagger_udemy

import com.practice.login.LoginActivityMVP
import com.practice.login.LoginActivityPresenter
import com.practice.login.User
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class PresenterTests {

    lateinit var mockLoginModel: LoginActivityMVP.Model
    lateinit var mockView: LoginActivityMVP.View
    lateinit var presenter: LoginActivityPresenter
    lateinit var user: User

    @Before
    fun setup() {
        mockLoginModel = mock(LoginActivityMVP.Model::class.java)
        user = User("Divya", "Gupta")

        //`when`(mockLoginModel.getUser()).thenReturn(user)

        mockView = mock(LoginActivityMVP.View::class.java)

        presenter = LoginActivityPresenter(mockLoginModel)

        presenter.setView(mockView)
    }

//    @Test
//    fun noInteractionWithView() {
//        presenter.getCurrentUser()
//        verifyZeroInteractions(mockView)
//    }

    @Test
    fun loadTheUserFromRepositoryWhenValidUserIsPresent() {
        `when`(mockLoginModel.getUser()).thenReturn(user)
        presenter.getCurrentUser()

        //verify model interactions
        verify(mockLoginModel, times(1)).getUser()

        //verify view interactions
        verify(mockView, times(1)).setFirstName("Divya")
        verify(mockView, times(1)).setLastName("Gupta")
        verify(mockView, never()).showUserNotAvailable()

    }

//    @Test
//    fun showShowErrorMessageWHenUserIsNull() {
//        `when`(mockLoginModel.getUser()).thenReturn(null)
//
//        presenter.getCurrentUser()
//
//        //verify model interactions
//        verify(mockLoginModel, times(1)).getUser()
//
//        //verify view interactions
//        verify(mockView, never()).setFirstName("Divya")
//        verify(mockView, never()).setLastName("Gupta")
//        verify(mockView, times(1)).showUserNotAvailable()
//    }

    @Test
    fun shouldCreateErrorMessageIfFieldsAreEmpty() {

        //set up view mock
        `when`(mockView.getFirstName()).thenReturn("")
        presenter.saveUser()

        verify(mockView, times(1)).getFirstName()
        verify(mockView, never()).getLastName()
        verify(mockView, times(1)).showInputError()

        //now tell mockview to return a value for first name and empty last name
        `when`(mockView.getFirstName()).thenReturn("Dana")
        `when`(mockView.getLastName()).thenReturn("")

        presenter.saveUser()

        verify(mockView, times(2)).getFirstName() //Called 2 times now, once before , and once now
        verify(mockView, times(1)).getLastName() //Called only once
        verify(mockView, times(2)).showInputError() // Called 2 times now, once before, and once now


    }

    @Test
    fun shouldBeAbleToSaveAValidUser() {
        `when`(mockView.getFirstName()).thenReturn("Dana")
        `when`(mockView.getLastName()).thenReturn("Scully")

        presenter.saveUser()

        //called two more times in the saveUser call
        verify(mockView, times(2)).getFirstName()
        verify(mockView, times(2)).getLastName()

        //Make sure the repository saved the user
        verify(mockLoginModel, times(1)).createUser("Dana", "Scully")

        //Make sure that the view showed the user saved message
        verify(mockView, times(1)).showUserSavedMessage()

    }
}