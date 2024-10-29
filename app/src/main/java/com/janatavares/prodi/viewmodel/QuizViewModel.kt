package com.janatavares.prodi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.janatavares.prodi.data.repository.QuizRepository

class QuizViewModel: ViewModel(){
    private val questions = QuizRepository.questions
    var currentIndex by mutableStateOf(0)
        private set
    var score by mutableStateOf(0)
        private set
    var errors by mutableStateOf(0)
        private set
    var selectedOption by mutableStateOf(-1)
    var showFinalResult by mutableStateOf(false)
        private set
    var showDialog by mutableStateOf(false)
    var isCorrectAnswer by mutableStateOf(false)
        private set
    val currentQuestion get() = questions[currentIndex]

    fun confirmAnswer(){
        isCorrectAnswer = selectedOption == currentQuestion.correctAnswerIndex
        if (isCorrectAnswer) {
            score++
        } else {
            errors++
        }
        showDialog = true
    }

    fun nextQuestion() {
        showDialog = false
        selectedOption = -1
        if (currentIndex < questions.size - 1) {
            currentIndex++
        } else {
            showFinalResult = true
        }
    }

    fun restartQuiz() {
        currentIndex = 0
        score = 0
        errors = 0
        selectedOption = -1
        showFinalResult = false
    }
}