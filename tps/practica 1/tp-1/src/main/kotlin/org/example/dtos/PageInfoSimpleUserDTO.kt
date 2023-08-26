package org.example.dtos

data class PageInfoSimpleUserDTO(
    val currentPage: Int,
    val amountOfElements: Int,
    val amountOfPages: Int,
    val list: List<SimpleUserDTO>
)