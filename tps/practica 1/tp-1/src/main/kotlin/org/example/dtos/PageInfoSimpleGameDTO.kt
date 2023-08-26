package org.example.dtos

data class PageInfoSimpleGameDTO(
    val currentPage: Int,
    val amountOfElements: Int,
    val amountOfPages: Int,
    val list: List<SimpleGameDTO>
)