package com.example.portafolioesteban.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
fun Screen3(
    viewModel: ProfileViewModel,
    onScrollUp: () -> Unit,
    onShowMore: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "https://github.com/tebantp/R2-A3-S7--Retos-de-Dise-o-de-Software/blob/main/Screen3.jpeg?raw=true",
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
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PortfolioButton("DEPORTES") { viewModel.showDialog("DEPORTES", viewModel.profileData.deportes) }
            PortfolioButton("INTERESES") { viewModel.showDialog("INTERESES", viewModel.profileData.intereses) }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(
                onClick = onScrollUp,
                modifier = Modifier.size(56.dp).background(CrimsonRed, CircleShape)
            ) {
                Icon(Icons.Default.KeyboardArrowUp, "Up", tint = Color.White)
            }
            
            Button(
                onClick = onShowMore,
                colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("MOSTRAR DATOS ADICIONALES", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
