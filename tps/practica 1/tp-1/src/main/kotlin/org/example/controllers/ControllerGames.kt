package org.example.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.http.Context
import org.example.dtos.ErrorDTO
import org.example.dtos.PurchaseBody
import org.example.repository.Repository
import org.example.utils.ObjectMapperConverter
import org.unq.model.CardInfo
import org.unq.model.DraftPurchase
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ControllerGames {
    private val objectMapper = ObjectMapper()
    private val repository = Repository.steamSystem

    fun games(ctx: Context) {
        ctx.result("Games")
    }

    fun recommended(ctx: Context) {
        ctx.result("Recommended")
    }

    fun getId(ctx: Context) {
        ctx.result("Id")
    }

    fun reviews(ctx: Context) {
        ctx.result("Reviews")
    }

    fun purchase(ctx: Context) {
        ctx.contentType("application/json")
        val id = ctx.pathParam("id")
        val userId = "u_1" // * HARDCODEADO HASTA QUE TENGAMOS EL JWT
        val body =  validatePurchaseBody(ctx)
        val user = repository.getUser(userId)

        try {
            repository.getGame(id)
        } catch (e: Exception) {
            ctx.status(404)
            ctx.result(objectMapper.writeValueAsString(ErrorDTO("Game id not found", 404)))
            return
        }
        if (user.games.any { it.id == id }) {
            ctx.status(400)
            ctx.result(objectMapper.writeValueAsString(ErrorDTO("User already has the game", 400)))
        } else {
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val date = LocalDate.parse(body.expirationDate, formatter)
            val cardInfo = CardInfo(body.cardHolderName, body.cvv, date, body.number)
            val games = repository.purchaseGame(userId, DraftPurchase(id, cardInfo))
            val userDTO = ObjectMapperConverter.convertToUserDTO(games)
            ctx.result(objectMapper.writeValueAsString(userDTO))
        }
    }

    private fun validatePurchaseBody(ctx: Context): PurchaseBody {
        val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return ctx.bodyValidator(PurchaseBody::class.java)
            .check({ it.cardHolderName != "" }, "Card holder name can't be empty")
            .check({ it.cvv != 0 }, "CVV can't be zero")
            .check({ it.expirationDate != "" }, "Expiration date can't be empty")
            .check({ isValidDate(it.expirationDate, dateFormatter) }, "Invalid date format for expirationDate")
            .check({ it.number != 0 }, "Card number can't be zero")
            .get()
    }

    private fun isValidDate(date: String, formatter: DateTimeFormatter): Boolean {
        return try {
            LocalDate.parse(date, formatter)
            true
        } catch (e: Exception) {
            false
        }
    }
}