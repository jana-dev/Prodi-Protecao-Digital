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
            question = "Este e-mail é considerado um Pishing Attack?",
            options = listOf("Não, este e-mail é confiável.", "Não pois tem a logo dos Correios que é uma empresa famosa.", "Sim primeiramente foi direto para o lixo eletrônico e também o endereço eletrônico não é oficial dos correios."),
            correctAnswerIndex = 2,
            imageResId = R.drawable.emailcorreios
        ),
        QuizQuestion(
            question = "Qual destes links demonstra ser de um site oficial? www.casasbahia.com.br ou www.sitecasasbahia.com.br",
            options = listOf("www.casasbahia.com.br", "www.sitecasasbahia.com.br"),
            correctAnswerIndex = 0
        )
        //Adicionar aqui mais perguntas
    )
}