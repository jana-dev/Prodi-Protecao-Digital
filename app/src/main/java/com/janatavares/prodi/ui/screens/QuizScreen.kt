package com.janatavares.prodi.ui.screens

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.dialog.DialogDefaults
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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                Text(
                    text = "Quiz de Segurança Digital",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item{
                Text(
                    text = currentQuestion.question,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // Exibir imagem, se houver
            currentQuestion.imageResId?.let { imageResId ->
                item{
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = "Imagem da pergunta",
                        modifier = Modifier.size(300.dp)
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Opções com RadioButton
            items(currentQuestion.options.size) { index ->
                val option = currentQuestion.options[index]
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth() // Preenche toda a largura disponível
                        .padding(vertical = 4.dp)
                        .clickable { quizViewModel.selectedOption = index },
                    horizontalArrangement = Arrangement.Start // Alinhamento à esquerda
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

            item {
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
                        onDismissRequest = { /* Não feche o dialog quando clicar fora */ },
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
                                    "Parabéns! Você estaria protegido nessa situação!"
                                } else {
                                    "Você teria sido um alvo fácil :( Depois confira as Notícias para aprender a se proteger melhor."
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
                        },

                    )
                }
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
        },
    )
}
