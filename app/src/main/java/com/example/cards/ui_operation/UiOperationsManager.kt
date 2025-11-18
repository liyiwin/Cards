package com.example.cards.ui_operation

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cards.R
import com.example.cards.MainViewModel
import com.example.cards.databinding.ActivityMainBinding
import com.example.cards.ui_model.CardDetail
import com.example.cards.ui_model.UiEvent
import com.example.cards.ui_model.ViewModelEvent
import kotlinx.coroutines.launch

class UiOperationsManager(private val activity:AppCompatActivity,private val binding: ActivityMainBinding,private val mainViewModel: MainViewModel,private val lifecycleOwner: LifecycleOwner) {

    fun runOnUiThread(callback:()->Unit){
        activity.runOnUiThread {
            callback.invoke()
        }
    }

    fun emitSelection(index:Int){
        mainViewModel.sendViewModelEvent(ViewModelEvent.CardSelectionViewModelEvent(index))
    }



    fun setCarClickListener(index:Int,listener:() -> Unit){
        val imageView = getImageView(index)
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

    fun getImageView(index: Int):ImageView{
        when(index){
            0 ->{
                return binding.imageViewOne
            }
            1 ->{
                return binding.imageViewTwo
            }
            2 ->{
                return binding.imageViewThree
            }
            3->{
                return binding.imageViewFour
            }
            4->{
                return binding.imageViewFive
            }
            5->{
                return binding.imageViewSix
            }
            6->{
                return binding.imageViewSeven
            }
            7->{
                return binding.imageViewEight
            }
            8->{
                return binding.imageViewNine
            }
            9->{
                return binding.imageViewTen
            }
            10->{
                return binding.imageViewEleven
            }
            else->{
                return binding.imageViewTwelve
            }
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

    fun setUiEventObserver(uiEventObserver:(UiEvent)->Unit){
       lifecycleOwner.lifecycleScope.launch {
           lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
               mainViewModel.uiEvent.collect{ event ->
                   uiEventObserver.invoke(event)
               }
           }
       }
    }
}