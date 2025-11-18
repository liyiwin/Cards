package com.example.cards.utils

import java.util.Timer
import java.util.TimerTask

class TimerUtils :ITimerUtils{

      override fun delayTask(delayTime:Long,callback:()->Unit) {
          val timer = Timer()
          timer.schedule(object : TimerTask(){
              override fun run() {
                  callback.invoke()
              }

          },delayTime)
      }

}