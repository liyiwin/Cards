package com.example.cards.domain.di_module

import com.example.cards.domain.CardNumberUseCase
import com.example.cards.domain.ICardNumberUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class FeatureModule {

    @Provides
    fun provideCardNumberUseCase(): ICardNumberUseCase {
        return CardNumberUseCase()
    }

}