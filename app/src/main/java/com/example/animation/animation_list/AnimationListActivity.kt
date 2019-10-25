package com.example.animation.animation_list

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_animation_list.*

class AnimationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_list)

        ivAnimation.setOnClickListener {
            animateTheCat()
        }
    }

    private fun animateTheCat() {
        ivAnimation.setImageDrawable(null)
        ivAnimation.setBackgroundResource(R.drawable.custom_animation)
        val animationDrawable = ivAnimation.background as AnimationDrawable
        animationDrawable.start()
    }
}
