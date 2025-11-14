package com.example.cards

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast

fun set_disable(image_list: MutableList<ImageView>){

    val my_list = mutableListOf<ImageView>()

    my_list.addAll(image_list)

//    my_list.removeAll(colleted_list)

    for (i in 0 until my_list.size){

        my_list[i].isEnabled  = false

    }
}


fun set_enable(image_list: MutableList<ImageView>,collected_image: MutableList<ImageView>, list: MutableList<Compared_data> ){

    val my_list = mutableListOf<ImageView>()

     my_list.addAll(image_list)

    if (list.size == 2){

        collected_image.clear()

        if (collected_image.size == 0){

            for (i in 0 until my_list.size){

                my_list[i].isEnabled  = true

            }

        }



    }


}



fun compare (list: MutableList<Compared_data>,context: Context,viewModel: ViewModel,image_list: MutableList<ImageView>,collected_image: MutableList<ImageView>) {

    if (list.size == 2 ){

    val this_list = mutableListOf<Compared_data>()

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



fun shake(ima: ImageView,point:Int,context:Context,tag: String,viewModel: ViewModel,list: MutableList<Compared_data>,image_list: MutableList<ImageView>,collected_image: MutableList<ImageView>,flag:String) {


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





fun disappear (list: MutableList<Compared_data>,image_list: MutableList<ImageView>,collected_image: MutableList<ImageView>,ima: ImageView,context:Context,flag:String){

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




fun animation(imagelist:MutableList<ImageView>,collected_image:MutableList<ImageView>,point:Int,ima: ImageView,context: Context,viewModel:ViewModel,tag:String,list:MutableList<Compared_data>){

  var my_animation =  AnimationUtils.loadAnimation(context, R.anim.back)

    my_animation.setAnimationListener(object: Animation.AnimationListener{
    override fun onAnimationEnd(animation: Animation?) {

      if(tag == "back"){

        when(ima.tag.toString()){

          "one" ->{

            viewModel.set_ima_one_tag("front")

              my_animation = AnimationUtils.loadAnimation(context,R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "two" ->{

            viewModel.set_ima_two_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "three"->{

            viewModel.set_ima_three_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "four"->{

            viewModel.set_ima_four_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "five"->{

            viewModel.set_ima_five_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)
          }

          "six"->{

            viewModel.set_ima_six_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "seven"->{

            viewModel.set_ima_seven_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "eight"->{

              viewModel.set_ima_eight_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "nine"->{

              viewModel.set_ima_nine_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "ten"->{


            viewModel.set_ima_ten_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)


          }

          "eleven"->{

            viewModel.set_ima_eleven_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

              compare (list,context,viewModel,imagelist,collected_image)

          }

          "twelve"->{

           viewModel.set_ima_twelve_tag("front")

              my_animation = AnimationUtils.loadAnimation(context, R.anim.font)

              ima.startAnimation(my_animation)

              list.add(Compared_data(ima,point,"front"  ))

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

fun set_mycard_Image(ima:ImageView,number:Int){

when(number){

    1 ->{

        ima.setImageResource(R.drawable.a)

    }
    2 ->{

        ima.setImageResource(R.drawable.two)

    }
    3->{

        ima.setImageResource(R.drawable.three)

    }
    4->{

        ima.setImageResource(R.drawable.four)

    }
    5->{

        ima.setImageResource(R.drawable.five)

    }
    6->{

        ima.setImageResource(R.drawable.six)

    }
    7->{

        ima.setImageResource(R.drawable.seven)

    }
    8->{

        ima.setImageResource(R.drawable.eight)

    }
    9->{

        ima.setImageResource(R.drawable.nine)

    }
    10->{

        ima.setImageResource(R.drawable.ten)

    }
    11->{

        ima.setImageResource(R.drawable.eleven)

    }
    12->{

        ima.setImageResource(R.drawable.twelve)

    }
    13->{

        ima.setImageResource(R.drawable.thirteen)

    }


}


}