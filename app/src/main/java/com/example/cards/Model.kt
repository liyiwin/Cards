package com.example.cards

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast




fun set_enable(image_list: MutableList<ImageView>,collected_image: MutableList<ImageView>, list: MutableList<PendingComparisonData> ){

    if (list.size == 2){

        collected_image.clear()

        for (i in 0 until image_list.size){

            image_list[i].isEnabled  = true

        }

    }

}



fun compare (list: MutableList<PendingComparisonData>, context: Context, viewModel: ViewModel, image_list: MutableList<ImageView>, collected_image: MutableList<ImageView>) {

    if (list.size == 2 ){

    val this_list = mutableListOf<PendingComparisonData>()

    this_list.addAll(list)

    list.clear()

    val ima_one = this_list[0].ima
    val ima_two = this_list[1].ima
    val point_one = this_list[0].point
    val point_two = this_list[1].point

    when {

        point_one != point_two -> {

            shake(ima_one, point_one, context, "front", viewModel, this_list, image_list,collected_image, "one")

            shake(ima_two, point_two, context, "front", viewModel, this_list, image_list,collected_image, "two")


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

                        disappear(this_list, image_list,collected_image, ima_one, context, "one")

                        disappear(this_list, image_list,collected_image, ima_two, context, "two")

                    }


                }


            }
            handler.postDelayed(runnable,1000)

        }

    }

}

}



fun shake(ima: ImageView, point:Int, context:Context, tag: String, viewModel: ViewModel, list: MutableList<PendingComparisonData>, image_list: MutableList<ImageView>, collected_image: MutableList<ImageView>, flag:String) {


val animation = AnimationUtils.loadAnimation(context,R.anim.shake)

    animation.setAnimationListener(object:Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {

            animation(image_list,collected_image,point,ima,context,viewModel,tag,list)

            // flag two 代表動畫完成

            if (flag == "two"){

                set_enable(image_list,collected_image, list )

            }

        }

        override fun onAnimationStart(animation: Animation?) {

        }


    })


ima.startAnimation(animation)

}





fun disappear (list: MutableList<PendingComparisonData>, image_list: MutableList<ImageView>, collected_image: MutableList<ImageView>, ima: ImageView, context:Context, flag:String){

    val animation = AnimationUtils.loadAnimation(context,R.anim.disappear)

    animation.setAnimationListener(object:Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {

            ima.isEnabled = false

            // flag two 代表動畫完成

            if (flag == "two"){

                val ima_one = list[0].ima

                val ima_two = list[1].ima

                image_list.remove(ima_one)

                image_list.remove(ima_two)

                set_enable(image_list,collected_image, list)

                if (image_list.size  == 0 ){

                    Toast.makeText(context,"遊戲完成",Toast.LENGTH_LONG).show()

                }

            }


        }

        override fun onAnimationStart(animation: Animation?) {

        }

    })

    ima.startAnimation(animation)


}




fun animation(imagelist:MutableList<ImageView>,collected_image:MutableList<ImageView>,point:Int,ima: ImageView,context: Context,viewModel:ViewModel,tag:String,list:MutableList<PendingComparisonData>){

    var my_animation =  AnimationUtils.loadAnimation(context, R.anim.back)

    my_animation.setAnimationListener(object: Animation.AnimationListener{
    override fun onAnimationEnd(animation: Animation?) {

      if(tag == "back"){

        when(ima.tag.toString()){

          "one" ->{

            viewModel.set_ima_one_tag("front")

              my_animation = AnimationUtils.loadAnimation(context,R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "two" ->{

            viewModel.set_ima_two_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "three"->{

            viewModel.set_ima_three_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "four"->{

            viewModel.set_ima_four_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "five"->{

            viewModel.set_ima_five_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)
          }

          "six"->{

            viewModel.set_ima_six_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "seven"->{

            viewModel.set_ima_seven_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "eight"->{

              viewModel.set_ima_eight_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "nine"->{

              viewModel.set_ima_nine_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "ten"->{


            viewModel.set_ima_ten_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)


          }

          "eleven"->{

            viewModel.set_ima_eleven_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "twelve"->{

           viewModel.set_ima_twelve_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(PendingComparisonData(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)


          }


        }





      }

      if(tag == "front"){


          when(ima.tag.toString()){

              "one" ->{

                  viewModel.set_ima_one_tag("back")

              }

              "two" ->{

                  viewModel.set_ima_two_tag("back")

              }

              "three"->{

                  viewModel.set_ima_three_tag("back")

              }

              "four"->{

                  viewModel.set_ima_four_tag("back")

              }

              "five"->{

                  viewModel.set_ima_five_tag("back")

              }

              "six"->{

                  viewModel.set_ima_six_tag("back")

              }

              "seven"->{

                  viewModel.set_ima_seven_tag("back")

              }

              "eight"->{

                  viewModel.set_ima_eight_tag("back")

              }

              "nine"->{

                  viewModel.set_ima_nine_tag("back")

              }

              "ten"->{


                  viewModel.set_ima_ten_tag("back")


              }

              "eleven"->{

                  viewModel.set_ima_eleven_tag("back")

              }

              "twelve"->{

                  viewModel.set_ima_twelve_tag("back")


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
