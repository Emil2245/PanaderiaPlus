package com.app.panaderiaplus.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.app.panaderiaplus.R

class MainActivity : AppCompatActivity() {

    private val splashScreenDuration: Long = 3000 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val splashScreen = findViewById<View>(R.id.splash_screen)
        splashScreen.visibility = View.VISIBLE

        val logoImageView = findViewById<ImageView>(R.id.logo)

        val animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
              
                logoImageView.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {
               
            }

            override fun onAnimationRepeat(animation: Animation?) {
                
            }
        })
     
        logoImageView.startAnimation(animation)

        Handler(Looper.getMainLooper()).postDelayed({
            splashScreen.visibility = View.GONE
           
            findViewById<View>(R.id.main_content).visibility = View.VISIBLE
        }, splashScreenDuration)
    }
}
