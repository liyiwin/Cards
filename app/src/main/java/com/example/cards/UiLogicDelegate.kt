package com.example.cards

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast


class UiLogicDelegate (private val carTagManager: ICardTagManager){

fun set_enable(unmatchedDataList: MutableList<ImageView>, selectedImages: MutableList<ImageView>, pendingComparisonDataList: MutableList<PendingComparisonData> ){

    if (pendingComparisonDataList.size == 2){

        selectedImages.clear()

        for (i in 0 until unmatchedDataList.size){

            unmatchedDataList[i].isEnabled  = true

        }

    }

}



fun compare (pendingComparisonDataList: MutableList<PendingComparisonData>, context: Context, unmatchedDataList: MutableList<ImageView>, selectedImages: MutableList<ImageView>) {

    if (pendingComparisonDataList.size == 2 ){

    val copiedPendingComparisonDataList = mutableListOf<PendingComparisonData>()

    copiedPendingComparisonDataList.addAll(pendingComparisonDataList)

    pendingComparisonDataList.clear()

    val ima_one = copiedPendingComparisonDataList[0].ima
    val ima_two = copiedPendingComparisonDataList[1].ima
    val point_one = copiedPendingComparisonDataList[0].point
    val point_two = copiedPendingComparisonDataList[1].point

    when {

        point_one != point_two -> {

            shake(ima_one, point_one, context, copiedPendingComparisonDataList, unmatchedDataList,selectedImages, "one")

            shake(ima_two, point_two, context, copiedPendingComparisonDataList, unmatchedDataList,selectedImages, "two")


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

                        disappear(copiedPendingComparisonDataList, unmatchedDataList,selectedImages, ima_one, context, "one")

                        disappear(copiedPendingComparisonDataList, unmatchedDataList,selectedImages, ima_two, context, "two")

                    }


                }


            }
            handler.postDelayed(runnable,1000)

        }

    }

}

}



fun shake(ima: ImageView, point:Int, context:Context, pendingComparisonDataList: MutableList<PendingComparisonData>, unmatchedDataList: MutableList<ImageView>, selectedImages: MutableList<ImageView>, flag:String) {


val animation = AnimationUtils.loadAnimation(context,R.anim.shake)

    animation.setAnimationListener(object:Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {

            rotateCardUpsideDown(ima,context)

            // flag two 代表動畫完成

            if (flag == "two"){

                set_enable(unmatchedDataList,selectedImages, pendingComparisonDataList )

            }

        }

        override fun onAnimationStart(animation: Animation?) {

        }


    })


ima.startAnimation(animation)

}





fun disappear (pendingComparisonDataList: MutableList<PendingComparisonData>, unmatchedDataList: MutableList<ImageView>, selectedImages: MutableList<ImageView>, ima: ImageView, context:Context, flag:String){

    val animation = AnimationUtils.loadAnimation(context,R.anim.disappear)

    animation.setAnimationListener(object:Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {

            ima.isEnabled = false

            // flag two 代表動畫完成

            if (flag == "two"){

                val ima_one = pendingComparisonDataList[0].ima

                val ima_two = pendingComparisonDataList[1].ima

                unmatchedDataList.remove(ima_one)

                unmatchedDataList.remove(ima_two)

                set_enable(unmatchedDataList,selectedImages, pendingComparisonDataList)

                if (unmatchedDataList.size  == 0 ){

                    Toast.makeText(context,"遊戲完成",Toast.LENGTH_LONG).show()

                }

            }


        }

        override fun onAnimationStart(animation: Animation?) {

        }

    })

    ima.startAnimation(animation)


}




fun animation(unmatchedDataList:MutableList<ImageView>, selectedImages:MutableList<ImageView>, point:Int, ima: ImageView, context: Context, tag:String, pendingComparisonDataList:MutableList<PendingComparisonData>){

    var my_animation =  AnimationUtils.loadAnimation(context, R.anim.back)

    my_animation.setAnimationListener(object: Animation.AnimationListener{
    override fun onAnimationEnd(animation: Animation?) {

      if(tag == "back"){

        when(ima.tag.toString()){

          "one" ->{

              carTagManager.set_ima_one_tag("front")

              my_animation = AnimationUtils.loadAnimation(context,R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "two" ->{

              carTagManager.set_ima_two_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "three"->{

              carTagManager.set_ima_three_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "four"->{

              carTagManager.set_ima_four_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "five"->{

              carTagManager.set_ima_five_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point ))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)
          }

          "six"->{

              carTagManager.set_ima_six_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "seven"->{

              carTagManager.set_ima_seven_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "eight"->{

              carTagManager.set_ima_eight_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "nine"->{

              carTagManager.set_ima_nine_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "ten"->{


              carTagManager.set_ima_ten_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point ))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)


          }

          "eleven"->{

              carTagManager.set_ima_eleven_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

          }

          "twelve"->{

              carTagManager.set_ima_twelve_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              pendingComparisonDataList.add(PendingComparisonData(ima,point  ))

              compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)


          }


        }





      }

      if(tag == "front"){


          when(ima.tag.toString()){

              "one" ->{

                  carTagManager.set_ima_one_tag("back")

              }

              "two" ->{

                  carTagManager.set_ima_two_tag("back")

              }

              "three"->{

                  carTagManager.set_ima_three_tag("back")

              }

              "four"->{

                  carTagManager.set_ima_four_tag("back")

              }

              "five"->{

                  carTagManager.set_ima_five_tag("back")

              }

              "six"->{

                  carTagManager.set_ima_six_tag("back")

              }

              "seven"->{

                  carTagManager.set_ima_seven_tag("back")

              }

              "eight"->{

                  carTagManager.set_ima_eight_tag("back")

              }

              "nine"->{

                  carTagManager.set_ima_nine_tag("back")

              }

              "ten"->{


                  carTagManager.set_ima_ten_tag("back")


              }

              "eleven"->{

                  carTagManager.set_ima_eleven_tag("back")

              }

              "twelve"->{

                  carTagManager.set_ima_twelve_tag("back")


              }


          }

          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

          ima.startAnimation(my_animation)


      }

    }

    override fun onAnimationRepeat(animation: Animation?) {



    }

    override fun onAnimationStart(animation: Animation?) {



    }


  })



  ima.startAnimation(my_animation)

}

  fun rotateCardUpright(unmatchedDataList:MutableList<ImageView>, selectedImages:MutableList<ImageView>, point:Int, ima: ImageView, context: Context, pendingComparisonDataList:MutableList<PendingComparisonData>){

      var my_animation =  AnimationUtils.loadAnimation(context, R.anim.back)

      my_animation.setAnimationListener(object: Animation.AnimationListener{
          override fun onAnimationEnd(animation: Animation?) {

                  when(ima.tag.toString()){

                      "one" ->{

                          carTagManager.set_ima_one_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context,R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "two" ->{

                          carTagManager.set_ima_two_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "three"->{

                          carTagManager.set_ima_three_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "four"->{

                          carTagManager.set_ima_four_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "five"->{

                          carTagManager.set_ima_five_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point ))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)
                      }

                      "six"->{

                          carTagManager.set_ima_six_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "seven"->{

                          carTagManager.set_ima_seven_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "eight"->{

                          carTagManager.set_ima_eight_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "nine"->{

                          carTagManager.set_ima_nine_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "ten"->{


                          carTagManager.set_ima_ten_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point ))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)


                      }

                      "eleven"->{

                          carTagManager.set_ima_eleven_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)

                      }

                      "twelve"->{

                          carTagManager.set_ima_twelve_tag("front")

                          my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                          ima.startAnimation(my_animation)

                          pendingComparisonDataList.add(PendingComparisonData(ima,point  ))

                          compare (pendingComparisonDataList,context,unmatchedDataList,selectedImages)


                      }


                  }




          }

          override fun onAnimationRepeat(animation: Animation?) {



          }

          override fun onAnimationStart(animation: Animation?) {



          }


      })



      ima.startAnimation(my_animation)

  }

  fun rotateCardUpsideDown(ima: ImageView, context: Context){

      var my_animation =  AnimationUtils.loadAnimation(context, R.anim.back)

      my_animation.setAnimationListener(object: Animation.AnimationListener{
          override fun onAnimationEnd(animation: Animation?) {



                  when(ima.tag.toString()){

                      "one" ->{

                          carTagManager.set_ima_one_tag("back")

                      }

                      "two" ->{

                          carTagManager.set_ima_two_tag("back")

                      }

                      "three"->{

                          carTagManager.set_ima_three_tag("back")

                      }

                      "four"->{

                          carTagManager.set_ima_four_tag("back")

                      }

                      "five"->{

                          carTagManager.set_ima_five_tag("back")

                      }

                      "six"->{

                          carTagManager.set_ima_six_tag("back")

                      }

                      "seven"->{

                          carTagManager.set_ima_seven_tag("back")

                      }

                      "eight"->{

                          carTagManager.set_ima_eight_tag("back")

                      }

                      "nine"->{

                          carTagManager.set_ima_nine_tag("back")

                      }

                      "ten"->{


                          carTagManager.set_ima_ten_tag("back")


                      }

                      "eleven"->{

                          carTagManager.set_ima_eleven_tag("back")

                      }

                      "twelve"->{

                          carTagManager.set_ima_twelve_tag("back")


                      }


                  }

                  my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

                  ima.startAnimation(my_animation)




          }

          override fun onAnimationRepeat(animation: Animation?) {



          }

          override fun onAnimationStart(animation: Animation?) {



          }


      })



      ima.startAnimation(my_animation)

  }

}

