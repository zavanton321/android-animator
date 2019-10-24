package com.example.animation.value_animator

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_value_animator.*

class ValueAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

        tvContent.setOnClickListener {
            // animateWithValueAnimator()
            animateWithObjectAnimator()
        }
    }

    private fun animateWithValueAnimator() {
        val valueAnimator = ValueAnimator.ofFloat(1F, 0F)
        valueAnimator.duration = 1000
        valueAnimator.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {

            override fun onAnimationUpdate(animation: ValueAnimator) {
                tvContent.alpha = animation.animatedValue as Float
            }
        })
        valueAnimator.start()
    }

    private fun animateWithObjectAnimator() {
        val objectAnimator = ObjectAnimator.ofFloat(tvContent, "alpha", 1F, 0F)
        objectAnimator.duration = 1000
        objectAnimator.start()
    }
}
