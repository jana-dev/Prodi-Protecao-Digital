package com.janatavares.prodi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.janatavares.prodi.viewmodel.QuizViewModel

@Composable
fun QuizScreen(quizViewModel: QuizViewModel){

    // Se finalizou o quiz, mostra o resultado final
    if (quizViewModel.showFinalResult) {
        FinalResultDialog(
            score = quizViewModel.score,
            errors = quizViewModel.errors,
            onRestart = { quizViewModel.restartQuiz() }
        )
    } else{
        val currentQuestion = quizViewModel.currentQuestion

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Quiz de Segurança Digital",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = currentQuestion.question,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            // Exibir imagem, se houver
            currentQuestion.imageResId?.let { imageResId ->
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Imagem da pergunta",
                    modifier = Modifier.size(200.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Opções com RadioButton
            Column {
                currentQuestion.options.forEachIndexed { index, option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = quizViewModel.selectedOption == index,
                            onClick = { quizViewModel.selectedOption = index }
                        )
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botão para confirmar resposta e exibir feedback no AlertDialog
            Button(
                onClick = { quizViewModel.confirmAnswer() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF76CBC5))
            ) {
                Text(text = "Confirmar Resposta")
            }
            // Modal para feedback de resposta
            if (quizViewModel.showDialog) {
                AlertDialog(
                    onDismissRequest = { quizViewModel.showDialog = false  },
                    title = {
                        Text(
                            text = if (quizViewModel.isCorrectAnswer) "Resposta Correta!" else "Resposta Incorreta",
                            style = MaterialTheme.typography.titleMedium,
                            color = if (quizViewModel.isCorrectAnswer) Color(0xFF4CAF50) else Color(0xFFF44336)
                        )
                    },
                    text = {
                        Text(
                            text = if (quizViewModel.isCorrectAnswer) {
                                "Parabéns! Você estaria protegido nessa situação!."
                            } else {
                                "Você teria sido um alvo fácil :( Depois confira as Notícias para aprender a seproteger melhor."
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    confirmButton = {
                        Button(
                            onClick = { quizViewModel.nextQuestion() }
                        ) {
                            Text("Próxima Pergunta")
                        }
                    }
                )
            }
        }
    }


}

@Composable
fun FinalResultDialog(score: Int, errors: Int, onRestart: () -> Unit) {
    val message = if (errors == 0) {
        "Parabéns! Você não é um alvo fácil e pode navegar pela web com segurança."
    } else {
        "Você teria sido um alvo fácil e possivelmente seus dados estariam expostos. Tente de novo para praticar!"
    }

    AlertDialog(
        onDismissRequest = {},
        title = { Text("Resultado do Quiz") },
        text = {
            Column {
                Text("Acertos: $score")
                Text("Erros: $errors")
                Spacer(modifier = Modifier.height(16.dp))
                Text(message)
            }
        },
        confirmButton = {
            Button(onClick = onRestart) {
                Text("Recomeçar")
            }
        }
    )
}
