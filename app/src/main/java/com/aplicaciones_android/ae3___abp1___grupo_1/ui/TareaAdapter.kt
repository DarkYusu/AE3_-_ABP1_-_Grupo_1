package com.aplicaciones_android.ae3___abp1___grupo_1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import com.aplicaciones_android.ae3___abp1___grupo_1.R
import com.aplicaciones_android.ae3___abp1___grupo_1.model.Tarea

class TareaAdapter(private val tareas: MutableList<Tarea>, private val onEliminar: (Int) -> Unit, private val onCompletar: (Int, Boolean) -> Unit) : BaseAdapter() {
    override fun getCount() = tareas.size
    override fun getItem(position: Int) = tareas[position]
    override fun getItemId(position: Int) = tareas[position].id
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_tarea, parent, false)
        val tarea = tareas[position]
        val tvDescripcion = view.findViewById<TextView>(R.id.tvDescripcion)
        val cbCompletada = view.findViewById<CheckBox>(R.id.cbCompletada)
        val btnEliminar = view.findViewById<ImageButton>(R.id.btnEliminar)

        tvDescripcion.text = tarea.descripcion
        cbCompletada.setOnCheckedChangeListener(null)
        cbCompletada.isChecked = tarea.completada
        cbCompletada.setOnCheckedChangeListener { _, isChecked ->
            onCompletar(position, isChecked)
        }
        btnEliminar.setOnClickListener {
            val context = view.context
            android.app.AlertDialog.Builder(context)
                .setTitle("Confirmar eliminación")
                .setMessage("¿Está seguro de eliminar?")
                .setPositiveButton("Sí") { _, _ ->
                    onEliminar(position)
                }
                .setNegativeButton("No", null)
                .show()
        }
        return view
    }

    fun setTareas(nuevasTareas: List<Tarea>) {
        tareas.clear()
        tareas.addAll(nuevasTareas)
        notifyDataSetChanged()
    }
}
