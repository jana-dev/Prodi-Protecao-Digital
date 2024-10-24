package com.janatavares.prodi.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NewsScreen(){
    Text(text = "Notícias")
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview(){
    NewsScreen()
}