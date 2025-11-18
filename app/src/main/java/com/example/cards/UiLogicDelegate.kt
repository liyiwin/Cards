package com.example.cards

import com.example.cards.ui_model.CardDetail
import com.example.cards.ui_operation.AnimationEndListener
import com.example.cards.ui_operation.UiOperationsManager
import com.example.cards.utils.ITimerUtils


class UiLogicDelegate (private val uiOperationsManager: UiOperationsManager,private val timerUtils: ITimerUtils){
    private val pendingComparisonDataList = mutableListOf<CardDetail>()

    private var selectedImages = mutableListOf<CardDetail>()

    private var unmatchedDataList = mutableListOf<CardDetail>()



    fun performCreate(){
        val cardList = createCardList();
        unmatchedDataList.addAll(cardList)
        setUnMatchedCardIsLockedObserve()

        setCardTagObserve(cardList[0])
        setCardTagObserve(cardList[1])
        setCardTagObserve(cardList[2])
        setCardTagObserve(cardList[3])
        setCardTagObserve(cardList[4])
        setCardTagObserve(cardList[5])
        setCardTagObserve(cardList[6])
        setCardTagObserve(cardList[7])
        setCardTagObserve(cardList[8])
        setCardTagObserve(cardList[9])
        setCardTagObserve(cardList[10])
        setCardTagObserve(cardList[11])

        setCardClickAction(cardList[0])
        setCardClickAction(cardList[1])
        setCardClickAction(cardList[2])
        setCardClickAction(cardList[3])
        setCardClickAction(cardList[4])
        setCardClickAction(cardList[5])
        setCardClickAction(cardList[6])
        setCardClickAction(cardList[7])
        setCardClickAction(cardList[8])
        setCardClickAction(cardList[9])
        setCardClickAction(cardList[10])
        setCardClickAction(cardList[11])

    }



    fun createCardList():MutableList<CardDetail>{
        val cards  = mutableListOf<CardDetail>()
        val numberLis = mutableListOf<Int>()
        transform(numberLis)
        cards.add(CardDetail("imageViewOne",numberLis[0]))
        cards.add(CardDetail("imageViewTwo",numberLis[1]))
        cards.add(CardDetail("imageViewThree",numberLis[2]))
        cards.add(CardDetail("imageViewFour",numberLis[3]))
        cards.add(CardDetail("imageViewFive",numberLis[4]))
        cards.add(CardDetail("imageViewSix",numberLis[5]))
        cards.add(CardDetail("imageViewSeven",numberLis[6]))
        cards.add(CardDetail("imageViewEight",numberLis[7]))
        cards.add(CardDetail("imageViewNine",numberLis[8]))
        cards.add(CardDetail("imageViewTen",numberLis[9]))
        cards.add(CardDetail("imageViewEleven",numberLis[10]))
        cards.add(CardDetail("imageViewTwelve",numberLis[11]))
        return cards;
    }



fun set_enable( ){
    selectedImages.clear()
    uiOperationsManager.unLockUnMatchedCard()

}



fun compare (cardOne:CardDetail,cardTwo:CardDetail) {

    val point_one = cardOne.point
    val point_two = cardTwo.point

    when {

        point_one != point_two -> {

            shake(cardOne, "one")

            shake(cardTwo, "two")


        }


        point_one == point_two -> {

            timerUtils.delayTask(2000){
                  uiOperationsManager.runOnUiThread {
                        disappear(  cardOne,cardTwo, "one")
                        disappear(  cardTwo,cardOne, "two")
                  }
            }

        }

    }


}



fun shake(ima: CardDetail, flag:String) {



   uiOperationsManager.performShackAnimation(ima.imageName,object:AnimationEndListener{

        override fun onAnimationEnd() {

            rotateCardUpsideDown(ima)

            // flag two 代表動畫完成

            if (flag == "two"){

                set_enable()

            }

        }

    })

}





fun disappear (ima: CardDetail, pairedImage:CardDetail, flag:String){

    uiOperationsManager.performDisappearAnimation(ima.imageName,object:AnimationEndListener{

        override fun onAnimationEnd() {
            // flag two 代表動畫完成
            uiOperationsManager.setImageIsEnabled(ima.imageName,false)
            if (flag == "two"){

                unmatchedDataList.remove(ima)

                unmatchedDataList.remove(pairedImage)

                set_enable()

                if (unmatchedDataList.size  == 0 ){

                    uiOperationsManager.toastMessage("遊戲完成")

                }

            }


        }

    })

}




  fun rotateCardUpright(cardDetail: CardDetail){

      uiOperationsManager.performBackAnimation(cardDetail.imageName,object: AnimationEndListener{
          override fun onAnimationEnd() {
              uiOperationsManager.changeCardTagToFront(cardDetail.imageName)
              uiOperationsManager.performFrontAnimation(cardDetail.imageName)
              pendingComparisonDataList.add(cardDetail)
              if (pendingComparisonDataList.size == 2 ) {
                  compare (pendingComparisonDataList[0],pendingComparisonDataList[1])
                  pendingComparisonDataList.clear()
              }

          }

          })

  }

  fun rotateCardUpsideDown(ima: CardDetail){

      uiOperationsManager.performBackAnimation(ima.imageName,object: AnimationEndListener{
          override fun onAnimationEnd() {
              uiOperationsManager.changeCardTagToBack(ima.imageName)
              uiOperationsManager.performFrontAnimation(ima.imageName)




          }


      })

  }
    private fun setUnMatchedCardIsLockedObserve(){
        uiOperationsManager.setUnMatchedDataIsLockedObserver{ isLocked ->
            val isEnabled = !isLocked
            unmatchedDataList.forEach {
                uiOperationsManager.setImageIsEnabled(it.imageName,isEnabled)
            }

        }
    }
    private fun setCardTagObserve(cardDetail: CardDetail){

        uiOperationsManager.setCarTagObserver(cardDetail.imageName){

            if (it == "front"){

                uiOperationsManager.set_mycard_Image(cardDetail.imageName,cardDetail.point)
            }

            if (it == "back"){

                uiOperationsManager.setCardBackImage(cardDetail.imageName)


            }

        }
    }
    private fun setCardClickAction(cardDetail: CardDetail){
        uiOperationsManager.setCarClickListener(cardDetail.imageName) {

            uiOperationsManager.setImageIsEnabled(cardDetail.imageName,false)

            selectedImages.add(cardDetail)

            if (selectedImages.size == 2){
                uiOperationsManager.lockUnMatchedCard()
            }

            rotateCardUpright(cardDetail)

        }
    }


}

