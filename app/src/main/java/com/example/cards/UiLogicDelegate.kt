package com.example.cards

import android.content.Context
import com.example.cards.ui_model.ImageData
import com.example.cards.ui_operation.AnimationEndListener
import com.example.cards.ui_operation.UiOperationsManager
import com.example.cards.utils.ITimerUtils


class UiLogicDelegate (private val uiOperationsManager: UiOperationsManager,private val timerUtils: ITimerUtils){

    private val pendingComparisonDataList = mutableListOf<PendingComparisonData>()
    private var selectedImages = mutableListOf<ImageData>()

    private var list = mutableListOf<Int>()

    private var unmatchedDataList = mutableListOf<ImageData>()



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

        unmatchedDataList.add(ImageData("imageViewOne"))
        unmatchedDataList.add(ImageData("imageViewTwo"))
        unmatchedDataList.add(ImageData("imageViewThree"))
        unmatchedDataList.add(ImageData("imageViewFour"))
        unmatchedDataList.add(ImageData("imageViewFive"))
        unmatchedDataList.add(ImageData("imageViewSix"))
        unmatchedDataList.add(ImageData("imageViewSeven"))
        unmatchedDataList.add(ImageData("imageViewEight"))
        unmatchedDataList.add(ImageData("imageViewNine"))
        unmatchedDataList.add(ImageData("imageViewTen"))
        unmatchedDataList.add(ImageData("imageViewEleven"))
        unmatchedDataList.add(ImageData("imageViewTwelve"))

    }



fun set_enable( ){

        selectedImages.clear()
        uiOperationsManager.unLockUnMatchedCard()

}



fun compare () {

    if (pendingComparisonDataList.size == 2 ){

    val ima_one = pendingComparisonDataList[0].ima
    val ima_two = pendingComparisonDataList[1].ima
    val point_one = pendingComparisonDataList[0].point
    val point_two = pendingComparisonDataList[1].point

    pendingComparisonDataList.clear()

    when {

        point_one != point_two -> {

            shake(ima_one, "one")

            shake(ima_two, "two")


        }


        point_one == point_two -> {

            var time = 2

            val handler = android.os.Handler()
            val runnable = object :Runnable{
                override fun run() {

                    handler.postDelayed(this,1000)

                    time = time-1

                    if (time == 0){

                        handler.removeCallbacks(this)

                        disappear(  ima_one,ima_two, "one")

                        disappear(  ima_two,ima_one, "two")

                    }


                }


            }
            handler.postDelayed(runnable,1000)

        }

    }

}

}



fun shake(ima: ImageData, flag:String) {



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





fun disappear ( ima: ImageData, pairedImage:ImageData, flag:String){

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




  fun rotateCardUpright( point:Int, ima: ImageData){

      uiOperationsManager.performBackAnimation(ima.imageName,object: AnimationEndListener{
          override fun onAnimationEnd() {
              uiOperationsManager.changeCardTagToFront(ima.imageName)
              uiOperationsManager.performFrontAnimation(ima.imageName)
              pendingComparisonDataList.add(PendingComparisonData(ima,point))
              compare ()
          }

          })

  }

  fun rotateCardUpsideDown(ima: ImageData){

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

            selectedImages.add(ImageData(imageName))

            if (selectedImages.size == 2){
                uiOperationsManager.lockUnMatchedCard()

            }

            rotateCardUpright(number,ImageData(imageName))

        }
    }


}

