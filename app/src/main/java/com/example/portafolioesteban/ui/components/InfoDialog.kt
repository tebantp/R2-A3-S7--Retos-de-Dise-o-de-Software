package com.example.portafolioesteban.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portafolioesteban.model.InfoDialogData

val CrimsonRed = Color(0xFF990000)

@Composable
fun InfoDialog(
    info: InfoDialogData,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("CERRAR", color = CrimsonRed, fontWeight = FontWeight.Bold)
            }
        },
        title = {
            Text(
                text = info.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = CrimsonRed
            )
        },
        text = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    Text(
                        text = info.content,
                        fontSize = 16.sp,
                        color = Color.DarkGray,
                        lineHeight = 22.sp
                    )
                }
            }
        },
        shape = RoundedCornerShape(16.dp),
        containerColor = Color.White
    )
}
