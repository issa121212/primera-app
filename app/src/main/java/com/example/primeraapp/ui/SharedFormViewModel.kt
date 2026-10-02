package com.example.primeraapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class FormUiState(
    val nombre: String = "",
    val edad: String = "",
    val mensajeGuardado: String = ""
)

class SharedFormViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(FormUiState())
    val uiState: StateFlow<FormUiState> = _uiState.asStateFlow()

    fun onNombreChanged(valor: String) {
        _uiState.update { it.copy(nombre = valor) }
    }

    fun onEdadChanged(valor: String) {
        _uiState.update { it.copy(edad = valor) }
    }

    fun saveData() {
        _uiState.update { it.copy(mensajeGuardado = "Datos guardados correctamente ✅") }
    }
}

