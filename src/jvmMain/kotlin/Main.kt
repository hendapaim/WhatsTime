// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.concurrent.timer

@Composable
fun App() {
    var text by remember { mutableStateOf(horaActual()) }

    // Actualizador do relogio
    timer(initialDelay = 1000L, period = 1000L) {
        text = horaActual()
    }

    // UI - MainView
    ClockScreen(text)
}

@Composable
fun ClockScreen(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1,
                fontSize = 12.em,
                color = Color.White
            )
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "WhatsTime") {
        App()
    }
}
