package com.example.firstapplemon.presentation.update

interface NewPostView{
    fun updatedSuccessfully()
    fun showError(message: String?)
    fun createdSuccessfully()
}