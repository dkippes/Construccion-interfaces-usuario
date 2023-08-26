package org.example.dtos

data class SimpleGameDTO(
    val id: String,
    val name: String,
    val mainImage: ImageDTO,
    val tags: List<TagDTO>,
    val price: PriceDTO
)