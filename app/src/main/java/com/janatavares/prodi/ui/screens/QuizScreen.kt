package com.janatavares.prodi.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun QuizScreen(){
    Text(text = "Quiz, será que você sabe se proteger digitalmente?")
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview(){
    QuizScreen()
}