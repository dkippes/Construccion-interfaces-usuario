package org.example.dtos

data class RegisterUserBody(
    val email: String,
    val password: String,
    val name: String,
    val image: String,
    val backgroundImage: String
)