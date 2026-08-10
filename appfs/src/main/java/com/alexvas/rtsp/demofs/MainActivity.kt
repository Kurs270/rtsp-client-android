package com.alexvas.rtsp.demofs

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import android.net.Uri
import android.view.View
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowCompat
import com.alexvas.rtsp.widget.RtspSurfaceView

val url = "rtsp://192.168.78.95"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
//        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        // Configure the behavior of the hidden system bars.
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

        val svVideo: RtspSurfaceView = findViewById(R.id.svVideo)
//        val uri = Uri.parse("rtsp://192.168.78.95:1935")
        val uri = Uri.parse( url )
        val username = "admin"
        val password = "secret"
        svVideo.init(uri, username, password)
        svVideo.start(
            requestVideo = true,
            requestAudio = false,
            requestApplication = false)
     }

    override fun onPause()
    {
        val svVideo: RtspSurfaceView = findViewById(R.id.svVideo)
        svVideo.stop()
        super.onPause()
    }

    override fun onResume()
    {
        super.onResume()
        val svVideo: RtspSurfaceView = findViewById(R.id.svVideo)
        val uri = Uri.parse( url )
        val username = "admin"
        val password = "secret"
        svVideo.init(uri, username, password)
        svVideo.start(
            requestVideo = true,
            requestAudio = false,
            requestApplication = false)

    }
}
