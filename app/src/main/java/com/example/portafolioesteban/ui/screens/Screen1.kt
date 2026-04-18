package com.example.portafolioesteban.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.portafolioesteban.ui.components.CrimsonRed
import com.example.portafolioesteban.viewmodel.ProfileViewModel

@Composable
fun Screen1(
    viewModel: ProfileViewModel,
    onScrollDown: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo con imagen difuminada (URL)
        AsyncImage(
            model = "https://github.com/tebantp/R2-A3-S7--Retos-de-Dise-o-de-Software/blob/main/Screen1.jpeg?raw=true",
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.6f
        )

        // Degradado para legibilidad
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))
                    )
                )
        )

        // Nombre elegante a la izquierda
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 32.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            listOf("Brayan", "Esteban", "Pinzon", "Torres").forEach { namePart ->
                Text(
                    text = namePart,
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic,
                    lineHeight = 48.sp
                )
            }
        }

        // Botón redondo con flecha hacia abajo
        IconButton(
            onClick = onScrollDown,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp)
                .size(64.dp)
                .background(CrimsonRed, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Down",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}
