package com.example.cards.ui_operation

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.cards.R

class UiOperationsManager(private val activity:AppCompatActivity) {

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


    fun set_disable(image_list: MutableList<ImageView>){

        val my_list = mutableListOf<ImageView>()

        my_list.addAll(image_list)

//    my_list.removeAll(colleted_list)

        for (i in 0 until my_list.size){

            my_list[i].isEnabled  = false

        }
    }
}