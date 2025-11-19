package com.example.cards.domain

import com.example.cards.domain.model.CardNumberCalculationModel

interface ICardNumberUseCase {
    fun transform (list: MutableList<Int>,calculationModel: CardNumberCalculationModel)
}