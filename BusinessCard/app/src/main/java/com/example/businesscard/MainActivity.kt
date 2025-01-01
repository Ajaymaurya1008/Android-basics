package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFDAE5DB)
                ) {
                    BuinessCard()
                }
            }
        }
    }
}


@Composable
fun BuinessCard() {
    Box(Modifier.safeDrawingPadding()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PersonalDetails(
                imageSrc = painterResource(R.drawable.android_logo),
                name = "Ajay Maurya",
                designation = "Mobile Developer"
            )
            ContactDetails()

        }
    }
}

@Composable
fun PersonalDetails(
    imageSrc: Painter,
    name: String,
    designation: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imageSrc,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.W300,
            fontSize = 60.sp,
        )
        Text(
            text = designation,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun ContactDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 300.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactStrip(
            icon = Icons.Filled.Call,
            contact = "+91 9838905327"
        )
        ContactStrip(
            icon = Icons.Filled.Share,
            contact = "@Ajaymaurya1008"
        )
        ContactStrip(
            icon = Icons.Filled.Email,
            contact = "ajaykvmaurya@gmail.com"
        )
    }

}

@Composable
fun ContactStrip(icon: ImageVector, contact: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Text(text = contact)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BuinessCard()
    }
}