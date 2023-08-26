package org.example.controllers

import io.javalin.http.Context
import org.example.repository.Repository

object ControllerGames {
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
        ctx.result("Purchase")
    }
}