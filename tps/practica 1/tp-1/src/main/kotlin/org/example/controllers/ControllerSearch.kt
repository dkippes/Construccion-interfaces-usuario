package org.example.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.http.Context
import org.example.dtos.ErrorDTO
import org.example.repository.Repository
import org.example.utils.ObjectMapperConverter
import org.unq.model.Game
import org.unq.model.PageInfo
import org.unq.model.User

object ControllerSearch {
    private val objectMapper = ObjectMapper()
    private val repository = Repository.steamSystem

    fun users(ctx: Context) {
        ctx.contentType("application/json")
        val query = ctx.queryParam("q").toString()
        val page = ctx.queryParam("page")?.toIntOrNull()
        if (page == null || page <= 0) {
            ctx.status(400)
            ctx.result(objectMapper.writeValueAsString(ErrorDTO("Error query param 'page' must be greater or equals than 1", 400)))
            return
        }
        val pageInfo : PageInfo<User> = repository.searchUser(query, page)
        val pageInfoDTO = ObjectMapperConverter.convertToPageInfoUserDTO(pageInfo)
        ctx.result(objectMapper.writeValueAsString(pageInfoDTO))
    }

    fun games(ctx: Context) {
        ctx.contentType("application/json")
        val query = ctx.queryParam("q").toString()
        val page = ctx.queryParam("page")?.toIntOrNull()
        if (page == null || page <= 0) {
            ctx.status(400)
            ctx.result(objectMapper.writeValueAsString(ErrorDTO("Error query param 'page' must be greater or equals than 1", 400)))
            return
        }
        val pageInfo : PageInfo<Game> = repository.searchGame(query, page)
        val pageInfoDTO = ObjectMapperConverter.convertToPageInfoGameDTO(pageInfo)
        ctx.result(objectMapper.writeValueAsString(pageInfoDTO))
    }
}