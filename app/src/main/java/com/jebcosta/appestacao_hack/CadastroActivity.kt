package com.jebcosta.appestacao_hack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
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
            val continente = binding.spnCadastroContinente.selectedItem.toString()

            if(nome.isEmpty() || sobrenome.isEmpty() ||
                email.isEmpty() || senha.isEmpty() || continente == listaContinentes[0]){
                Toast.makeText(this, "Preencha todos os campos",
                    Toast.LENGTH_LONG).show()
            } else {
                // Aqui estamos criando um arquivo de preferências compartilhadas
                val sharedPrefs = getSharedPreferences("Cadastro_$email",
                    Context.MODE_PRIVATE)

                // Vamos tornar nosso arquivo digitavel
                val editPrefs = sharedPrefs.edit()

                // Os dados são salvos no formato chave -> valor
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("CONTINENTE", continente)

                // Aqui os dados são salvos no arquivo
                editPrefs.apply()

                Toast.makeText(this, "Cadastro Realizado", Toast.LENGTH_LONG).show()

            }
        }
    }
}