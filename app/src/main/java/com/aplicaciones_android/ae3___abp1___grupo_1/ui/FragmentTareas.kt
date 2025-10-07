package com.aplicaciones_android.ae3___abp1___grupo_1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.aplicaciones_android.ae3___abp1___grupo_1.viewmodel.TareaViewModel
import com.aplicaciones_android.ae3___abp1___grupo_1.R

class FragmentTareas : Fragment() {
    private val viewModel: TareaViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tareas, container, false)
    }

}
