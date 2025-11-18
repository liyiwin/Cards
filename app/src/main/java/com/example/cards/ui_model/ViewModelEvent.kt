package com.example.cards.ui_model

sealed class ViewModelEvent {

   data class CardSelectionViewModelEvent(val index:Int):ViewModelEvent()

}