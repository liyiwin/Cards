package com.example.cards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cards.ui_model.CardDetail
import com.example.cards.ui_model.UiEvent
import com.example.cards.ui_model.ViewModelEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val pendingComparisonDataList = mutableListOf<CardDetail>()
    private var unmatchedDataList = mutableListOf<CardDetail>()
    private var selectedImages = mutableListOf<CardDetail>()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent get() = _uiEvent

    private val _viewModelEvent = MutableSharedFlow<ViewModelEvent>()

    init {
        val cardList = createCardList();
        unmatchedDataList.addAll(cardList)
        viewModelScope.launch {
            _viewModelEvent.collect { event ->
                launch {
                    when(event){
                        is ViewModelEvent.CardSelectionViewModelEvent -> selectCard(cardList[event.index])
                    }
                }
            }
        }

    }


    fun sendViewModelEvent(viewModelEvent: ViewModelEvent){
        viewModelScope.launch{
            _viewModelEvent.emit(viewModelEvent)
        }
    }


    private suspend fun selectCard(card:CardDetail){
        _uiEvent.emit(UiEvent.LockCardUiEvent(card.imageName))
        selectedImages.add(card)
        if (selectedImages.size == 2)  _uiEvent.emit(UiEvent.LockAllUnMatchedCardUiEvent(unmatchedDataList.toList()))
        _uiEvent.emit(UiEvent.PerformBackAnimation (card.imageName){
            viewModelScope.launch {
                _uiEvent.emit(UiEvent.RenderCardFront(card.imageName,card.point))
                _uiEvent.emit(UiEvent.PerformFrontAnimation(card.imageName))
                addPendingCard(card)
            }
        })
    }

    private  suspend fun addPendingCard(card:CardDetail){
        pendingComparisonDataList.add(card)
        if (pendingComparisonDataList.size == 2 ) {
            compare (pendingComparisonDataList[0],pendingComparisonDataList[1])
            pendingComparisonDataList.clear()
        }
    }

    private  suspend fun compare (cardOne:CardDetail,cardTwo:CardDetail) {

        if(cardOne.point == cardTwo.point) {
            delay(2000L)
            disappear(  cardOne,cardTwo, "one")
            disappear(  cardTwo,cardOne, "two")
        }else {
            shake(cardOne, "one")
            shake(cardTwo, "two")
        }
    }


    private  suspend fun shake(ima: CardDetail, flag:String) {
        _uiEvent.emit(UiEvent.PerformShackAnimation(ima.imageName){
            viewModelScope.launch {
                rotateCardUpsideDown(ima,flag)
            }
        })

    }


    private suspend fun disappear (ima: CardDetail, pairedImage:CardDetail, flag:String){
        _uiEvent.emit(UiEvent.PerformDisappearAnimation(ima.imageName){
            viewModelScope.launch {
                // flag two 代表動畫完成
                _uiEvent.emit(UiEvent.LockCardUiEvent(ima.imageName))
                if (flag == "two"){
                    unmatchedDataList.remove(ima)
                    unmatchedDataList.remove(pairedImage)
                    set_enable()
                    if (unmatchedDataList.size  == 0 ){
                        _uiEvent.emit(UiEvent.Toast("遊戲完成"))
                    }
                }
            }
        })
    }

    private  suspend fun rotateCardUpsideDown(card: CardDetail, flag:String){
        _uiEvent.emit(UiEvent.PerformBackAnimation(card.imageName){
            viewModelScope.launch {
                _uiEvent.emit(UiEvent.RenderCardBack(card.imageName))
                _uiEvent.emit(UiEvent.PerformFrontAnimation(card.imageName))
                // flag two 代表動畫完成
                if (flag == "two"){
                    set_enable()
                }
            }
        })

    }

    private suspend fun set_enable( ){
        selectedImages.clear()
        _uiEvent.emit(UiEvent.UnLockAllUnMatchedCardUiEvent(unmatchedDataList.toList()))
   }

    private fun createCardList():MutableList<CardDetail>{
        val cards  = mutableListOf<CardDetail>()
        val numberLis = mutableListOf<Int>()
        transform(numberLis)
        cards.add(CardDetail("imageViewOne",numberLis[0]))
        cards.add(CardDetail("imageViewTwo",numberLis[1]))
        cards.add(CardDetail("imageViewThree",numberLis[2]))
        cards.add(CardDetail("imageViewFour",numberLis[3]))
        cards.add(CardDetail("imageViewFive",numberLis[4]))
        cards.add(CardDetail("imageViewSix",numberLis[5]))
        cards.add(CardDetail("imageViewSeven",numberLis[6]))
        cards.add(CardDetail("imageViewEight",numberLis[7]))
        cards.add(CardDetail("imageViewNine",numberLis[8]))
        cards.add(CardDetail("imageViewTen",numberLis[9]))
        cards.add(CardDetail("imageViewEleven",numberLis[10]))
        cards.add(CardDetail("imageViewTwelve",numberLis[11]))
        return cards;
    }

}