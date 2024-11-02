package com.janatavares.prodi.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavBar(selectedItem: Int, onItemSelected: (Int) -> Unit) {

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background, // Fundo transparente
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "Notícias",
                    tint = if (selectedItem == 1) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surface // Cor do ícone com base na seleção
                )
            },
            selected = selectedItem == 1, // Verifica se este item está selecionado
            onClick = {
                onItemSelected(1) // Define o item como selecionado
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent // Fundo transparente
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "Simulador de Senhas",
                    tint = if (selectedItem == 2) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surface // Cor do ícone com base na seleção
                )
            },
            selected = selectedItem == 2, // Verifica se este item está selecionado
            onClick = {
                onItemSelected(2)
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent // Fundo transparente
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.CheckCircle,
                    contentDescription = "Quiz de Segurança",
                    tint = if (selectedItem == 3) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surface // Cor do ícone com base na seleção
                )
            },
            selected = selectedItem == 3, // Verifica se este item está selecionado
            onClick = {
                onItemSelected(3)
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent // Fundo transparente
            )
        )
    }
}
