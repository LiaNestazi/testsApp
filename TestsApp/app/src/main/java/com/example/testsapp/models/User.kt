package com.example.testsapp.models

data class User(
    val id: String,
    var name: String,
    var email: String,
    var login: String,
    var password: String,
    var role_id: Int,
    var profile_photo_url: String,
    var profile_cover_url: String
)
