package org.example.dtos

data class PurchaseBody(
    val cardHolderName: String = "",
    val cvv: Int = 0,
    val expirationDate: String = "",
    val number: Int = 0
)