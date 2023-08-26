package org.example.dtos

data class PurchaseBody(
    val cardHolderName: String,
    val cvv: Int,
    val expirationDate: String,
    val number: Int
)