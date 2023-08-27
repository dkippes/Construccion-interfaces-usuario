package org.example.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.http.Context
import org.example.dtos.TagDTO
import org.example.repository.Repository
import org.example.utils.ObjectMapperConverter
import javax.swing.text.html.HTML.Tag

object ControllerTags {
    private val objectMapper = ObjectMapper()
    private val repository = Repository.steamSystem

    fun tags(ctx: Context) {
        ctx.contentType("application/json")
        val tags = repository.tags
        val tagsDTOs: List<TagDTO> = ObjectMapperConverter.convertToListTagDTO(tags)
        ctx.result(objectMapper.writeValueAsString(tagsDTOs))
    }
}