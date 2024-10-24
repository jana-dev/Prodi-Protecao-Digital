package com.janatavares.prodi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.janatavares.prodi.R

@Composable
fun GreetingsScreen(){
    // Espaço para a logo
    Spacer(modifier = Modifier.padding(24.dp))
    // Adiciona a logo (aqui será uma imagem temporária)
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

@Preview(showBackground = true)
@Composable
fun GreetingsScreenPreview(){
    NewsScreen()
}