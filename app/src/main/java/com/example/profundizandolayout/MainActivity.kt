package com.example.profundizandolayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.profundizandolayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Estas dos líneas sustituyen a setContentView()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btHecho.setOnClickListener{
            mostrarOpinion(it)
        }
        binding.tvtextOpinion.setOnClickListener {
            volverEditOpinion(it)
        }
    }
    private fun mostrarOpinion(view: View) {
// Obtenemos la opinión
        binding.tvtextOpinion.text = binding.etOpinion.text
// Ocultamos el EditText y el botón
        binding.etOpinion.visibility = View.GONE
        view.visibility = View.GONE
// Mostramos el TextView
        binding.tvtextOpinion.visibility = View.VISIBLE
// Ocultamos el teclado
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    // Función que vuelve a mostrar el TextView de opinión.
    private fun volverEditOpinion(view:View) {
// Hacemos visibles el EditText y el Button
        binding.etOpinion.visibility = View.VISIBLE
        binding.btHecho.visibility = View.VISIBLE
// Hacemos invisible el propio EditText
        view.visibility = View.GONE
// Ponemos el foco sobre el EditText
        binding.etOpinion.requestFocus()
    }





}