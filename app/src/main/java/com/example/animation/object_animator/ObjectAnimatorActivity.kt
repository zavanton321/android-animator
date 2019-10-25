package com.example.animation.object_animator

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.R
import kotlinx.android.synthetic.main.activity_object_animator.*

class ObjectAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        ivCat.setOnClickListener {
            // animateCatProgrammatically()
            animateCatFromResource()
        }
    }

    private fun animateCatProgrammatically() {
        val animationX = ObjectAnimator.ofFloat(ivCat, "scaleX", 3F)
        val animationY = ObjectAnimator.ofFloat(ivCat, "scaleY", 3F)

        val animatorSet = AnimatorSet()
        animatorSet.play(animationX).with(animationY)
        animatorSet.duration = 500
        animatorSet.interpolator = DecelerateInterpolator()
        animatorSet.start()
    }

    private fun animateCatFromResource() {
        val set = AnimatorInflater.loadAnimator(this, R.animator.cat_animator) as AnimatorSet
        set.setTarget(ivCat)
        set.start()
    }
}