package com.janatavares.prodi.data.model

data class NewsItem(
    val title: String,
    val description: String,
    val imageResId: Int, // Adicione a imagem da notícia
    val fullText: String // Adicione o texto completo da notícia
)