package com.janatavares.prodi.data.repository

import com.janatavares.prodi.R

data class QuizQuestion (
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val imageResId: Int? = null
)

object QuizRepository {
    val questions = listOf(
        QuizQuestion(
            question = "Qual destes é um exemplo de Pishing?",
            options = listOf("Email de recuperação de senha do banco", "Oferta de empréstimo com link desconhecido", "SMS de um amigo"),
            correctAnswerIndex = 0,
            imageResId = R.drawable.newsimage
        ),
        QuizQuestion(
            question = "Qual destes links demonstra ser de um site oficial? www.casasbahia.com.br ou www.sitecasasbahia.com.br",
            options = listOf("www.casasbahia.com.br", "www.sitecasasbahia.com.br"),
            correctAnswerIndex = 0
        )
        //Adicionar aqui mais perguntas
    )
}