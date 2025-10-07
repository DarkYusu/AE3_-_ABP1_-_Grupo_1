package com.aplicaciones_android.ae3___abp1___grupo_1.data

import com.aplicaciones_android.ae3___abp1___grupo_1.model.Tarea

// Repositorio para gestionar las tareas
class TareaRepository {
    // Implementación futura: almacenamiento local/remoto
    private val tareas = mutableListOf<Tarea>()

    fun obtenerTareas(): List<Tarea> = tareas
    fun agregarTarea(tarea: Tarea) { tareas.add(tarea) }
    fun eliminarTarea(id: Long) { tareas.removeAll { it.id == id } }
    fun marcarCompletada(id: Long) {
        tareas.replaceAll { if (it.id == id) it.copy(completada = true) else it }
    }
}
