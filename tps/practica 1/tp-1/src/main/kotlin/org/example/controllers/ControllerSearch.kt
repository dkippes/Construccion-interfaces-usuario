package org.example.controllers

import io.javalin.http.Context
import org.example.repository.Repository

object ControllerSearch {
    fun users(ctx: Context) {
        ctx.result("Users")
    }

    fun games(ctx: Context) {
        ctx.result("Games")
    }
}