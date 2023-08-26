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
                get(Controller::login)
            }
            path("register") {
                get(Controller::register)
            }
            path("users") {
                path("current") {
                    get(ControllerUsers::current)
                }
                path("{id}") {
                    get(ControllerUsers::getId)
                    path("friends") {
                        get(ControllerUsers::friends)
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
                        get(ControllerGames::reviews)
                    }
                    path("purchase") {
                        get(ControllerGames::purchase)
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

