package com.example.cards.ui_operation

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cards.R
import com.example.cards.databinding.ActivityMainBinding
import com.example.cards.ui_model.ImageData

class UiOperationsManager(private val activity:AppCompatActivity,private val binding: ActivityMainBinding) {

    fun set_mycard_Image(ima:ImageView,number:Int){

        when(number){

            1 ->{

                ima.setImageResource(R.drawable.a)

            }
            2 ->{

                ima.setImageResource(R.drawable.two)

            }
            3->{

                ima.setImageResource(R.drawable.three)

            }
            4->{

                ima.setImageResource(R.drawable.four)

            }
            5->{

                ima.setImageResource(R.drawable.five)

            }
            6->{

                ima.setImageResource(R.drawable.six)

            }
            7->{

                ima.setImageResource(R.drawable.seven)

            }
            8->{

                ima.setImageResource(R.drawable.eight)

            }
            9->{

                ima.setImageResource(R.drawable.nine)

            }
            10->{

                ima.setImageResource(R.drawable.ten)

            }
            11->{

                ima.setImageResource(R.drawable.eleven)

            }
            12->{

                ima.setImageResource(R.drawable.twelve)

            }
            13->{

                ima.setImageResource(R.drawable.thirteen)

            }


        }


    }

    fun toastMessage(message:String){
        Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
    }

    fun setImageIsEnabled(imageName:String , isEnabled:Boolean){

        when(imageName){
             "imageViewOne" ->{
                 binding.imageViewOne.isEnabled = isEnabled
             }
             "imageViewTwo" ->{
                 binding.imageViewTwo.isEnabled = isEnabled
             }
             "imageViewThree" ->{
                 binding.imageViewThree.isEnabled = isEnabled
             }
             "imageViewFour"->{
                 binding.imageViewFour.isEnabled = isEnabled
             }
             "imageViewFive"->{
                 binding.imageViewFive.isEnabled = isEnabled
             }
             "imageViewSix"->{
                 binding.imageViewSix.isEnabled = isEnabled
             }
             "imageViewSeven"->{
                 binding.imageViewSeven.isEnabled = isEnabled
             }
             "imageViewEight"->{
                 binding.imageViewEight.isEnabled = isEnabled
             }
             "imageViewNine"->{
                 binding.imageViewNine.isEnabled = isEnabled
             }
             "imageViewTen"->{
                 binding.imageViewTen.isEnabled = isEnabled
             }
             "imageViewEleven"->{
                 binding.imageViewEleven.isEnabled = isEnabled
             }
             "imageViewTwelve"->{
                 binding.imageViewTwelve.isEnabled = isEnabled
             }
        }

    }
    fun performDisappearAnimation(imageName: String,animationEndListener:AnimationEndListener){

        val my_animation = AnimationUtils.loadAnimation(activity,R.anim.disappear)
        when(imageName){
            "imageViewOne" ->{
                _performAnimation(binding.imageViewOne,animationEndListener,my_animation)
            }
            "imageViewTwo" ->{
                _performAnimation( binding.imageViewTwo,animationEndListener,my_animation)
            }
            "imageViewThree" ->{
                _performAnimation(binding.imageViewThree,animationEndListener,my_animation)
            }
            "imageViewFour"->{
                _performAnimation(binding.imageViewFour,animationEndListener,my_animation)
            }
            "imageViewFive"->{
                _performAnimation( binding.imageViewFive,animationEndListener,my_animation)
            }
            "imageViewSix"->{
                _performAnimation(binding.imageViewSix,animationEndListener,my_animation)
            }
            "imageViewSeven"->{
                _performAnimation(binding.imageViewSeven,animationEndListener,my_animation)
            }
            "imageViewEight"->{
                _performAnimation(binding.imageViewEight,animationEndListener,my_animation)
            }
            "imageViewNine"->{
                _performAnimation(binding.imageViewNine,animationEndListener,my_animation)
            }
            "imageViewTen"->{
                _performAnimation(binding.imageViewTen,animationEndListener,my_animation)
            }
            "imageViewEleven"->{
                _performAnimation(binding.imageViewEleven,animationEndListener,my_animation)
            }
            "imageViewTwelve"->{
                _performAnimation(binding.imageViewTwelve,animationEndListener,my_animation)
            }
        }
    }
    fun performShackAnimation(imageName: String,animationEndListener:AnimationEndListener){

        val my_animation = AnimationUtils.loadAnimation(activity,R.anim.shake)
        when(imageName){
            "imageViewOne" ->{
                _performAnimation(binding.imageViewOne,animationEndListener,my_animation)
            }
            "imageViewTwo" ->{
                _performAnimation( binding.imageViewTwo,animationEndListener,my_animation)
            }
            "imageViewThree" ->{
                _performAnimation(binding.imageViewThree,animationEndListener,my_animation)
            }
            "imageViewFour"->{
                _performAnimation(binding.imageViewFour,animationEndListener,my_animation)
            }
            "imageViewFive"->{
                _performAnimation( binding.imageViewFive,animationEndListener,my_animation)
            }
            "imageViewSix"->{
                _performAnimation(binding.imageViewSix,animationEndListener,my_animation)
            }
            "imageViewSeven"->{
                _performAnimation(binding.imageViewSeven,animationEndListener,my_animation)
            }
            "imageViewEight"->{
                _performAnimation(binding.imageViewEight,animationEndListener,my_animation)
            }
            "imageViewNine"->{
                _performAnimation(binding.imageViewNine,animationEndListener,my_animation)
            }
            "imageViewTen"->{
                _performAnimation(binding.imageViewTen,animationEndListener,my_animation)
            }
            "imageViewEleven"->{
                _performAnimation(binding.imageViewEleven,animationEndListener,my_animation)
            }
            "imageViewTwelve"->{
                _performAnimation(binding.imageViewTwelve,animationEndListener,my_animation)
            }
        }
    }

    fun performBackAnimation(imageName: String,animationEndListener:AnimationEndListener){

        val my_animation =  AnimationUtils.loadAnimation(activity, R.anim.back)
        when(imageName){
            "imageViewOne" ->{
                _performAnimation(binding.imageViewOne,animationEndListener,my_animation)
            }
            "imageViewTwo" ->{
                _performAnimation( binding.imageViewTwo,animationEndListener,my_animation)
            }
            "imageViewThree" ->{
                _performAnimation(binding.imageViewThree,animationEndListener,my_animation)
            }
            "imageViewFour"->{
                _performAnimation(binding.imageViewFour,animationEndListener,my_animation)
            }
            "imageViewFive"->{
                _performAnimation( binding.imageViewFive,animationEndListener,my_animation)
            }
            "imageViewSix"->{
                _performAnimation(binding.imageViewSix,animationEndListener,my_animation)
            }
            "imageViewSeven"->{
                _performAnimation(binding.imageViewSeven,animationEndListener,my_animation)
            }
            "imageViewEight"->{
                _performAnimation(binding.imageViewEight,animationEndListener,my_animation)
            }
            "imageViewNine"->{
                _performAnimation(binding.imageViewNine,animationEndListener,my_animation)
            }
            "imageViewTen"->{
                _performAnimation(binding.imageViewTen,animationEndListener,my_animation)
            }
            "imageViewEleven"->{
                _performAnimation(binding.imageViewEleven,animationEndListener,my_animation)
            }
            "imageViewTwelve"->{
                _performAnimation(binding.imageViewTwelve,animationEndListener,my_animation)
            }
        }
    }

   private fun _performAnimation(imageView:ImageView,animationEndListener:AnimationEndListener,animation: Animation){


       animation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationEnd(animation: Animation?) {
                animationEndListener.onAnimationEnd()

            }

            override fun onAnimationRepeat(animation: Animation?) {



            }

            override fun onAnimationStart(animation: Animation?) {



            }


        })


        imageView.startAnimation(animation)
    }

    fun performFrontAnimation(imageName:String){
        var my_animation = AnimationUtils.loadAnimation(activity, R.anim.font)
        when(imageName){
            "imageViewOne" ->{
                binding.imageViewOne.startAnimation(my_animation)
            }
            "imageViewTwo" ->{
                binding.imageViewTwo.startAnimation(my_animation)
            }
            "imageViewThree" ->{
                binding.imageViewThree.startAnimation(my_animation)
            }
            "imageViewFour"->{
                binding.imageViewFour.startAnimation(my_animation)
            }
            "imageViewFive"->{
                binding.imageViewFive.startAnimation(my_animation)
            }
            "imageViewSix"->{
                binding.imageViewSix.startAnimation(my_animation)
            }
            "imageViewSeven"->{
                binding.imageViewSeven.startAnimation(my_animation)
            }
            "imageViewEight"->{
                binding.imageViewEight.startAnimation(my_animation)
            }
            "imageViewNine"->{
                binding.imageViewNine.startAnimation(my_animation)
            }
            "imageViewTen"->{
                binding.imageViewTen.startAnimation(my_animation)
            }
            "imageViewEleven"->{
                binding.imageViewEleven.startAnimation(my_animation)
            }
            "imageViewTwelve"->{
                binding.imageViewTwelve.startAnimation(my_animation)
            }
        }
    }

}