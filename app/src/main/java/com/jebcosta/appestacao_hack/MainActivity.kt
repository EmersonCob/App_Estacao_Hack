package com.jebcosta.appestacao_hack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.jebcosta.appestacao_hack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar o e-mail passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        // Depuração
        //Toast.makeText(this, email, Toast.LENGTH_LONG).show()

        // Acessar arquivo de preferências compartilhadas
        val sharedPresfs = getSharedPreferences(
            "cadastro_$email",
            Context.MODE_PRIVATE
        )

        // Recuperar os dados do arquivo
        // as aspas vazias representa o valor padrão
        val nome= sharedPresfs.getString("NOME", "")
        val sobrenome = sharedPresfs.getString("SOBRENOME", "")
        val continente = sharedPresfs.getString("CONTINENTE", "")

        // Exibir essas informações nas TextView da Activity
        binding.txvMainNome.text = "$nome $sobrenome"
        binding.txvMainEmail.text = email
        binding.txvMainContinente.text = continente

        binding.btnMainSair.setOnClickListener {
            // Criando uma caixa de dialogo
            val alert = AlertDialog.Builder(this)
            // Definir o titulo da caixa de dialogo
            alert.setTitle("Atenção")
            // Definindo o corpo da mensagem
            alert.setMessage("Deseja mesmo sair?")

            alert.setPositiveButton("Sair") { dialog, which ->
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                // Para garantir que todas as telas foram fechadas
                finishAffinity()
            }
            // Definindo o rótulo botão de cancelar
            alert.setNeutralButton("Não") { dialog, which -> }

            // Desabilita a possibilidade do usuário sair da caixa de dialogo sem escolher uma opção
            alert.setCancelable(false)

            // Exibindo a caixa de dialogo
            alert.show()
        }

        // Escuta o click do botão site
        binding.btnMainSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }

    }
}