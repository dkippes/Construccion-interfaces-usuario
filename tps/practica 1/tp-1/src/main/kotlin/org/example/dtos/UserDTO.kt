package org.example.dtos

import com.fasterxml.jackson.annotation.JsonManagedReference

data class UserDTO(
    val id: String,
    val email: String,
    val name: String,
    val image: String,
    val backgroundImage: String,
    @JsonManagedReference
    val games: List<SimpleGameDTO>,
    @JsonManagedReference
    val friends: List<SimpleUserDTO>
)