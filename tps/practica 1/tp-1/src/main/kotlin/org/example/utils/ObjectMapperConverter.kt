package org.example.utils

import org.example.dtos.*
import org.unq.model.*

class ObjectMapperConverter {
    companion object {
        fun convertToUserDTO(user: User): UserDTO {
            return UserDTO(
                user.id,
                user.email,
                user.name,
                user.image,
                user.backgroundImage,
                convertToListSimpleGameDTO(user.games),
                convertToListSimpleUserDTO(user.friends)
            )
        }

        private fun convertToListSimpleUserDTO(friends: List<User>): List<SimpleUserDTO> {
            return friends.map { SimpleUserDTO(it.id, it.name, it.image) }
        }

        fun convertToListSimpleGameDTO(games: List<Game>): List<SimpleGameDTO> {
            return games.map { SimpleGameDTO(it.id, it.name, convertToImageDTO(it.mainImage.src), convertToListTagDTO(it.tags), convertToPriceDTO(it.price)) }
        }

        private fun convertToPriceDTO(price: Price): PriceDTO {
            return PriceDTO(price.amount, price.currency)
        }

        fun convertToListTagDTO(tags: List<Tag>): List<TagDTO> {
            return tags.map { convertToTagDTO(it) }
        }

        fun convertToTagDTO(tag: Tag): TagDTO {
            return TagDTO(tag.id, tag.name, convertToImageDTO(tag.image.src))
        }

        fun convertToImageDTO(image: String): ImageDTO {
            return ImageDTO(image)
        }

        fun convertToPageInfoUserDTO(pageInfo: PageInfo<User>): Any {
            return PageInfoSimpleUserDTO(pageInfo.currentPage, pageInfo.amountOfElements, pageInfo.amountOfPages,
                convertToListSimpleUserDTO(pageInfo.list)
            )
        }

        fun convertToPageInfoGameDTO(pageInfo: PageInfo<Game>): Any {
            return PageInfoSimpleGameDTO(pageInfo.currentPage, pageInfo.amountOfElements, pageInfo.amountOfPages,
                convertToListSimpleGameDTO(pageInfo.list)
            )
        }
    }
}