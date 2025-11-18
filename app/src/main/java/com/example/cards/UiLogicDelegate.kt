package com.example.cards

import android.content.Context
import com.example.cards.ui_model.ImageData
import com.example.cards.ui_operation.AnimationEndListener
import com.example.cards.ui_operation.UiOperationsManager


class UiLogicDelegate (private val carTagManager: ICardTagManager,private val unMatchedDataManger: IUnMatchedDataManger,private val uiOperationsManager: UiOperationsManager){

    private val pendingComparisonDataList = mutableListOf<PendingComparisonData>()

fun set_enable( selectedImages: MutableList<ImageData>){

        selectedImages.clear()
        unMatchedDataManger.unlLockUnMatchedData()

}



fun compare ( unmatchedDataList: MutableList<ImageData>, selectedImages: MutableList<ImageData>) {

    if (pendingComparisonDataList.size == 2 ){

    val ima_one = pendingComparisonDataList[0].ima
    val ima_two = pendingComparisonDataList[1].ima
    val point_one = pendingComparisonDataList[0].point
    val point_two = pendingComparisonDataList[1].point

    pendingComparisonDataList.clear()

    when {

        point_one != point_two -> {

            shake(ima_one,selectedImages, "one")

            shake(ima_two,selectedImages, "two")


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

                        disappear( unmatchedDataList,selectedImages, ima_one,ima_two, "one")

                        disappear( unmatchedDataList,selectedImages, ima_two,ima_one, "two")

                    }


                }


            }
            handler.postDelayed(runnable,1000)

        }

    }

}

}



fun shake(ima: ImageData, selectedImages: MutableList<ImageData>, flag:String) {



   uiOperationsManager.performShackAnimation(ima.imageName,object:AnimationEndListener{

        override fun onAnimationEnd() {

            rotateCardUpsideDown(ima)

            // flag two 代表動畫完成

            if (flag == "two"){

                set_enable(selectedImages)

            }

        }

    })

}





fun disappear (unmatchedDataList: MutableList<ImageData>, selectedImages: MutableList<ImageData>, ima: ImageData, pairedImage:ImageData, flag:String){

    uiOperationsManager.performDisappearAnimation(ima.imageName,object:AnimationEndListener{

        override fun onAnimationEnd() {

            uiOperationsManager.setImageIsEnabled(ima.imageName,false)

            // flag two 代表動畫完成

            if (flag == "two"){

                unmatchedDataList.remove(ima)

                unmatchedDataList.remove(pairedImage)

                set_enable(selectedImages)

                if (unmatchedDataList.size  == 0 ){

                    uiOperationsManager.toastMessage("遊戲完成")

                }

            }


        }

    })

}




  fun rotateCardUpright(unmatchedDataList:MutableList<ImageData>, selectedImages:MutableList<ImageData>, point:Int, ima: ImageData){

      uiOperationsManager.performBackAnimation(ima.imageName,object: AnimationEndListener{
          override fun onAnimationEnd() {

                  when(ima.imageName){

                      "imageViewOne"->{

                          carTagManager.set_ima_one_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewTwo" ->{

                          carTagManager.set_ima_two_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewThree"->{

                          carTagManager.set_ima_three_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewFour"->{

                          carTagManager.set_ima_four_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewFive"->{

                          carTagManager.set_ima_five_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point ))

                          compare (unmatchedDataList,selectedImages)
                      }

                      "imageViewSix"->{

                          carTagManager.set_ima_six_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewSeven"->{

                          carTagManager.set_ima_seven_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewEight"->{

                          carTagManager.set_ima_eight_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewNine"->{

                          carTagManager.set_ima_nine_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewTen"->{


                          carTagManager.set_ima_ten_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point ))

                          compare (unmatchedDataList,selectedImages)


                      }

                      "imageViewEleven"->{

                          carTagManager.set_ima_eleven_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (unmatchedDataList,selectedImages)

                      }

                      "imageViewTwelve"->{

                          carTagManager.set_ima_twelve_tag("front")

                          uiOperationsManager.performFrontAnimation(ima.imageName)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point  ))

                          compare (unmatchedDataList,selectedImages)


                      }


                  }




          }

          })

  }

  fun rotateCardUpsideDown(ima: ImageData){

      uiOperationsManager.performBackAnimation(ima.imageName,object: AnimationEndListener{
          override fun onAnimationEnd() {

                  when(ima.imageName){

                      "imageViewOne" ->{

                          carTagManager.set_ima_one_tag("back")

                      }

                      "imageViewTwo" ->{

                          carTagManager.set_ima_two_tag("back")

                      }

                      "imageViewThree"->{

                          carTagManager.set_ima_three_tag("back")

                      }

                      "imageViewFour"->{

                          carTagManager.set_ima_four_tag("back")

                      }

                      "imageViewFive"->{

                          carTagManager.set_ima_five_tag("back")

                      }

                      "imageViewSix"->{

                          carTagManager.set_ima_six_tag("back")

                      }

                      "imageViewSeven"->{

                          carTagManager.set_ima_seven_tag("back")

                      }

                      "imageViewEight"->{

                          carTagManager.set_ima_eight_tag("back")

                      }

                      "imageViewNine"->{

                          carTagManager.set_ima_nine_tag("back")

                      }

                      "imageViewTen"->{


                          carTagManager.set_ima_ten_tag("back")


                      }

                      "imageViewEleven"->{

                          carTagManager.set_ima_eleven_tag("back")

                      }

                      "imageViewTwelve"->{

                          carTagManager.set_ima_twelve_tag("back")


                      }


                  }

                  uiOperationsManager.performFrontAnimation(ima.imageName)




          }


      })

  }

}

