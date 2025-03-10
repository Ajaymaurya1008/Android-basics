package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantApp() {
    Box(Modifier.safeDrawingPadding()) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ){
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Quadrant(
                    title = stringResource(R.string.q1_title),
                    description = stringResource(R.string.q1_description),
                    color = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f)
                )
                Quadrant(
                    title = stringResource(R.string.q2_title),
                    description = stringResource(R.string.q2_description),
                    color = Color(0xFFD0BCFF),
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Quadrant(
                    title = stringResource(R.string.q3_title),
                    description = stringResource(R.string.q3_description),
                    color = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f)
                )
                Quadrant(
                    title = stringResource(R.string.q4_title),
                    description = stringResource(R.string.q4_description),
                    color = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


@Composable
fun Quadrant(title: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color)
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        QuadrantApp()
    }
}