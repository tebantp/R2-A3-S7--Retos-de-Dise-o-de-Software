package com.example.portafolioesteban.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.portafolioesteban.ui.components.CrimsonRed
import com.example.portafolioesteban.viewmodel.ProfileViewModel

@Composable
fun Screen4(
    viewModel: ProfileViewModel,
    onBack: () -> Unit,
    onGoToStart: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "https://github.com/tebantp/R2-A3-S7--Retos-de-Dise-o-de-Software/blob/main/Screen4.jpeg?raw=true",
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        Text(
            text = "PORTAFOLIO",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 64.dp)
        )

        PortfolioButton(
            text = "EXTRAS SOBRE MI",
            modifier = Modifier.align(Alignment.Center)
        ) { 
            viewModel.showDialog("EXTRAS SOBRE MI", viewModel.profileData.extras) 
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier.size(56.dp).background(CrimsonRed, CircleShape)
            ) {
                Icon(Icons.Default.KeyboardArrowLeft, "Back", tint = Color.White)
            }
            
            Button(
                onClick = onGoToStart,
                colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("VOLVER AL INICIO", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun PortfolioButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier.width(200.dp)
    ) {
        Text(text, color = Color.White, fontWeight = FontWeight.Bold)
    }
}
