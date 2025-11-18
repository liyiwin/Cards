package com.example.cards.domain

interface ICarNumberUseCase {
    fun transform (list: MutableList<Int>)
}