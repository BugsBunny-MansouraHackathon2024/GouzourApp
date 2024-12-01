package com.bugsbunny.gouzour.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Specifications(
    @SerialName("color")
    val depth: Double,
    @SerialName("type")
    val height: Double,
    @SerialName("width")
    val width: Double
)