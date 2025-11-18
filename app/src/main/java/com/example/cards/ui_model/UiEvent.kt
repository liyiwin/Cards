package com.example.cards.ui_model

sealed class UiEvent {
    data class LockCardUiEvent(val imageName:String):UiEvent()
    data class LockAllUnMatchedCardUiEvent(val allUnMatchedCard:List<CardDetail>):UiEvent()
    data class UnLockAllUnMatchedCardUiEvent(val allUnMatchedCard:List<CardDetail>):UiEvent()
    data class Toast(val message:String):UiEvent()
    data class PerformBackAnimation(val imageName:String,val callback:() -> Unit):UiEvent()
    data class PerformShackAnimation(val imageName:String,val callback:() -> Unit):UiEvent()
    data class PerformDisappearAnimation(val imageName:String,val callback:() -> Unit):UiEvent()
    data class PerformFrontAnimation(val imageName:String):UiEvent()
    data class RenderCardBack(val imageName:String):UiEvent()
    data class RenderCardFront(val imageName:String,val point:Int):UiEvent()
}