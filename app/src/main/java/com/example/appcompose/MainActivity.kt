package com.example.appcompose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.graphics.Color
import com.example.appcompose.ui.theme.AppComposeTheme
import com.example.appcompose.ui.theme.shapeScheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Exibe uma lista de elementos
            AppComposeTheme {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    repeat(20) {
                        Surface() {
                            MessageCard(Message("Pascal", "Baskas"))
                        }

                    }
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
                // Borda da imagem
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        // Espaçamento
        Spacer(modifier = Modifier.width(16.dp))
        //View em coluna
        Column {
            Text(msg.author, color = MaterialTheme.colorScheme.secondary)

            Spacer(modifier = Modifier.width(8.dp))
            Surface(shape = MaterialTheme.shapeScheme.large, shadowElevation = 1.dp) {
                Text(msg.body, style = MaterialTheme.typography.bodyMedium)
            }

        }
    }
}
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    AppComposeTheme() {
        Surface {
            MessageCard(
                msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!")
            )
        }
    }
}
  