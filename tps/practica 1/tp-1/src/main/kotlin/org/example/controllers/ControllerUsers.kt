package org.example.controllers

import io.javalin.http.Context
import org.example.repository.Repository

object ControllerUsers {
    fun current(ctx: Context) {
        ctx.result("Current")
    }

    fun getId(ctx: Context) {
        ctx.result("GetId")
    }

    fun friends(ctx: Context) {
        ctx.result("Friends")
    }
}