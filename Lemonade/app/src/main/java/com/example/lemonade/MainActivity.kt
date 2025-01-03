package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    Header()
    Content()
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFFEBE195))
            .fillMaxWidth()
            .height(110.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Lemonade",
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 50.dp)
        )
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) }
    var step by remember { mutableStateOf("lemon_tree") }
    var randomNumber by remember { mutableStateOf((2..4).random()) }

    fun updateCount() {
        if (step === "lemon_squeeze" && count == randomNumber) {
            step = "lemon_drink"
            count = 0
            randomNumber = (2..4).random()
        } else if (step === "lemon_drink") {
            step = "lemon_restart"
        } else if (step === "lemon_restart") {
            step = "lemon_tree"
        } else if (step === "lemon_tree") {
            step = "lemon_squeeze"
        } else {
            count++
        }
    }

    val imageResource = when (step) {
        "lemon_tree" -> R.drawable.lemon_tree
        "lemon_squeeze" -> R.drawable.lemon_squeeze
        "lemon_drink" -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val description = when (step) {
        "lemon_tree" -> stringResource(R.string.lemon_tree)
        "lemon_squeeze" -> stringResource(R.string.lemon_squeeze)
        "lemon_drink" -> stringResource(R.string.lemon_drink)
        else -> stringResource(R.string.lemon_restart)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { updateCount() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD2E7DA)
            ),
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(40.dp, 15.dp)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = description,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = description,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}