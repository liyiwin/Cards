package com.example.cards.domain.model

class CarNumberCalculationModel {

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

}