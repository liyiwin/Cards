package com.example.cards.domain

class CarNumberUseCase :ICarNumberUseCase{

    var a = 6

    var b = 12 // 用來記positionsize

    var c = 13  // 用來記numbersize

// 藉position 取值

// 數字序列

    var number_list = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13)

// 撲克序列

    var position_list = mutableListOf<Int>(0,1,2,3,4,5,6,7,8,9,10,11)

    val my_endlist = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0)

    var my_number_position = 0

    var my_position = 0

    var my_position_two = 0

    var my_number = 0

    var position_one = 0

    var position_two = 0



    private  fun random_list_position (){

        val number = number_list.size

        my_number_position = (Math.random() * number).toInt()

        my_number = number_list[my_number_position]

        number_list.remove(my_number)


    }

   private fun random_position(){

        val number = position_list.size

        my_position =  (Math.random() * number).toInt()

        my_position_two =   (Math.random() * number).toInt()

        while (my_position == my_position_two){

            my_position_two =  (Math.random() * number).toInt()

        }

        position_one = position_list[my_position]

        position_two = position_list[my_position_two]

        position_list.remove(position_one)

        position_list.remove(position_two)



    }

    override fun transform (list: MutableList<Int>){

        while(a > 0){

            random_list_position ()

            random_position()

            my_endlist[position_one] = my_number

            my_endlist[position_two] = my_number

            a = a-1

            if(a == 0){

                list .addAll(my_endlist)

            }

        }

    }
}