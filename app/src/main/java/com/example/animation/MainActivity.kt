package com.example.animation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDemo.setOnClickListener {
            // objectAnimatorDemo()
            // animatorSetDemo()
            listenerDemo()
        }
    }

    private fun objectAnimatorDemo() {
        val animator = ObjectAnimator.ofFloat(tvDemo, "alpha", 0F)
        animator.duration = 1000
        animator.start()
    }

    private fun animatorSetDemo() {
        val xAnimator = ObjectAnimator.ofFloat(tvDemo, "translationX", 100F)
        val yAnimator = ObjectAnimator.ofFloat(tvDemo, "translationY", 100F)

        val animatorSet = AnimatorSet()
        animatorSet.duration = 500L
        animatorSet.playSequentially(xAnimator, yAnimator)
        animatorSet.start()
    }

    private fun listenerDemo() {
        val animator = ObjectAnimator.ofFloat(tvDemo, "scaleX", 1.5F)
        animator.addListener(object : Animator.AnimatorListener {

            override fun onAnimationStart(animation: Animator?) {
                Toast.makeText(this@MainActivity, "Started", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                Toast.makeText(this@MainActivity, "Finished", Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }
        })
        animator.duration = 1000
        animator.start()
    }

}
