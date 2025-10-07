package com.aplicaciones_android.ae3___abp1___grupo_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aplicaciones_android.ae3___abp1___grupo_1.model.Tarea

class TareaViewModel : ViewModel() {
    private val _tareas = MutableLiveData<MutableList<Tarea>>(mutableListOf())
    val tareas: LiveData<MutableList<Tarea>> = _tareas
    private var idActual: Long = 0L

    fun agregarTarea(descripcion: String) {
        val nuevaTarea = Tarea(id = idActual++, descripcion = descripcion)
        val listaActual = _tareas.value ?: mutableListOf()
        listaActual.add(nuevaTarea)
        _tareas.value = listaActual
    }

    fun eliminarTarea(posicion: Int) {
        val listaActual = _tareas.value ?: return
        if (posicion in listaActual.indices) {
            listaActual.removeAt(posicion)
            _tareas.value = listaActual
        }
    }

    fun completarTarea(posicion: Int, completada: Boolean) {
        val listaActual = _tareas.value ?: return
        if (posicion in listaActual.indices) {
            val tarea = listaActual[posicion]
            listaActual[posicion] = tarea.copy(completada = completada)
            _tareas.value = listaActual
        }
    }
}

