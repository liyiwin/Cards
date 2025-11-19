package com.example.cards.domain

import com.example.cards.domain.model.CarNumberCalculationModel

interface ICardNumberUseCase {
    fun transform (list: MutableList<Int>,calculationModel: CarNumberCalculationModel)
}