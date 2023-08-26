package org.example.controllers

import io.javalin.http.Context
import io.javalin.http.bodyValidator
import org.example.repository.Repository

object Controller {
    fun login(ctx: Context) {
        ctx.result(Repository.steamSystem.users.get(1).name)
    }

    fun register(ctx: Context) {
        ctx.result("Register")
    }
}