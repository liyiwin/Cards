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


    private var selectedImages = mutableListOf<ImageData>()

    private var list = mutableListOf<Int>()

    private var unmatchedDataList = mutableListOf<ImageData>()
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
        add_Image_into_list(unmatchedDataList)

        transform(list)

        val unMatchedDataIsLocked = Observer<Boolean>{ isLocked ->
            val isEnabled = !isLocked
            unmatchedDataList.forEach {
                uiOperationsManager.setImageIsEnabled(it.imageName,isEnabled)
            }

        }

        viewModel.getUnMatchedDataIsLocked().observe(this,unMatchedDataIsLocked)

        // tag_one

        val tag_one_Observer = Observer<String>{

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

            selectedImages.add(ImageData("imageViewOne"))

           if (selectedImages.size == 2){
               viewModel.lockUnMatchedData()

           }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[0],ImageData("imageViewOne"))

        }


        binding.imageViewTwo.setOnClickListener {

            binding.imageViewTwo.isEnabled = false

            selectedImages.add(ImageData("imageViewTwo"))

            if (selectedImages.size == 2){

                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[1],ImageData("imageViewTwo"))


        }

        binding.imageViewThree.setOnClickListener {

            binding.imageViewThree.isEnabled = false

            selectedImages.add(ImageData("imageViewThree"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[2],ImageData("imageViewThree"))


        }

        binding.imageViewFour.setOnClickListener {

            binding.imageViewFour.isEnabled = false

            selectedImages.add(ImageData("imageViewFour"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()

            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[3],ImageData("imageViewFour"))

        }

        binding.imageViewFive.setOnClickListener {

            binding.imageViewFive.isEnabled = false

            selectedImages.add(ImageData("imageViewFive"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()

            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[4],ImageData("imageViewFive"))



        }

        binding.imageViewSix.setOnClickListener {

            binding.imageViewSix.isEnabled = false

            selectedImages.add(ImageData("imageViewSix"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[5],ImageData("imageViewSix"))

        }

        binding.imageViewSeven.setOnClickListener {

            binding.imageViewSeven.isEnabled = false

            selectedImages.add(ImageData("imageViewSeven"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[6],ImageData("imageViewSeven"))

        }

        binding.imageViewEight.setOnClickListener {

            binding.imageViewEight.isEnabled = false

            selectedImages.add(ImageData("imageViewEight"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[7],ImageData("imageViewEight"))

        }

        binding.imageViewNine.setOnClickListener {

            binding.imageViewNine.isEnabled = false

            selectedImages.add(ImageData("imageViewNine"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[8],ImageData("imageViewNine"))

        }

        binding.imageViewTen.setOnClickListener {

            binding.imageViewTen.isEnabled = false

            selectedImages.add(ImageData("imageViewTen"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[9],ImageData("imageViewTen"))

        }
        binding.imageViewEleven.setOnClickListener {

            binding.imageViewEleven.isEnabled = false

            selectedImages.add(ImageData("imageViewEleven"))

            if (selectedImages.size == 2){
                viewModel.lockUnMatchedData()
            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[10],ImageData("imageViewEleven"))


        }
        binding.imageViewTwelve.setOnClickListener {

            binding.imageViewTwelve.isEnabled = false

            selectedImages.add(ImageData("imageViewTwelve"))

            if (selectedImages.size == 2){
               viewModel.lockUnMatchedData()

            }

            uiLogicDelegate.rotateCardUpright(unmatchedDataList,selectedImages,list[11],ImageData("imageViewTwelve"))

        }



    }

    fun add_Image_into_list(list: MutableList<ImageData>){

        list.add(ImageData("imageViewOne"))
        list.add(ImageData("imageViewTwo"))
        list.add(ImageData("imageViewThree"))
        list.add(ImageData("imageViewFour"))
        list.add(ImageData("imageViewFive"))
        list.add(ImageData("imageViewSix"))
        list.add(ImageData("imageViewSeven"))
        list.add(ImageData("imageViewEight"))
        list.add(ImageData("imageViewNine"))
        list.add(ImageData("imageViewTen"))
        list.add(ImageData("imageViewEleven"))
        list.add(ImageData("imageViewTwelve"))

    }




}
