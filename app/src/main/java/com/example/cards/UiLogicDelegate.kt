package com.example.cards


import com.example.cards.ui_model.UiEvent
import com.example.cards.ui_operation.AnimationEndListener
import com.example.cards.ui_operation.IUiOperationsManager
import com.example.cards.ui_operation.UiOperationsManager


class UiLogicDelegate (private val uiOperationsManager: IUiOperationsManager){


    fun performCreate(){
        for (i in 0 .. 11) {
            setCardClickAction(i)
        }

        uiOperationsManager.setUiEventObserver{ uiEvent ->
            when(uiEvent){
                is UiEvent.LockCardUiEvent -> uiOperationsManager.setImageIsEnabled(uiEvent.imageName,false)
                is UiEvent.PerformBackAnimation -> {
                    uiOperationsManager.performBackAnimation(uiEvent.imageName,object: AnimationEndListener{
                        override fun onAnimationEnd() {
                            uiEvent.callback.invoke()
                        }
                    })
                }
                is UiEvent.PerformFrontAnimation -> uiOperationsManager.performFrontAnimation(uiEvent.imageName)
                is UiEvent.PerformShackAnimation -> {
                    uiOperationsManager.performShackAnimation(uiEvent.imageName,object: AnimationEndListener {
                        override fun onAnimationEnd() {
                            uiEvent.callback.invoke()
                        }

                    })
                }

                is UiEvent.PerformDisappearAnimation -> {
                    uiOperationsManager.performDisappearAnimation(uiEvent.imageName,object: AnimationEndListener {
                        override fun onAnimationEnd() {
                            uiEvent.callback.invoke()
                        }
                    })
                }

                is UiEvent.Toast ->  uiOperationsManager.toastMessage(uiEvent.message)
                is UiEvent.LockAllUnMatchedCardUiEvent -> {
                    uiEvent.allUnMatchedCard.forEach {
                        uiOperationsManager.setImageIsEnabled(it.imageName,false)
                    }
                }
                is UiEvent.UnLockAllUnMatchedCardUiEvent -> {
                    uiEvent.allUnMatchedCard.forEach{
                        uiOperationsManager.setImageIsEnabled(it.imageName,true)
                    }
                }

                is UiEvent.RenderCardBack ->  uiOperationsManager.setCardBackImage(uiEvent.imageName)
                is UiEvent.RenderCardFront -> uiOperationsManager.set_mycard_Image(uiEvent.imageName,uiEvent.point)
            }
        }

    }

     private fun setCardClickAction(index:Int){
        uiOperationsManager.setCarClickListener(index) {
           uiOperationsManager.emitSelection(index)
        }
    }


}

