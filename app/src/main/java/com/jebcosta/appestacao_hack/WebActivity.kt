package com.jebcosta.appestacao_hack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.jebcosta.appestacao_hack.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Habilitar a execução de código javascript

        binding.wbvWeb.settings.javaScriptEnabled = true


        // Definir a página Inicial
        binding.wbvWeb.loadUrl("https://br.cellep.com/estacaohack")

        // definir o WebView como client Web Padrão
        binding.wbvWeb.webViewClient = WebViewClient()
    }
}