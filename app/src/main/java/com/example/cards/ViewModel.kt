package com.example.cards

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ViewModel(app: Application): AndroidViewModel(app) , ICardTagManager,IUnMatchedDataManger {

    val ima_one_tag = MutableLiveData<String>()

    val ima_two_tag = MutableLiveData<String>()

    val ima_three_tag = MutableLiveData<String>()

    val ima_four_tag = MutableLiveData<String>()

    val ima_five_tag = MutableLiveData<String>()

    val ima_six_tag = MutableLiveData<String>()

    val ima_seven_tag = MutableLiveData<String>()

    val ima_eight_tag = MutableLiveData<String>()

    val ima_nine_tag = MutableLiveData<String>()

    val ima_ten_tag = MutableLiveData<String>()

    val ima_eleven_tag = MutableLiveData<String>()

    val ima_twelve_tag = MutableLiveData<String>()

    val unMatchedData_IsLocked = MutableLiveData<Boolean>()


    override fun set_ima_one_tag(tag:String){

        ima_one_tag.value = tag
    }


    override fun set_ima_two_tag(tag:String){

        ima_two_tag.value = tag

    }

    override fun set_ima_three_tag(tag:String){

        ima_three_tag.value = tag


    }


    override fun set_ima_four_tag(tag:String){
        ima_four_tag.value = tag

    }


    override fun set_ima_five_tag(tag:String){

        ima_five_tag.value = tag


    }

    override fun set_ima_six_tag(tag:String){

        ima_six_tag.value =tag


    }

    override fun set_ima_seven_tag(tag:String){

        ima_seven_tag.value= tag

    }

    override fun set_ima_eight_tag(tag:String){

        ima_eight_tag.value = tag

    }


    override fun set_ima_nine_tag(tag:String){

        ima_nine_tag.value = tag

    }

    override fun set_ima_ten_tag(tag:String){

        ima_ten_tag.value = tag


    }

    override fun set_ima_eleven_tag(tag:String){

        ima_eleven_tag.value = tag

    }

    override fun set_ima_twelve_tag(tag:String){

         ima_twelve_tag.value = tag

    }

    fun getImageTag(imageName:String): MutableLiveData<String> {
        return when(imageName){
            "imageViewOne" -> ima_one_tag
            "imageViewTwo" -> ima_two_tag
            "imageViewThree" -> ima_three_tag
            "imageViewFour"->  ima_four_tag
            "imageViewFive"-> ima_five_tag
            "imageViewSix"-> ima_six_tag
            "imageViewSeven"-> ima_seven_tag
            "imageViewEight"-> ima_eight_tag
            "imageViewNine"-> ima_nine_tag
            "imageViewTen"-> ima_ten_tag
            "imageViewEleven"-> ima_eleven_tag
            else ->  ima_twelve_tag
        }
    }

    override fun lockUnMatchedData() {
        unMatchedData_IsLocked.value = true
    }

    override fun unlLockUnMatchedData() {
        unMatchedData_IsLocked.value = false
    }

    fun getUnMatchedDataIsLocked():MutableLiveData<Boolean>{
        return unMatchedData_IsLocked
    }


}