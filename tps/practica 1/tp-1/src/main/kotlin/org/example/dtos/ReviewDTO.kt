package org.example.dtos

data class ReviewDTO(
    val id: String,
    val user: SimpleUserDTO,
    val game: SimpleGameDTO,
    val isRecommended: Boolean,
    val text: String
)