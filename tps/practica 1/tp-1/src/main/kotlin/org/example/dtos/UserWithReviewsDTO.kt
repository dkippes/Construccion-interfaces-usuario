package org.example.dtos

data class UserWithReviewsDTO(
    val id: String,
    val email: String,
    val name: String,
    val image: String,
    val backgroundImage: String,
    val games: List<SimpleGameDTO>,
    val friends: List<SimpleUserDTO>,
    val reviews: List<ReviewDTO>
)