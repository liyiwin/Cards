package com.example.cards.ui_operation

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cards.R
import com.example.cards.MainViewModel
import com.example.cards.databinding.ActivityMainBinding

class UiOperationsManager(private val activity:AppCompatActivity,private val binding: ActivityMainBinding,private val mainViewModel: MainViewModel) {

    fun runOnUiThread(callback:()->Unit){
        activity.runOnUiThread {
            callback.invoke()
        }
    }

    fun lockUnMatchedCard(){
        mainViewModel.lockUnMatchedData()
    }

    fun unLockUnMatchedCard(){
        mainViewModel.unlLockUnMatchedData()
    }

    fun changeCardTagToBack(imageName:String){
         mainViewModel.setImageTag(imageName,"back")
    }
    fun changeCardTagToFront(imageName:String){
        mainViewModel.setImageTag(imageName,"front")
    }

    fun setCarClickListener(imageName:String,listener:() -> Unit){
        val imageView = getImageView(imageName)
        imageView.setOnClickListener { listener.invoke() }
    }

    fun set_mycard_Image(imageName:String,number:Int){
        val drawable = getDrawable(number)
        val imageView = getImageView(imageName)
        imageView.setImageResource(drawable)
    }
    fun setCardBackImage(imageName:String){
        val imageView = getImageView(imageName)
        imageView.setImageResource(R.drawable.background)
    }

    fun toastMessage(message:String){
        Toast.makeText(activity,message, Toast.LENGTH_LONG).show()
    }

    fun setImageIsEnabled(imageName:String , isEnabled:Boolean){
        val imageView = getImageView(imageName)
        imageView.isEnabled = isEnabled
    }
    fun performDisappearAnimation(imageName: String,animationEndListener:AnimationEndListener){

        val my_animation = AnimationUtils.loadAnimation(activity,R.anim.disappear)
        val imageView = getImageView(imageName)
        _performAnimation(imageView,animationEndListener,my_animation)
    }
    fun performShackAnimation(imageName: String,animationEndListener:AnimationEndListener){

        val my_animation = AnimationUtils.loadAnimation(activity,R.anim.shake)
        val imageView = getImageView(imageName)
        _performAnimation(imageView,animationEndListener,my_animation)
    }

    fun performBackAnimation(imageName: String,animationEndListener:AnimationEndListener){

        val my_animation =  AnimationUtils.loadAnimation(activity, R.anim.back)
        val imageView = getImageView(imageName)
        _performAnimation(imageView,animationEndListener,my_animation)
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
        val imageView = getImageView(imageName)
        imageView.startAnimation(my_animation)
    }
    fun getDrawable(number: Int):Int{
        when(number){
            1->return R.drawable.a
            2->return R.drawable.two
            3->return R.drawable.three
            4->return R.drawable.four
            5->return R.drawable.five
            6->return R.drawable.six
            7->return R.drawable.seven
            8->return R.drawable.eight
            9->return R.drawable.nine
            10->return R.drawable.ten
            11->return R.drawable.eleven
            12->return R.drawable.twelve
            else->return R.drawable.thirteen
        }
    }



    fun getImageView(imageName: String):ImageView{
        when(imageName){
            "imageViewOne" ->{
                return binding.imageViewOne
            }
            "imageViewTwo" ->{
                return binding.imageViewTwo
            }
            "imageViewThree" ->{
                return binding.imageViewThree
            }
            "imageViewFour"->{
                return binding.imageViewFour
            }
            "imageViewFive"->{
                return binding.imageViewFive
            }
            "imageViewSix"->{
                return binding.imageViewSix
            }
            "imageViewSeven"->{
                return binding.imageViewSeven
            }
            "imageViewEight"->{
                return binding.imageViewEight
            }
            "imageViewNine"->{
                return binding.imageViewNine
            }
            "imageViewTen"->{
                return binding.imageViewTen
            }
            "imageViewEleven"->{
                return binding.imageViewEleven
            }
            else->{
                return binding.imageViewTwelve
            }
        }
    }

    fun setUnMatchedDataIsLockedObserver(listener: (Boolean) -> Unit){
        val unMatchedDataIsLocked = Observer<Boolean>{ isLocked ->
            listener.invoke(isLocked)

        }
        mainViewModel.getUnMatchedDataIsLocked().observe(activity,unMatchedDataIsLocked)
    }

    fun setCarTagObserver(imageName:String,listener: (String) -> Unit){
        val observer = Observer<String>{
            listener.invoke(it)
        }
        val imageTag = mainViewModel.getImageTag(imageName)
        imageTag.observe(activity,observer)
    }
}