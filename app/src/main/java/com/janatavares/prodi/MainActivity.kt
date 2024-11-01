package com.janatavares.prodi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.janatavares.prodi.data.model.NewsItem
import com.janatavares.prodi.ui.theme.ProdiTheme
import com.janatavares.prodi.ui.components.BottomNavBar
import com.janatavares.prodi.ui.screens.*
import com.janatavares.prodi.viewmodel.QuizViewModel

class MainActivity : ComponentActivity() {

    // Instancia o ViewModel da Activity
    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProdiTheme {
                // Chama a função TelaInicial para ser exibida
                TelaInicial(quizViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaInicial(quizViewModel: QuizViewModel){

    var selectedItem by remember { mutableStateOf(0) } // Controla o item selecionado
    var selectedNewsItem by remember { mutableStateOf<NewsItem?>(null) }


    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("PRODI - Proteção Digital")},

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        },
        bottomBar = {
            BottomNavBar(selectedItem = selectedItem, onItemSelected = {
                selectedItem = it
                selectedNewsItem = null // Limpa a notícia selecionada ao trocar de aba
            })
        },
        content = { innerPadding ->
            //Componentes futuros
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                if (selectedNewsItem != null) {
                    NewsDetailScreen(newsItem = selectedNewsItem!!) {
                        selectedNewsItem = null // Volta para a lista de notícias
                    }
            } else{
                    when (selectedItem) {
                        0 -> GreetingsScreen()
                        1 -> NewsScreen { newsItem ->
                            selectedNewsItem = newsItem // Armazena o item de notícia selecionado)
                        }
                        2 -> PasswordSimulatorScreen()
                        3 -> QuizScreen(quizViewModel = quizViewModel)
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun TelaInicialPreview() {
    ProdiTheme {
        //TelaInicial()
    }
}