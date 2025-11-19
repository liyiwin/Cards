package com.example.cards.domain

import com.example.cards.domain.model.CarNumberCalculationModel

class CardNumberUseCase :ICardNumberUseCase{


    private  fun random_list_position (calculationModel: CarNumberCalculationModel){

        val number = calculationModel.number_list.size

        calculationModel.my_number_position = (Math.random() * number).toInt()

        calculationModel.my_number = calculationModel.number_list[calculationModel.my_number_position]

        calculationModel.number_list.remove(calculationModel.my_number)


    }

   private fun random_position(calculationModel: CarNumberCalculationModel){

        val number = calculationModel.position_list.size

       calculationModel.my_position =  (Math.random() * number).toInt()

       calculationModel.my_position_two =   (Math.random() * number).toInt()

        while (calculationModel.my_position == calculationModel.my_position_two){

            calculationModel.my_position_two =  (Math.random() * number).toInt()

        }

       calculationModel.position_one = calculationModel.position_list[calculationModel.my_position]

       calculationModel.position_two = calculationModel.position_list[calculationModel.my_position_two]

       calculationModel.position_list.remove(calculationModel.position_one)

       calculationModel. position_list.remove(calculationModel.position_two)



    }

    override fun transform (list: MutableList<Int>,calculationModel: CarNumberCalculationModel){

        while(calculationModel.a > 0){

            random_list_position (calculationModel)

            random_position(calculationModel)

            calculationModel.my_endlist[calculationModel.position_one] = calculationModel.my_number

            calculationModel.my_endlist[calculationModel.position_two] = calculationModel.my_number

            calculationModel.a = calculationModel.a-1

            if(calculationModel.a == 0){

                list .addAll(calculationModel.my_endlist)

            }

        }

    }
}