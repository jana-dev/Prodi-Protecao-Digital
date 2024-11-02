package com.janatavares.prodi.data.repository

import com.janatavares.prodi.R
import com.janatavares.prodi.data.model.NewsItem

object NewsRepository {
    val newsList = listOf(
        NewsItem(
            title = "Phishing",
            description = "Conheça o tipo de ataque mais comum e aprenda como se proteger.",
            imageResId = R.drawable.imgpishing,
            fullText = "O phishing é uma das formas mais comuns de ataque cibernético. Nele, o atacante se passa por uma instituição confiável, como bancos ou redes sociais, enviando e-mails, mensagens de texto ou links falsos. A intenção é enganar o usuário para que ele forneça dados sensíveis, como senhas ou informações bancárias. Como se proteger: Desconfie de links suspeitos e mensagens que pedem informações pessoais. Verifique o endereço de e-mail do remetente e evite clicar em links de origem desconhecida. Habilite a autenticação de dois fatores (2FA) sempre que possível."
        ),
        NewsItem(
            title = "Malware",
            description = "Malware é um termo que engloba qualquer software malicioso projetado para causar dano.",
            imageResId = R.drawable.imgmalware,
            fullText = "Malware é um termo que engloba qualquer software malicioso projetado para causar dano. Pode incluir vírus, trojans, spyware e ransomware. Ele geralmente é instalado no dispositivo sem o conhecimento do usuário, muitas vezes através de downloads inseguros, e pode comprometer o sistema, roubar informações ou exigir pagamento para \"liberar\" os dados. Como se proteger: Instale um antivírus confiável e mantenha-o atualizado.\n Evite baixar arquivos e programas de sites desconhecidos. Mantenha o sistema operacional e os softwares sempre atualizados. "
        ),
        NewsItem(
            title = "Ataque de Engenharia Social",
            description = "Fique atento: técnicas psicológicas para manipular o usuário.",
            imageResId = R.drawable.imgataqueengenhariasocial,
            fullText = "Nesse tipo de ataque, o invasor utiliza técnicas psicológicas para manipular o usuário e obter informações confidenciais. Em muitos casos, o atacante se faz passar por um colega ou por uma figura de autoridade para conseguir o que quer. Como se proteger: Nunca forneça informações confidenciais sem verificar a identidade da pessoa. Sempre confirme com a empresa ou a pessoa por meios oficiais antes de enviar qualquer dado. Esteja atento a solicitações incomuns ou urgentes."
        ),
        NewsItem(
            title = "Ataque Man-in-the-Middle (MitM)",
            description = "Ataque mais comum em redes Wi-Fi públicas",
            imageResId = R.drawable.imgataquemid,
            fullText = "Em um ataque Man-in-the-Middle, o atacante intercepta a comunicação entre duas partes para capturar informações sensíveis. Esse tipo de ataque é mais comum em redes Wi-Fi públicas ou inseguras, onde o invasor pode monitorar o tráfego de dados. Como se proteger: Evite acessar informações confidenciais ou fazer transações bancárias em redes públicas. Utilize redes privadas virtuais (VPNs) para proteger suas conexões. Desative o Wi-Fi e o Bluetooth quando não estiverem em uso."
        ),
        NewsItem(
            title = "Ataque de Força Bruta",
            description = "O invasor tenta adivinhar a senha",
            imageResId = R.drawable.ataqueimgsenha,
            fullText = "Em um ataque de força bruta, o invasor tenta adivinhar a senha de uma conta testando várias combinações. Embora seja uma técnica mais antiga, ela ainda é eficaz quando as senhas são fracas ou previsíveis. Como se proteger: Utilize senhas longas e complexas, misturando letras, números e símbolos. Habilite a autenticação de dois fatores (2FA). Evite reutilizar senhas em diferentes contas."
        ),
        NewsItem(
            title = "Ransomware",
            description = "Os criminosos exigem um pagamento.",
            imageResId = R.drawable.imgransonware,
            fullText = "No ataque de ransomware, os criminosos cibernéticos sequestram os dados da vítima e exigem um pagamento para \"liberar\" o acesso. Esse tipo de ataque pode ocorrer ao baixar arquivos infectados ou clicar em links maliciosos. Como se proteger: Faça backups regulares de seus dados importantes. Evite clicar em links e baixar arquivos suspeitos. Mantenha seu sistema e antivírus sempre atualizados."
        )
    )
}