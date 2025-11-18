package com.example.cards

import android.content.Context
import com.example.cards.ui_model.ImageData
import com.example.cards.ui_operation.AnimationEndListener
import com.example.cards.ui_operation.UiOperationsManager


class UiLogicDelegate (private val carTagManager: ICardTagManager,private val unMatchedDataManger: IUnMatchedDataManger,private val uiOperationsManager: UiOperationsManager){

    private val pendingComparisonDataList = mutableListOf<PendingComparisonData>()
    private var selectedImages = mutableListOf<ImageData>()

    private var list = mutableListOf<Int>()

    private var unmatchedDataList = mutableListOf<ImageData>()



    fun performCreate(){
        add_Image_into_list(unmatchedDataList)

        transform(list)

        val unMatchedDataIsLocked = Observer<Boolean>{ isLocked ->
            val isEnabled = !isLocked
            unmatchedDataList.forEach {
                uiOperationsManager.setImageIsEnabled(it.imageName,isEnabled)
            }

        }

        viewModel.getUnMatchedDataIsLocked().observe(this,unMatchedDataIsLocked)

        // tag_one

        val tag_one_Observer = Observer<String>{

            if (it == "front"){

                val number = list[0]

                uiOperationsManager.set_mycard_Image(binding.imageViewOne,number)

            }

            if (it == "back"){

                binding.imageViewOne.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_one_tag().observe(this,tag_one_Observer)

        // tag_two

        val tag_two_Observer = Observer<String>{

            if (it == "front"){

                val number = list[1]

                uiOperationsManager.set_mycard_Image(binding.imageViewTwo,number)
            }

            if (it == "back"){

                binding.imageViewTwo.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_two_tag().observe(this,tag_two_Observer)

        // tag_three

        val tag_three_Observer = Observer<String>{

            if (it == "front"){

                val number = list[2]

                uiOperationsManager.set_mycard_Image(binding.imageViewThree,number)
            }

            if (it == "back"){

                binding.imageViewThree.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_three_tag().observe(this,tag_three_Observer)

        // tag_four

        val tag_four_Observer = Observer<String>{

            if (it == "front"){

                val number = list[3]

                uiOperationsManager.set_mycard_Image(binding.imageViewFour,number)
            }

            if (it == "back"){

                binding.imageViewFour.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_four_tag().observe(this,tag_four_Observer)

        // tag_five

        val tag_five_Observer = Observer<String>{

            if (it == "front"){

                val number = list[4]

                uiOperationsManager.set_mycard_Image(binding.imageViewFive,number)
            }

            if (it == "back"){

                binding.imageViewFive.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_five_tag().observe(this,tag_five_Observer)

        // tag_six

        val tag_six_Observer = Observer<String>{

            if (it == "front"){

                val number = list[5]

                uiOperationsManager.set_mycard_Image(binding.imageViewSix,number)
            }

            if (it == "back"){

                binding.imageViewSix.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_six_tag().observe(this,tag_six_Observer)

        // tag_seven

        val tag_seven_Observer = Observer<String>{

            if (it == "front"){

                val number = list[6]

                uiOperationsManager.set_mycard_Image(binding.imageViewSeven,number)
            }

            if (it == "back"){

                binding.imageViewSeven.setImageResource(R.drawable.background)

            }


        }

        viewModel.get_ima_seven_tag().observe(this,tag_seven_Observer)



        // tag_eight

        val tag_eight_Observer = Observer<String>{

            if (it == "front"){

                val number = list[7]

                uiOperationsManager.set_mycard_Image(binding.imageViewEight,number)
            }

            if (it == "back"){

                binding.imageViewEight.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_eight_tag().observe(this,tag_eight_Observer)

        // tag_nine

        val tag_nine_Observer = Observer<String>{

            if (it == "front"){

                val number = list[8]

                uiOperationsManager.set_mycard_Image(binding.imageViewNine,number)
            }

            if (it == "back"){

                binding.imageViewNine.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_nine_tag().observe(this,tag_nine_Observer)

        // tag_ten

        val tag_ten_Observer = Observer<String>{

            if (it == "front"){

                val number = list[9]

                uiOperationsManager.set_mycard_Image(binding.imageViewTen,number)
            }

            if (it == "back"){

                binding.imageViewTen.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_ten_tag().observe(this,tag_ten_Observer)

        // tag_eleven

        val tag_eleven_Observer = Observer<String>{

            if (it == "front"){

                val number = list[10]

                uiOperationsManager.set_mycard_Image(binding.imageViewEleven,number)
            }

            if (it == "back"){

                binding.imageViewEleven.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_eleven_tag().observe(this,tag_eleven_Observer)


        // tag_twelve

        val tag_twelve_Observer = Observer<String>{

            if (it == "front"){

                val number = list[11]

                uiOperationsManager.set_mycard_Image(binding.imageViewTwelve,number)
            }

            if (it == "back"){

                binding.imageViewTwelve.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_twelve_tag().observe(this,tag_twelve_Observer)


        setCareClickAction("imageViewOne",list[0])
        setCareClickAction("imageViewTwo",list[1])
        setCareClickAction("imageViewThree",list[2])
        setCareClickAction("imageViewFour",list[3])
        setCareClickAction("imageViewFive",list[4])
        setCareClickAction("imageViewSix",list[5])
        setCareClickAction("imageViewSeven",list[6])
        setCareClickAction("imageViewEight",list[7])
        setCareClickAction("imageViewNine",list[8])
        setCareClickAction("imageViewTen",list[9])
        setCareClickAction("imageViewEleven",list[10])
        setCareClickAction("imageViewTwelve",list[11])

    }



    fun add_Image_into_list(list: MutableList<ImageData>){

        list.add(ImageData("imageViewOne"))
        list.add(ImageData("imageViewTwo"))
        list.add(ImageData("imageViewThree"))
        list.add(ImageData("imageViewFour"))
        list.add(ImageData("imageViewFive"))
        list.add(ImageData("imageViewSix"))
        list.add(ImageData("imageViewSeven"))
        list.add(ImageData("imageViewEight"))
        list.add(ImageData("imageViewNine"))
        list.add(ImageData("imageViewTen"))
        list.add(ImageData("imageViewEleven"))
        list.add(ImageData("imageViewTwelve"))

    }



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

    private fun setCareClickAction(imageName:String,number:Int){
        uiOperationsManager.setCarClickListener(imageName) {

            uiOperationsManager.setImageIsEnabled(imageName,false)

            selectedImages.add(ImageData(imageName))

            if (selectedImages.size == 2){
                unMatchedDataManger.lockUnMatchedData()

            }

            rotateCardUpright(unmatchedDataList,selectedImages,number,ImageData(imageName))

        }
    }


}

