package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                ArtGalleryApp()
            }
        }
    }
}

data class Painting(
    val name: String,
    val painter: String,
    val imageUrl: String
)

val paintings = listOf(
    Painting(
        name = "Mona Lisa",
        painter = "Leonardo da Vinci",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/6a/Mona_Lisa.jpg"
    ),
    Painting(
        name = "The Starry Night",
        painter = "Vincent van Gogh",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/e/eb/The_Starry_Night.jpg"
    ),
    Painting(
        name = "The Persistence of Memory",
        painter = "Salvador Dalí",
        imageUrl = "https://upload.wikimedia.org/wikipedia/en/d/dd/The_Persistence_of_Memory.jpg"
    ),
    Painting(
        name = "Girl with a Pearl Earring",
        painter = "Johannes Vermeer",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Meisje_met_de_parel.jpg"
    ),
    Painting(
        name = "The Last Supper",
        painter = "Leonardo da Vinci",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/4/4b/Leonardo_da_Vinci_-_The_Last_Supper_high_res.jpg"
    ),
    Painting(
        name = "The Scream",
        painter = "Edvard Munch",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/f/f4/The_Scream.jpg"
    ),
    Painting(
        name = "Guernica",
        painter = "Pablo Picasso",
        imageUrl = "https://upload.wikimedia.org/wikipedia/en/7/74/PicassoGuernica.jpg"
    ),
    Painting(
        name = "The Birth of Venus",
        painter = "Sandro Botticelli",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/5/5e/Sandro_Botticelli_-_La_nascita_di_Venere_-_Google_Art_Project_-_edited.jpg"
    ),
    Painting(
        name = "American Gothic",
        painter = "Grant Wood",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a3/Grant_Wood_-_American_Gothic_-_Google_Art_Project.jpg"
    ),
    Painting(
        name = "The Night Watch",
        painter = "Rembrandt van Rijn",
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/1f/The_Nightwatch_by_Rembrandt.jpg"
    )
)

@Composable
fun ArtGalleryApp() {

    var num by remember { mutableStateOf(0) }

    var obj by remember { mutableStateOf(paintings[num]) }

    val increment = {
        if (num < paintings.size - 1) {
            num++
            obj = paintings[num]
        }
    }
    val decrement = {
        if (num > 0) {
            num--
            obj = paintings[num]
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFAFC))
            .wrapContentSize(Alignment.Center)
            .padding(50.dp)

    ) {
        ArtImage(
            imageUrl = obj.imageUrl
        )
        ArtDetails(
            painting = obj.name,
            artist = obj.painter
        )
        NavigationButtons(
            increment = increment,
            decrement = decrement
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArtImage(imageUrl: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White)
            .padding(50.dp)
            .shadow(12.dp, RectangleShape)
    ) {
        GlideImage(
            model = imageUrl,
            contentDescription = null,
        )
    }
}

@Composable
fun ArtDetails(painting: String, artist: String) {
    Column(
        modifier = Modifier
            .background(Color(0xFFECEBF0))
            .padding(50.dp)
    ) {
        Text(
            text = painting
        )
        Text(
            text = artist
        )
    }

}

@Composable
fun NavigationButtons(increment: () -> Unit, decrement: () -> Unit) {
    Row() {
        Button(onClick = { increment() }) {
            Text("Previous")
        }
        Button(onClick = { decrement() }) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        ArtGalleryApp()
    }
}