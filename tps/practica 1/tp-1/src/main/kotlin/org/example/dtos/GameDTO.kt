package org.example.dtos

data class GameDTO(
    val id: String,
    val name: String,
    val description: String,
    val mainImage: ImageDTO,
    val multimedia: List<ImageDTO>,
    val tags: List<TagDTO>,
    val price: PriceDTO,
    val requirement: RequirementDTO,
    val relatedGames: List<SimpleGameDTO>,
    val developer: DeveloperDTO,
    val releaseDate: String,
    val reviews: List<ReviewDTO>,
    val esrb: String,
    val website: String
)