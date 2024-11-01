package com.janatavares.prodi.data.repository

import com.janatavares.prodi.R
import com.janatavares.prodi.data.model.NewsItem

object NewsRepository {
    val newsList = listOf(
        NewsItem(
            title = "Novo ataque de phishing em redes sociais",
            description = "Fique atento aos novos métodos de phishing que estão circulando.",
            imageResId = R.drawable.newsimage,
            fullText = "Descrição completa da notícia 1"
        ),
        NewsItem(
            title = "Novo ataque de phishing em redes sociais",
            description = "Fique atento aos novos métodos de phishing que estão circulando.",
            imageResId = R.drawable.newsimage,
            fullText = "Descrição completa da notícia 2"
        ),
        NewsItem(
            title = "Novo ataque de phishing em redes sociais",
            description = "Fique atento aos novos métodos de phishing que estão circulando.",
            imageResId = R.drawable.newsimage,
            fullText = "Descrição completa da notícia 3"
        ),
        NewsItem(
            title = "Novo ataque de phishing em redes sociais",
            description = "Fique atento aos novos métodos de phishing que estão circulando.",
            imageResId = R.drawable.newsimage,
            fullText = "Descrição completa da notícia 4"
        ),
        NewsItem(
            title = "Novo ataque de phishing em redes sociais",
            description = "Fique atento aos novos métodos de phishing que estão circulando.",
            imageResId = R.drawable.newsimage,
            fullText = "Descrição completa da notícia 5"
        )
    )
}