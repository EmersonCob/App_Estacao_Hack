package com.jebcosta.appestacao_hack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jebcosta.appestacao_hack.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Quando o botão for clicado, faça
        binding.btnLoginEntrar.setOnClickListener{
            // Aqui os dados digitados são capturados e salvos em variáveis imutáveis
            val email = binding.editLoginEmail.text.toString().trim().lowercase()
            val senha = binding.editLoginSenha.text.toString().trim()

            // Aqui é feita a validação dos campos
            if(email.isEmpty()){
                binding.editLoginEmail.error = "Campo Obrigatório"
                binding.editLoginEmail.requestFocus()
            } else if(senha.isEmpty()){
                binding.editLoginSenha.error = "Campo Obrigatório"
                binding.editLoginSenha.requestFocus()
            } else {
                // Aqui será validado se o e-mail e senha batem
                if(email == "teste@teste.com" && senha == "123456"){
                    // Se tudo estiver certo uma mensagem de sucesso será exibida
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()

                    // Em seguinda, a MainActivity será aberta
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)

                    // Então eliminamos essa activity da pilha.
                    finish()
                } else {
                    // se o E-mail e senha não baterem, então uma mensagem de erro será exibida
                    Toast.makeText(this, "E-mail ou senha inválidos", Toast.LENGTH_LONG).show()
                }
            }

        }
        // Quando o botão cadastrar for clicado, faça
        binding.btnLoginCadastrar.setOnClickListener {
            // A Cadastro Activity deve ser aberta
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)

        }

    }
}