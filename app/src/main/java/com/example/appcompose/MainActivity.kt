package com.example.appcompose

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Exibe uma lista de elementos
            Column() {
                repeat(20) {
                    MessageCard(Message("Pascal", "Baskas"))
                }
            }
        }
    }
}
// Criação de um tipo Message
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    // Criação de uma view em linha
    Row(
        modifier= Modifier
            .fillMaxWidth() // Largura pra ocupar 100% da tela
            .height(90.dp)
            .border(0.5.dp, color = Color.LightGray)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    )

    {

        // Imagem
        Image(
            //Imagem a ser mostrada
            painter = painterResource(R.drawable.pascal),
            contentDescription = "Usuário",
            contentScale = ContentScale.Crop,
            // Estilização da imagem
            modifier = Modifier
                // Set image size to 40 dp
                .size(60.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )
        // Espaçamento
        Spacer(modifier = Modifier.width(16.dp))
        //View em coluna
        Column {
            Text(msg.author)

            Spacer(modifier = Modifier.width(8.dp))

            Text(msg.body)
        }
    }
}
