package org.example.dtos

data class RequirementDTO(
    val os: List<String>,
    val processor: List<String>,
    val memory: Int,
    val graphics: List<String>,
    val directX: String,
    val storage: Int
)