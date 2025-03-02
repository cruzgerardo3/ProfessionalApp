package com.example.professionalapp

import java.io.Serializable

data class Professional(
    val name: String,
    val profession: String,
    val about: String,
    val email: String,
    val phone: String,
    val esperiencia: String,
    val imageResId: Int,
    val trabajos: String
) : Serializable

