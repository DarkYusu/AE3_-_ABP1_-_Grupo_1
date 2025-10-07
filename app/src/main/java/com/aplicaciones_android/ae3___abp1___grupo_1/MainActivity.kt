package com.aplicaciones_android.ae3___abp1___grupo_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.aplicaciones_android.ae3___abp1___grupo_1.ui.TareasPendientesFragment
import com.aplicaciones_android.ae3___abp1___grupo_1.ui.TareasCompletadasFragment
import com.aplicaciones_android.ae3___abp1___grupo_1.viewmodel.TareaViewModel

class MainActivity : AppCompatActivity() {
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

        // Agregar tarea
        val editTextTarea = findViewById<EditText>(R.id.editTextTarea)
        val buttonAgregar = findViewById<Button>(R.id.buttonAgregarTarea)
        buttonAgregar.setOnClickListener {
            val texto = editTextTarea.text.toString().trim()
            if (texto.isNotEmpty()) {
                tareaViewModel.agregarTarea(texto)
                editTextTarea.text.clear()
            }
        }

        // Navegación entre fragments
        val bottomNav = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_pendientes -> {
                    showFragment(TareasPendientesFragment())
                    true
                }
                R.id.nav_completadas -> {
                    showFragment(TareasCompletadasFragment())
                    true
                }
                else -> false
            }
        }
        // Mostrar por defecto las tareas pendientes
        bottomNav.selectedItemId = R.id.nav_pendientes
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}