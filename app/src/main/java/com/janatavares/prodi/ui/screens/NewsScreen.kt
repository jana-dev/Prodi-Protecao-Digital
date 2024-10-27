package com.janatavares.prodi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.janatavares.prodi.R

@Composable
fun NewsScreen(){
    val sampleNews = listOf(
        NewsItem("Novo ataque de phishing em redes sociais", "Fique atento aos novos métodos de phishing que estão circulando."),
        NewsItem("Vazamento de dados de grandes empresas", "Hackers acessaram milhões de contas de usuários."),
        NewsItem("Importância das senhas fortes", "Entenda como senhas complexas podem proteger sua segurança online."),
        NewsItem("Novo ataque de phishing em redes sociais", "Fique atento aos novos métodos de phishing que estão circulando."),
        NewsItem("Vazamento de dados de grandes empresas", "Hackers acessaram milhões de contas de usuários."),
        NewsItem("Importância das senhas fortes", "Entenda como senhas complexas podem proteger sua segurança online."),
    )

    Text(
        text = "Notícias",
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(top = 16.dp,bottom = 16.dp)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(sampleNews){ news ->
            NewsCard(news)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun NewsCard(news: NewsItem){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface// ou use qualquer cor que prefira para o fundo do Card
        )
        ){
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            // Imagem à esquerda
            Image(
                painter = painterResource(id = R.drawable.newsimage),
                contentDescription = "Imagem da notícia",
                modifier = Modifier
                    .size(150.dp)
                    .padding(end = 16.dp) // Espaço entre imagem e texto
            )

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = news.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = news.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview(){
    NewsScreen()
}

data class NewsItem(
    val title: String,
    val description: String
)