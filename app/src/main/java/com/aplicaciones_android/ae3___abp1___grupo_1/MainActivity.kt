package com.aplicaciones_android.ae3___abp1___grupo_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.aplicaciones_android.ae3___abp1___grupo_1.ui.TareaAdapter
import com.aplicaciones_android.ae3___abp1___grupo_1.viewmodel.TareaViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: TareaAdapter
    private val tareaViewModel: TareaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = TareaAdapter(mutableListOf(),
            onEliminar = { posicion ->
                tareaViewModel.eliminarTarea(posicion)
            },
            onCompletar = { posicion, completada ->
                tareaViewModel.completarTarea(posicion, completada)
            }
        )

        val listView = findViewById<ListView>(R.id.listViewTareas)
        listView.adapter = adapter

        // Observa los cambios en la lista de tareas y actualiza el adaptador
        tareaViewModel.tareas.observe(this, Observer { lista ->
            adapter.setTareas(lista)
        })

        val editTextTarea = findViewById<EditText>(R.id.editTextTarea)
        val buttonAgregar = findViewById<Button>(R.id.buttonAgregarTarea)
        buttonAgregar.setOnClickListener {
            val texto = editTextTarea.text.toString().trim()
            if (texto.isNotEmpty()) {
                tareaViewModel.agregarTarea(texto)
                editTextTarea.text.clear()
            }
        }

    }
}