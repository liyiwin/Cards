package com.example.cards

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ViewModel(app: Application): AndroidViewModel(app) , ICardTagManager {

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


    override fun set_ima_one_tag(tag:String){

        ima_one_tag.value = tag
    }

    fun get_ima_one_tag():MutableLiveData<String>{

        return ima_one_tag

    }

    override fun set_ima_two_tag(tag:String){

        ima_two_tag.value = tag

    }

    fun get_ima_two_tag():MutableLiveData<String>{

        return ima_two_tag

    }



    override fun set_ima_three_tag(tag:String){

        ima_three_tag.value = tag


    }

    fun get_ima_three_tag():MutableLiveData<String>{

        return ima_three_tag

    }

    override fun set_ima_four_tag(tag:String){
        ima_four_tag.value = tag

    }

    fun get_ima_four_tag():MutableLiveData<String>{

        return ima_four_tag

    }

    override fun set_ima_five_tag(tag:String){

        ima_five_tag.value = tag


    }

    fun get_ima_five_tag():MutableLiveData<String>{

        return ima_five_tag

    }

    override fun set_ima_six_tag(tag:String){

        ima_six_tag.value =tag


    }

    fun get_ima_six_tag():MutableLiveData<String>{

        return ima_six_tag

    }

    override fun set_ima_seven_tag(tag:String){

        ima_seven_tag.value= tag

    }

    fun get_ima_seven_tag():MutableLiveData<String>{

        return ima_seven_tag

    }

    override fun set_ima_eight_tag(tag:String){

        ima_eight_tag.value = tag

    }

    fun get_ima_eight_tag():MutableLiveData<String>{

        return ima_eight_tag

    }

    override fun set_ima_nine_tag(tag:String){

        ima_nine_tag.value = tag

    }

    fun get_ima_nine_tag():MutableLiveData<String>{

        return ima_nine_tag

    }
    override fun set_ima_ten_tag(tag:String){

        ima_ten_tag.value = tag


    }

    fun get_ima_ten_tag():MutableLiveData<String>{

        return ima_ten_tag

    }

    override fun set_ima_eleven_tag(tag:String){

        ima_eleven_tag.value = tag

    }

    fun get_ima_eleven_tag():MutableLiveData<String>{

        return ima_eleven_tag

    }

    override fun set_ima_twelve_tag(tag:String){

         ima_twelve_tag.value = tag

    }

    fun get_ima_twelve_tag():MutableLiveData<String>{

        return ima_twelve_tag

    }



}