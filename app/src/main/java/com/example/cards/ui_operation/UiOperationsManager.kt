package com.example.cards.ui_operation

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cards.R
import com.example.cards.ViewModel
import com.example.cards.databinding.ActivityMainBinding
import com.example.cards.ui_model.ImageData

class UiOperationsManager(private val activity:AppCompatActivity,private val binding: ActivityMainBinding,private val viewModel: ViewModel) {

    fun lockUnMatchedCard(){
        viewModel.lockUnMatchedData()
    }

    fun unLockUnMatchedCard(){
        viewModel.unlLockUnMatchedData()
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
        viewModel.getUnMatchedDataIsLocked().observe(activity,unMatchedDataIsLocked)
    }

    fun setCarTagObserver(imageName:String,listener: (String) -> Unit){
        val observer = Observer<String>{
            listener.invoke(it)
        }
        when(imageName){
            "imageViewOne" ->{
                viewModel.get_ima_one_tag().observe(activity,observer)
            }
            "imageViewTwo" ->{
                viewModel.get_ima_two_tag().observe(activity,observer)
            }
            "imageViewThree" ->{
                viewModel.get_ima_three_tag().observe(activity,observer)
            }
            "imageViewFour"->{
                viewModel.get_ima_four_tag().observe(activity,observer)
            }
            "imageViewFive"->{
                viewModel.get_ima_five_tag().observe(activity,observer)
            }
            "imageViewSix"->{
                viewModel.get_ima_six_tag().observe(activity,observer)
            }
            "imageViewSeven"->{
                viewModel.get_ima_seven_tag().observe(activity,observer)
            }
            "imageViewEight"->{
                viewModel.get_ima_eight_tag().observe(activity,observer)
            }
            "imageViewNine"->{
                viewModel.get_ima_nine_tag().observe(activity,observer)
            }
            "imageViewTen"->{
                viewModel.get_ima_ten_tag().observe(activity,observer)
            }
            "imageViewEleven"->{
                viewModel.get_ima_eleven_tag().observe(activity,observer)
            }
            "imageViewTwelve"->{
                viewModel.get_ima_twelve_tag().observe(activity,observer)
            }
        }

    }
}