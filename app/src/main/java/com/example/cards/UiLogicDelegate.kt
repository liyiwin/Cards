package com.example.cards

import com.example.cards.ui_model.CardDetail
import com.example.cards.ui_operation.AnimationEndListener
import com.example.cards.ui_operation.UiOperationsManager
import com.example.cards.utils.ITimerUtils


class UiLogicDelegate (private val uiOperationsManager: UiOperationsManager,private val timerUtils: ITimerUtils){

    private val pendingComparisonDataList = mutableListOf<PendingComparisonData>()
    private var selectedImages = mutableListOf<CardDetail>()

    private var list = mutableListOf<Int>()

    private var unmatchedDataList = mutableListOf<CardDetail>()



    fun performCreate(){
        add_Image_into_list()

        transform(list)

        setUnMatchedCardIsLockedObserve()

        setCardTagObserve("imageViewOne",list[0])
        setCardTagObserve("imageViewTwo",list[1])
        setCardTagObserve("imageViewThree",list[2])
        setCardTagObserve("imageViewFour",list[3])
        setCardTagObserve("imageViewFive",list[4])
        setCardTagObserve("imageViewSix",list[5])
        setCardTagObserve("imageViewSeven",list[6])
        setCardTagObserve("imageViewEight",list[7])
        setCardTagObserve("imageViewNine",list[8])
        setCardTagObserve("imageViewTen",list[9])
        setCardTagObserve("imageViewEleven",list[10])
        setCardTagObserve("imageViewTwelve",list[11])

        setCardClickAction("imageViewOne",list[0])
        setCardClickAction("imageViewTwo",list[1])
        setCardClickAction("imageViewThree",list[2])
        setCardClickAction("imageViewFour",list[3])
        setCardClickAction("imageViewFive",list[4])
        setCardClickAction("imageViewSix",list[5])
        setCardClickAction("imageViewSeven",list[6])
        setCardClickAction("imageViewEight",list[7])
        setCardClickAction("imageViewNine",list[8])
        setCardClickAction("imageViewTen",list[9])
        setCardClickAction("imageViewEleven",list[10])
        setCardClickAction("imageViewTwelve",list[11])

    }



    fun add_Image_into_list(){

        unmatchedDataList.add(CardDetail("imageViewOne"))
        unmatchedDataList.add(CardDetail("imageViewTwo"))
        unmatchedDataList.add(CardDetail("imageViewThree"))
        unmatchedDataList.add(CardDetail("imageViewFour"))
        unmatchedDataList.add(CardDetail("imageViewFive"))
        unmatchedDataList.add(CardDetail("imageViewSix"))
        unmatchedDataList.add(CardDetail("imageViewSeven"))
        unmatchedDataList.add(CardDetail("imageViewEight"))
        unmatchedDataList.add(CardDetail("imageViewNine"))
        unmatchedDataList.add(CardDetail("imageViewTen"))
        unmatchedDataList.add(CardDetail("imageViewEleven"))
        unmatchedDataList.add(CardDetail("imageViewTwelve"))

    }



fun set_enable( ){

        selectedImages.clear()
        uiOperationsManager.unLockUnMatchedCard()

}



fun compare () {

    if (pendingComparisonDataList.size == 2 ){

    val ima_one = pendingComparisonDataList[0].card
    val ima_two = pendingComparisonDataList[1].card
    val point_one = pendingComparisonDataList[0].point
    val point_two = pendingComparisonDataList[1].point

    pendingComparisonDataList.clear()

    when {

        point_one != point_two -> {

            shake(ima_one, "one")

            shake(ima_two, "two")


        }


        point_one == point_two -> {

            timerUtils.delayTask(2000){
                  uiOperationsManager.runOnUiThread {
                        disappear(  ima_one,ima_two, "one")
                        disappear(  ima_two,ima_one, "two")
                  }
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

            uiOperationsManager.setImageIsEnabled(ima.imageName,false)

            // flag two 代表動畫完成

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




  fun rotateCardUpright( point:Int, ima: CardDetail){

      uiOperationsManager.performBackAnimation(ima.imageName,object: AnimationEndListener{
          override fun onAnimationEnd() {
              uiOperationsManager.changeCardTagToFront(ima.imageName)
              uiOperationsManager.performFrontAnimation(ima.imageName)
              pendingComparisonDataList.add(PendingComparisonData(ima,point))
              compare ()
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
    private fun setCardTagObserve(imageName:String,number:Int){

        uiOperationsManager.setCarTagObserver(imageName){

            if (it == "front"){

                uiOperationsManager.set_mycard_Image(imageName,number)
            }

            if (it == "back"){

                uiOperationsManager.setCardBackImage(imageName)


            }

        }
    }
    private fun setCardClickAction(imageName:String,number:Int){
        uiOperationsManager.setCarClickListener(imageName) {

            uiOperationsManager.setImageIsEnabled(imageName,false)

            selectedImages.add(CardDetail(imageName))

            if (selectedImages.size == 2){
                uiOperationsManager.lockUnMatchedCard()

            }

            rotateCardUpright(number,CardDetail(imageName))

        }
    }


}

