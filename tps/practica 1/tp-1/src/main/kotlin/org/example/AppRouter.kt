package org.example

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.example.controllers.*
import org.unq.data.initSteamSystem

fun main() {
    val steamSystem = initSteamSystem()
    Javalin.create()
        .routes {
            path("login") {
                post(Controller::login)
            }
            path("register") {
                post(Controller::register)
            }
            path("users") {
                path("current") {
                    get(ControllerUsers::current)
                }
                path("{id}") {
                    get(ControllerUsers::getId)
                    path("friends") {
                        put(ControllerUsers::friends)
                    }
                }
            }
            path("games") {
                get(ControllerGames::games)
                path("recommended") {
                    get(ControllerGames::recommended)
                }
                path("{id}") {
                    get(ControllerGames::getId)
                    path("reviews") {
                        put(ControllerGames::reviews)
                    }
                    path("purchase") {
                        post(ControllerGames::purchase)
                    }
                }
            }
            path("tags") {
                get(ControllerTags::tags)
            }
            path("search") {
                path("users") {
                    get(ControllerSearch::users)
                }
                path("games") {
                    get(ControllerSearch::games)
                }
            }
        }
        .start(7070)
}

