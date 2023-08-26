package org.example.dtos

data class AddReviewBody(
    val isRecommended: Boolean,
    val text: String
)