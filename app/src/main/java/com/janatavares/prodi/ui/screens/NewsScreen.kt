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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.janatavares.prodi.data.repository.NewsRepository
import androidx.compose.foundation.clickable
import com.janatavares.prodi.data.model.NewsItem

@Composable
fun NewsScreen(onNewsClick: (NewsItem) -> Unit){
    val newsList = NewsRepository.newsList

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
        items(newsList){ news ->
            NewsCard(news = news, onClick = { onNewsClick(news) })
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun NewsCard(news: com.janatavares.prodi.data.model.NewsItem, onClick: () -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
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
                painter = painterResource(id = news.imageResId),
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
    NewsScreen(onNewsClick = {})
}

data class NewsItem(
    val title: String,
    val description: String
)