package com.example.animation.object_animator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_object_animator.*

class ObjectAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        ivCat.setOnClickListener {
            animateCat()
        }
    }

    private fun animateCat() {
        val animationX = ObjectAnimator.ofFloat(ivCat, "scaleX", 3F)
        val animationY = ObjectAnimator.ofFloat(ivCat, "scaleY", 3F)

        val animatorSet = AnimatorSet()
        animatorSet.play(animationX).with(animationY)
        animatorSet.duration = 500
        animatorSet.interpolator = DecelerateInterpolator()
        animatorSet.start()
    }
}
