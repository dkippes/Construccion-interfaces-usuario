package org.example.controllers

import io.javalin.http.Context
import org.example.repository.Repository

object ControllerTags {
    fun tags(ctx: Context) {
        ctx.result("Tags")
    }
}