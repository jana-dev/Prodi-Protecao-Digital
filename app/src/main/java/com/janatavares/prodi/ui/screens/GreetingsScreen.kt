package com.janatavares.prodi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.janatavares.prodi.R

@Composable
fun GreetingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center, // Centraliza verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centraliza horizontalmente
    ) {

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logoprodi),
            contentDescription = "Logo Prodi Proteção Digital",
            modifier = Modifier.size(300.dp) // Tamanho da logo
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Titulo
        Text(
            text = "Boas vindas ao PRODI",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Descrição
        Text(
            text = "Melhorando sua segurança na internet",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}
