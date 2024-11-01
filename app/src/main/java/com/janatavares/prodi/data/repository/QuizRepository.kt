package com.janatavares.prodi.data.repository

import com.janatavares.prodi.R

data class QuizQuestion (
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val imageResId: Int? = null
)

object QuizRepository {
    val questions = listOf(
        QuizQuestion(
            question = "Este e-mail é considerado um Pishing?",
            options = listOf(
                "Não, este e-mail é confiável.",
                "Não pois tem a logo dos Correios que é uma empresa famosa.",
                "Sim pois foi direto para o lixo eletrônico e também o endereço eletrônico não é oficial dos correios."
            ),
            correctAnswerIndex = 2,
            imageResId = R.drawable.emailcorreios
        ),
        QuizQuestion(
            question = "Qual destes links demonstra ser de um site oficial? www.casasbahia.com.br ou www.sitecasasbahia.com.br",
            options = listOf(
                "www.casasbahia.com.br",
                "www.sitecasasbahia.com.br"
            ),
            correctAnswerIndex = 0
        ),
        QuizQuestion(
            question = "Você recebe um SMS dizendo que seu banco bloqueou sua conta e que é necessário clicar em um link para desbloqueá-la. O que você faz?",
            options = listOf(
                "Clica no link imediatamente para resolver o problema.",
                "Entra em contato com o banco por meio do número oficial para verificar a mensagem.",
                "Ignora a mensagem e espera o problema se resolver sozinho.",
                "Responde ao SMS pedindo mais informações."
            ),
            correctAnswerIndex = 1
        ),
        QuizQuestion(
            question = "Qual é uma forma eficaz de identificar um site falso de compras online?",
            options = listOf(
                "Conferir se o site tem ofertas muito mais baratas que outros concorrentes.",
                "Verificar se o site é colorido e chamativo",
                "Acessar o site por meio de links em redes sociais.",
                "Verificar se a URL começa com \"https\" e observar se há um cadeado na barra de endereço."
            ),
            correctAnswerIndex = 3
        ),
        QuizQuestion(
            question = "Se você recebe um e-mail de uma instituição bancária pedindo informações pessoais, qual seria a ação correta a se tomar?",
            options = listOf(
                "Responder ao e-mail com as informações solicitadas.",
                "Ligar para a instituição para confirmar se o e-mail é verdadeiro.",
                "Clicar nos links do e-mail para verificar se ele é legítimo.",
                "Ignorar, pois bancos nunca pedem informações pessoais por e-mail."
            ),
            correctAnswerIndex = 1
        ),
        QuizQuestion(
            question = "Qual é a melhor prática ao criar uma senha forte?",
            options = listOf(
                "Usar apenas letras minúsculas e números.",
                "Usar uma combinação de letras maiúsculas, minúsculas, números e caracteres especiais.",
                "Usar uma palavra fácil de lembrar, como seu nome ou data de nascimento.",
                "Reutilizar a mesma senha em todos os sites para não esquecer."
            ),
            correctAnswerIndex = 1
        ),
        QuizQuestion(
            question = "Qual dessas opções é uma característica comum de uma tentativa de phishing?",
            options = listOf(
                "Uma mensagem curta e direta sem links.",
                "Uma mensagem enviada por um amigo ou parente.",
                "Uma mensagem com erros gramaticais e links que parecem suspeitos.",
                "Uma mensagem que não inclui seu nome."
            ),
            correctAnswerIndex = 2
        ),
        QuizQuestion(
            question = "Como você pode verificar se um e-mail que informa uma promoção é real?",
            options = listOf(
                "Acessar o link diretamente pelo e-mail.",
                "Confiar se o e-mail parecer visualmente profissional.",
                "Encaminhar o e-mail para um amigo para confirmação.",
                "Pesquisar sobre a promoção no site oficial da empresa."
            ),
            correctAnswerIndex = 3
        ),
        QuizQuestion(
            question = "Quando você recebe uma mensagem em um aplicativo de mensagens dizendo que ganhou um prêmio e precisa clicar em um link, o que fazer?",
            options = listOf(
                "Clicar no link para ver do que se trata.",
                "Ignorar e apagar a mensagem, pois pode ser um golpe.",
                "Responder à mensagem perguntando quem a enviou.",
                "Compartilhar com amigos para verificar se é verdade."
            ),
            correctAnswerIndex = 1
        ),
        QuizQuestion(
            question = "Como identificar uma notícia falsa circulando nas redes sociais?",
            options = listOf(
                "Compartilhar imediatamente se ela confirmar sua opinião.",
                "Ignorar a notícia e continuar a navegar.",
                "Acreditar se um amigo próximo compartilhou.",
                "Verificar a fonte e procurar a notícia em sites de confiança."
            ),
            correctAnswerIndex = 3
        ),
        //Adicionar aqui mais perguntas
    )
}