package com.example.portafolioesteban.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
fun Screen2(
    viewModel: ProfileViewModel,
    onScrollUp: () -> Unit,
    onScrollDown: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "https://github.com/tebantp/R2-A3-S7--Retos-de-Dise-o-de-Software/blob/main/Screen2.jpeg?raw=true",
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

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.End
        ) {
            PortfolioButton("PERFIL") { viewModel.showDialog("PERFIL", viewModel.profileData.perfil) }
            PortfolioButton("HOBBIES") { viewModel.showDialog("HOBBIES", viewModel.profileData.hobbies) }
            PortfolioButton("PASATIEMPOS") { viewModel.showDialog("PASATIEMPOS", viewModel.profileData.pasatiempos) }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            IconButton(
                onClick = onScrollUp,
                modifier = Modifier.size(56.dp).background(CrimsonRed, CircleShape)
            ) {
                Icon(Icons.Default.KeyboardArrowUp, "Up", tint = Color.White)
            }
            IconButton(
                onClick = onScrollDown,
                modifier = Modifier.size(56.dp).background(CrimsonRed, CircleShape)
            ) {
                Icon(Icons.Default.KeyboardArrowDown, "Down", tint = Color.White)
            }
        }
    }
}

@Composable
fun PortfolioButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.width(160.dp)
    ) {
        Text(text, color = Color.White, fontWeight = FontWeight.Bold)
    }
}
