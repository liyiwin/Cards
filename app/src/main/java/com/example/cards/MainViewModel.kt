package com.example.cards

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cards.ui_model.UiEvent
import com.example.cards.ui_model.ViewModelEvent
import kotlinx.coroutines.flow.MutableSharedFlow

class MainViewModel: ViewModel() {

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

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent get() = _uiEvent

    private val _viewModelEvent = MutableSharedFlow<ViewModelEvent>()

    fun setImageTag(imageName:String,tag: String){
        when(imageName){
            "imageViewOne" -> ima_one_tag.value = tag
            "imageViewTwo" -> ima_two_tag.value = tag
            "imageViewThree" -> ima_three_tag.value = tag
            "imageViewFour"->  ima_four_tag.value = tag
            "imageViewFive"-> ima_five_tag.value = tag
            "imageViewSix"-> ima_six_tag.value = tag
            "imageViewSeven"-> ima_seven_tag.value = tag
            "imageViewEight"-> ima_eight_tag.value = tag
            "imageViewNine"-> ima_nine_tag.value = tag
            "imageViewTen"-> ima_ten_tag.value = tag
            "imageViewEleven"-> ima_eleven_tag.value = tag
            else ->  ima_twelve_tag.value = tag
        }
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

    fun lockUnMatchedData() {
        unMatchedData_IsLocked.value = true
    }

    fun unlLockUnMatchedData() {
        unMatchedData_IsLocked.value = false
    }

    fun getUnMatchedDataIsLocked():MutableLiveData<Boolean>{
        return unMatchedData_IsLocked
    }


}