package com.example.cards.ui_operation

import com.example.cards.ui_model.UiEvent

interface IUiOperationsManager {
    fun emitSelection(index:Int)
    fun setCarClickListener(index:Int,listener:() -> Unit)
    fun set_mycard_Image(imageName:String,number:Int)
    fun setCardBackImage(imageName:String)
    fun toastMessage(message:String)
    fun setImageIsEnabled(imageName:String , isEnabled:Boolean)
    fun performDisappearAnimation(imageName: String,animationEndListener:AnimationEndListener)
    fun performShackAnimation(imageName: String,animationEndListener:AnimationEndListener)
    fun performBackAnimation(imageName: String,animationEndListener:AnimationEndListener)
    fun performFrontAnimation(imageName:String)
    fun setUiEventObserver(uiEventObserver:(UiEvent)->Unit)
}