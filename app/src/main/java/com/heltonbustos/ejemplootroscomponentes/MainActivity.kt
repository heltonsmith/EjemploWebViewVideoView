package com.heltonbustos.ejemplootroscomponentes

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //webview
        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.loadUrl("https://www.bing.com/")

        val txtBuscador:EditText = findViewById(R.id.txtBuscador)

        val btnBuscar:Button = findViewById(R.id.btnBuscar)
        btnBuscar.setOnClickListener {
            var cadena:String = txtBuscador.text.toString()
            myWebView.loadUrl("https://www.bing.com/search?q=$cadena")
        }
        //webview

        //videoview
        val myVideoView: VideoView = findViewById(R.id.videoView)
        //val ruta:String = "android.resource://" + packageName + "/" + R.raw.video
        val ruta:String = "https://repository.ucatolica.edu.co/bitstream/10983/23782/11/Busqueda-base-bibliografica.mp4"
        val videoUri:Uri = Uri.parse(ruta)
        myVideoView.setVideoURI(videoUri)

        //agregar los controles de video
        val mediaController = MediaController(this)
        myVideoView.setMediaController(mediaController)
        mediaController.setAnchorView(myVideoView)

        myVideoView.setOnPreparedListener {
            myVideoView.start()
        }

        myVideoView.setOnCompletionListener {
            Toast.makeText(this, "Video visto completo!", Toast.LENGTH_SHORT).show()
        }
        //videoview

    }
}