package com.aplicaciones_android.ae3___abp1___grupo_1.model

// Modelo de datos para una tarea

data class Tarea(
    val id: Long,
    val descripcion: String,
    val completada: Boolean = false
)
