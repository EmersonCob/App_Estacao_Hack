package com.jebcosta.appestacao_hack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.jebcosta.appestacao_hack.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Criando a lista de opções para o Spinner
        val listaContinentes = arrayListOf("Continente", "Africa", "Antártida", "America",
            "Ásia", "Europa", "Oceania")

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item, // Layout
            listaContinentes        // Dados
        )
        // Plugando o adaptador no Spinner da Activity
        binding.spnCadastroContinente.adapter = spinnerAdapter

        // Quando o botão for clicado faça
        binding.btnCadastroCadastrar.setOnClickListener {
        // Recuperar os dados digitados e atribuir as variáveis imutáveis

            val nome = binding.edtCadastroNome.text.toString().trim()
            val sobrenome = binding.edtCadastroSobrenome.text.toString().trim()
            val email = binding.edtCadastroEmail.text.toString().trim().lowercase()
            val senha = binding.edtCadastroSenha.text.toString().trim()
            val continente = binding.spnCadastroContinente

        }
    }
}