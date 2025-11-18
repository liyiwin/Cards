package com.example.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.cards.databinding.ActivityMainBinding
import com.example.cards.ui_model.ImageData
import com.example.cards.ui_operation.UiOperationsManager


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    private lateinit var uiOperationsManager: UiOperationsManager
    private lateinit var uiLogicDelegate:UiLogicDelegate

    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        uiOperationsManager = UiOperationsManager(this,binding)
        uiLogicDelegate = UiLogicDelegate(viewModel,viewModel,uiOperationsManager)
        uiLogicDelegate.performCreate()
    }



}
