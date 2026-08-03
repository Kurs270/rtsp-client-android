package com.alexvas.rtsp.demofs

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import android.net.Uri
import android.view.View
import com.alexvas.rtsp.widget.RtspSurfaceView

class MainActivity : AppCompatActivity() {

    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val svVideo: RtspSurfaceView = findViewById(R.id.svVideo)
        val uri = Uri.parse("rtsp://192.168.78.146:1935")
        val username = "admin"
        val password = "secret"
        svVideo.init(uri, username, password)
        svVideo.start(
            requestVideo = true,
            requestAudio = true,
            requestApplication = false)

        


        //showSystemUI()
 
        //val navView: BottomNavigationView = findViewById(R.id.nav_view)

        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_live, R.id.navigation_logs))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }
}
