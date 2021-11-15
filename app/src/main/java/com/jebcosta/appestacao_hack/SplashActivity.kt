package com.jebcosta.appestacao_hack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    // É um dos métodos presentes no ciclo de vida da activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Abrir a LoginActivity após 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            // Iniciar uma intent - transição da tela Splash para a tela Login
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        },3000)
    }
}