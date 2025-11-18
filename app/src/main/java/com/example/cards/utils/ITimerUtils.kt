package com.example.cards.utils

interface ITimerUtils {
    fun delayTask(delayTime:Long,callback:()->Unit)
}