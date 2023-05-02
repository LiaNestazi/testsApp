package com.example.testsapp.models

import androidx.compose.ui.graphics.vector.ImageVector

data class Test(
    val id: String,
    var name: String,
    var description: String,
    var rating: Int,
    var image_id: String,
    val author_id: String
)
