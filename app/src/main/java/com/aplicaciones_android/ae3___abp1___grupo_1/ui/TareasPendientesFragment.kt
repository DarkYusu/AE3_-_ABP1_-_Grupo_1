package com.aplicaciones_android.ae3___abp1___grupo_1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.aplicaciones_android.ae3___abp1___grupo_1.R
import com.aplicaciones_android.ae3___abp1___grupo_1.viewmodel.TareaViewModel
import com.aplicaciones_android.ae3___abp1___grupo_1.model.Tarea

class TareasPendientesFragment : Fragment() {
    private lateinit var adapter: TareaAdapter
    private val tareaViewModel: TareaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tareas, container, false)
        val listView = view.findViewById<ListView>(R.id.listTareas)
        adapter = TareaAdapter(mutableListOf(),
            onEliminar = { posicion ->
                val tarea = adapter.getItem(posicion) as Tarea
                val index = tareaViewModel.tareas.value?.indexOf(tarea) ?: -1
                if (index != -1) tareaViewModel.eliminarTarea(index)
            },
            onCompletar = { posicion, completada ->
                val tarea = adapter.getItem(posicion) as Tarea
                val index = tareaViewModel.tareas.value?.indexOf(tarea) ?: -1
                if (index != -1) tareaViewModel.completarTarea(index, completada)
            }
        )
        listView.adapter = adapter
        tareaViewModel.tareas.observe(viewLifecycleOwner) { lista ->
            val pendientes = lista.filter { !it.completada }
            adapter.setTareas(pendientes)
        }
        return view
    }
}
