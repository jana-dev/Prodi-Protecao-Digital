package com.janatavares.prodi.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PasswordSimulatorScreen(){
    var password by remember {mutableStateOf("")}
    var passwordStrength by remember {mutableStateOf("Digite uma senha para verificar")}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Simulador de força de senha",
            style = MaterialTheme.typography.headlineSmall
        )

        // Input de Senha
        PasswordInput(password) { newPassword ->
            password = newPassword
            passwordStrength = checkPasswordStrength(password)

        }

        // Indicador de Força de Senha
        PasswordStrengthIndicator(passwordStrength)

        // Informativo sobre Senhas Fortes
        PasswordTips()

    }
}

@Composable
fun PasswordInput(password: String, onPasswordChange: (String) -> Unit){
    var isPasswordVisible by remember  { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Senha") },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Person else Icons.Default.Lock,
                    contentDescription = if (isPasswordVisible) "Esconder senha" else "Mostrar senha"
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

// Função para verificar a força da senha
fun checkPasswordStrength(password: String): String {
    return when {
        password.length < 6 -> "Muito fraca"
        password.any { it.isDigit() } && password.any { it.isUpperCase() } &&
                password.any { !it.isLetterOrDigit() } -> "Forte"
        password.any { it.isDigit() || it.isUpperCase() } -> "Moderada"
        else -> "Fraca"
    }
}

// Indicador de força de senha
@Composable
fun PasswordStrengthIndicator(strength: String) {
    Text(
        text = "Força da senha: $strength",
        color = when (strength) {
            "Muito fraca" -> Color.Red
            "Fraca" -> Color(0xFFFFA500) // Laranja
            "Moderada" -> Color(0xFFFFD700) // Amarelo
            "Forte" -> Color(0xFF76BC5B) // Verde
            else -> Color.Gray
        },
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

// Informativo sobre senhas fortes
@Composable
fun PasswordTips() {
    Text(
        text = "Dicas para uma senha forte:\n" +
                "- Use ao menos 8 caracteres.\n" +
                "- Inclua números, letras maiúsculas e minúsculas.\n" +
                "- Adicione caracteres especiais (ex: @, #, !).",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
    )
}
