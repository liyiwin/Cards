package com.example.cards.domain

import com.example.cards.domain.model.CarNumberCalculationModel

interface ICarNumberUseCase {
    fun transform (list: MutableList<Int>,calculationModel: CarNumberCalculationModel)
}