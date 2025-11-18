package com.example.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.cards.databinding.ActivityMainBinding
import com.example.cards.ui_operation.UiOperationsManager
import com.example.cards.utils.TimerUtils


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    private lateinit var uiOperationsManager: UiOperationsManager
    private lateinit var uiLogicDelegate:UiLogicDelegate

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        uiOperationsManager = UiOperationsManager(this,binding,mainViewModel,this)
        uiLogicDelegate = UiLogicDelegate(uiOperationsManager,TimerUtils())
        uiLogicDelegate.performCreate()
    }



}
