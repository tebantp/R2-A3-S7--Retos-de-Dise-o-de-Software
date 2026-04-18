package com.example.portafolioesteban.viewmodel

import androidx.lifecycle.ViewModel
import com.example.portafolioesteban.model.InfoDialogData
import com.example.portafolioesteban.model.ProfileData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {

    val profileData = ProfileData(
        perfil = "Tengo 19 años, soy Tecnólogo en Desarrollo de Software y estudiante de Ingeniería de Sistemas. Desarrollador con enfoque práctico y multidisciplinario, con mentalidad emprendedora. Tengo experiencia real en administración operativa (ex-administrador de un lavadero de autos y propietario del restaurante Dinototo). Soy altamente resiliente y capaz de gestionar proyectos bajo presión.",
        hobbies = "Me apasionan las artes y la expresión creativa; estudié 3 semestres de actuación en la Academia Charlot. Soy un gran fanático del cine, mi película favorita con la que me identifico profundamente es 'Whiplash'. También disfruto el aprendizaje continuo en tecnologías emergentes.",
        pasatiempos = "Me apasionan las artes y la expresión creativa; estudié 3 semestres de actuación en la Academia Charlot. Soy un gran fanático del cine, mi película favorita con la que me identifico profundamente es 'Whiplash'. También disfruto el aprendizaje continuo en tecnologías emergentes.",
        deportes = "Me encanta el fútbol. Soy un Culé de corazón, fiel hincha del FC Barcelona.",
        intereses = "Desarrollo Backend y bases de datos. Especial interés en la mecánica interna de Java (JVM, bytecode), Kotlin, Flutter, y optimización de consultas SQL (B-Trees). Actualmente estudiando ciberseguridad ofensiva en TryHackMe, además de tener bases en Python y WordPress.",
        extras = "Cuento con un nivel de inglés A2 certificado y estoy en constante preparación para expandir mis habilidades de comunicación técnica."
    )

    private val _activeDialog = MutableStateFlow<InfoDialogData?>(null)
    val activeDialog: StateFlow<InfoDialogData?> = _activeDialog.asStateFlow()

    fun showDialog(title: String, content: String) {
        _activeDialog.value = InfoDialogData(title, content)
    }

    fun dismissDialog() {
        _activeDialog.value = null
    }
}
