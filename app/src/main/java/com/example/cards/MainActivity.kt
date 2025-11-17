package com.example.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.cards.databinding.ActivityMainBinding
import com.example.cards.ui_operation.UiOperationsManager


class MainActivity : AppCompatActivity() {



    private var pendingComparisonDataList = mutableListOf<PendingComparisonData>()

    private var selectedImages = mutableListOf<ImageView>()

    private var list = mutableListOf<Int>()

    private var unmatchedDataList = mutableListOf<ImageView>()

    var tag_one  = "back"

    var tag_two  = "back"

    var tag_three  = "back"

    var tag_four  = "back"

    var tag_five  = "back"

    var tag_six  = "back"

    var tag_seven  = "back"

    var tag_eight  = "back"

    var tag_nine  = "back"

    var tag_ten  = "back"

    var tag_eleven  = "back"

    var tag_twelve  = "back"

    private lateinit var binding: ActivityMainBinding
    private lateinit var uiOperationsManager: UiOperationsManager
    private lateinit var uiLogicDelegate:UiLogicDelegate

    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        uiOperationsManager = UiOperationsManager(this)
        uiLogicDelegate = UiLogicDelegate(viewModel)
        add_Image_into_list(unmatchedDataList)

        transform(list)


        // tag_one

        val tag_one_Observer = Observer<String>{

            tag_one = it

            if (it == "front"){

                val number = list[0]

                uiOperationsManager.set_mycard_Image(binding.imageViewOne,number)

            }

            if (it == "back"){

                binding.imageViewOne.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_one_tag().observe(this,tag_one_Observer)

        // tag_two

        val tag_two_Observer = Observer<String>{

            tag_two = it

            if (it == "front"){

                val number = list[1]

                uiOperationsManager.set_mycard_Image(binding.imageViewTwo,number)
            }

            if (it == "back"){

                binding.imageViewTwo.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_two_tag().observe(this,tag_two_Observer)

        // tag_three

        val tag_three_Observer = Observer<String>{

            tag_three = it

            if (it == "front"){

                val number = list[2]

                uiOperationsManager.set_mycard_Image(binding.imageViewThree,number)
            }

            if (it == "back"){

                binding.imageViewThree.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_three_tag().observe(this,tag_three_Observer)

        // tag_four

        val tag_four_Observer = Observer<String>{

            tag_four =it

            if (it == "front"){

                val number = list[3]

                uiOperationsManager.set_mycard_Image(binding.imageViewFour,number)
            }

            if (it == "back"){

                binding.imageViewFour.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_four_tag().observe(this,tag_four_Observer)

        // tag_five

        val tag_five_Observer = Observer<String>{

            tag_five =it

            if (it == "front"){

                val number = list[4]

                uiOperationsManager.set_mycard_Image(binding.imageViewFive,number)
            }

            if (it == "back"){

                binding.imageViewFive.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_five_tag().observe(this,tag_five_Observer)

        // tag_six

        val tag_six_Observer = Observer<String>{

            tag_six = it

            if (it == "front"){

                val number = list[5]

                uiOperationsManager.set_mycard_Image(binding.imageViewSix,number)
            }

            if (it == "back"){

                binding.imageViewSix.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_six_tag().observe(this,tag_six_Observer)

        // tag_seven

        val tag_seven_Observer = Observer<String>{

            tag_seven = it

            if (it == "front"){

                val number = list[6]

                uiOperationsManager.set_mycard_Image(binding.imageViewSeven,number)
            }

            if (it == "back"){

                binding.imageViewSeven.setImageResource(R.drawable.background)

            }


        }

        viewModel.get_ima_seven_tag().observe(this,tag_seven_Observer)



        // tag_eight

        val tag_eight_Observer = Observer<String>{

            tag_eight = it

            if (it == "front"){

                val number = list[7]

                uiOperationsManager.set_mycard_Image(binding.imageViewEight,number)
            }

            if (it == "back"){

                binding.imageViewEight.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_eight_tag().observe(this,tag_eight_Observer)

        // tag_nine

        val tag_nine_Observer = Observer<String>{

            tag_nine = it

            if (it == "front"){

                val number = list[8]

                uiOperationsManager.set_mycard_Image(binding.imageViewNine,number)
            }

            if (it == "back"){

                binding.imageViewNine.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_nine_tag().observe(this,tag_nine_Observer)

        // tag_ten

        val tag_ten_Observer = Observer<String>{

            tag_ten = it

            if (it == "front"){

                val number = list[9]

                uiOperationsManager.set_mycard_Image(binding.imageViewTen,number)
            }

            if (it == "back"){

                binding.imageViewTen.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_ten_tag().observe(this,tag_ten_Observer)

        // tag_eleven

        val tag_eleven_Observer = Observer<String>{

            tag_eleven = it

            if (it == "front"){

                val number = list[10]

                uiOperationsManager.set_mycard_Image(binding.imageViewEleven,number)
            }

            if (it == "back"){

                binding.imageViewEleven.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_eleven_tag().observe(this,tag_eleven_Observer)


        // tag_twelve

        val tag_twelve_Observer = Observer<String>{

            tag_twelve = it

            if (it == "front"){

                val number = list[11]

                uiOperationsManager.set_mycard_Image(binding.imageViewTwelve,number)
            }

            if (it == "back"){

                binding.imageViewTwelve.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_twelve_tag().observe(this,tag_twelve_Observer)


        binding. imageViewOne.setOnClickListener {

            binding.imageViewOne.isEnabled = false

            selectedImages.add(binding.imageViewOne)

           if (selectedImages.size == 2){

               uiOperationsManager.set_disable(unmatchedDataList)

           }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[0],binding.imageViewOne,this,tag_one,pendingComparisonDataList)

        }


        binding.imageViewTwo.setOnClickListener {

            binding.imageViewTwo.isEnabled = false

            selectedImages.add(binding.imageViewTwo)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[1],binding.imageViewTwo,this,tag_two,pendingComparisonDataList)


        }

        binding.imageViewThree.setOnClickListener {

            binding.imageViewThree.isEnabled = false

            selectedImages.add(binding.imageViewThree)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )



            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[2],binding.imageViewThree,this,tag_three,pendingComparisonDataList)


        }

        binding.imageViewFour.setOnClickListener {

            binding.imageViewFour.isEnabled = false

            selectedImages.add(binding.imageViewFour)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )


            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[3],binding.imageViewFour,this,tag_four,pendingComparisonDataList)

        }

        binding.imageViewFive.setOnClickListener {

            binding.imageViewFive.isEnabled = false

            selectedImages.add(binding.imageViewFive)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[4],binding.imageViewFive,this,tag_five,pendingComparisonDataList)



        }

        binding.imageViewSix.setOnClickListener {

            binding.imageViewSix.isEnabled = false

            selectedImages.add(binding.imageViewSix)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )


            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[5],binding.imageViewSix,this,tag_six,pendingComparisonDataList)

        }

        binding.imageViewSeven.setOnClickListener {

            binding.imageViewSeven.isEnabled = false

            selectedImages.add(binding.imageViewSeven)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[6],binding.imageViewSeven,this,tag_seven,pendingComparisonDataList)

        }

        binding.imageViewEight.setOnClickListener {

            binding.imageViewEight.isEnabled = false

            selectedImages.add(binding.imageViewEight)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[7],binding.imageViewEight,this,tag_eight,pendingComparisonDataList)

        }

        binding.imageViewNine.setOnClickListener {

            binding.imageViewNine.isEnabled = false

            selectedImages.add(binding.imageViewNine)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[8],binding.imageViewNine,this,tag_nine,pendingComparisonDataList)

        }

        binding.imageViewTen.setOnClickListener {

            binding.imageViewTen.isEnabled = false

            selectedImages.add(binding.imageViewTen)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[9],binding.imageViewTen,this,tag_ten,pendingComparisonDataList)

        }
        binding.imageViewEleven.setOnClickListener {

            binding.imageViewEleven.isEnabled = false

            selectedImages.add(binding.imageViewEleven)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[10],binding.imageViewEleven,this,tag_eleven,pendingComparisonDataList)


        }
        binding.imageViewTwelve.setOnClickListener {

            binding.imageViewTwelve.isEnabled = false

            selectedImages.add(binding.imageViewTwelve)

            if (selectedImages.size == 2){

                uiOperationsManager.set_disable(unmatchedDataList )

            }

            uiLogicDelegate.animation(unmatchedDataList,selectedImages,list[11],binding.imageViewTwelve,this,tag_twelve,pendingComparisonDataList)

        }



    }

    fun add_Image_into_list(list: MutableList<ImageView>){

        list.add(binding.imageViewOne)
        list.add(binding.imageViewTwo)
        list.add(binding.imageViewThree)
        list.add(binding.imageViewFour)
        list.add(binding.imageViewFive)
        list.add(binding.imageViewSix)
        list.add(binding.imageViewSeven)
        list.add(binding.imageViewEight)
        list.add(binding.imageViewNine)
        list.add(binding.imageViewTen)
        list.add(binding.imageViewEleven)
        list.add(binding.imageViewTwelve)

    }




}
