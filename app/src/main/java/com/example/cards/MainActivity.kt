package com.example.cards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private var compare_list = mutableListOf<Compared_data>()

    private var collected_image = mutableListOf<ImageView>()

    private var list = mutableListOf<Int>()

    private var imagelist = mutableListOf<ImageView>()

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


    var img_one_value = 0
    var img_two_value = 0
    var img_three_value = 0
    var img_four_value = 0
    var img_five_value = 0
    var img_six_value = 0
    var img_seven_value = 0
    var img_eight_value = 0
    var img_nine_value = 0
    var img_ten_value = 0
    var img_eleven_value = 0
    var img_twelve_value = 0




   val viewModel by lazy { ViewModelProviders.of(this
   ).get(ViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_Image_into_list(imagelist)

        transform(list)


        // tag_one

        val tag_one_Observer = Observer<String>{

            tag_one = it

            if (it == "front"){

                val number = list[0]

                set_mycard_Image(imageView_one,number)

            }

            if (it == "back"){

                imageView_one.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_one_tag().observe(this,tag_one_Observer)

        // tag_two

        val tag_two_Observer = Observer<String>{

            tag_two = it

            if (it == "front"){

                val number = list[1]

                set_mycard_Image(imageView_two,number)
            }

            if (it == "back"){

                imageView_two.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_two_tag().observe(this,tag_two_Observer)

        // tag_three

        val tag_three_Observer = Observer<String>{

            tag_three = it

            if (it == "front"){

                val number = list[2]

                set_mycard_Image(imageView_three,number)
            }

            if (it == "back"){

                imageView_three.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_three_tag().observe(this,tag_three_Observer)

        // tag_four

        val tag_four_Observer = Observer<String>{

            tag_four =it

            if (it == "front"){

                val number = list[3]

                set_mycard_Image(imageView_four,number)
            }

            if (it == "back"){

                imageView_four.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_four_tag().observe(this,tag_four_Observer)

        // tag_five

        val tag_five_Observer = Observer<String>{

            tag_five =it

            if (it == "front"){

                val number = list[4]

                set_mycard_Image(imageView_five,number)
            }

            if (it == "back"){

                imageView_five.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_five_tag().observe(this,tag_five_Observer)

        // tag_six

        val tag_six_Observer = Observer<String>{

            tag_six = it

            if (it == "front"){

                val number = list[5]

                set_mycard_Image(imageView_six,number)
            }

            if (it == "back"){

                imageView_six.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_six_tag().observe(this,tag_six_Observer)

        // tag_seven

        val tag_seven_Observer = Observer<String>{

            tag_seven = it

            if (it == "front"){

                val number = list[6]

                set_mycard_Image(imageView_seven,number)
            }

            if (it == "back"){

                imageView_seven.setImageResource(R.drawable.background)

            }


        }

        viewModel.get_ima_seven_tag().observe(this,tag_seven_Observer)



        // tag_eight

        val tag_eight_Observer = Observer<String>{

            tag_eight = it

            if (it == "front"){

                val number = list[7]

                set_mycard_Image(imageView_eight,number)
            }

            if (it == "back"){

                imageView_eight.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_eight_tag().observe(this,tag_eight_Observer)

        // tag_nine

        val tag_nine_Observer = Observer<String>{

            tag_nine = it

            if (it == "front"){

                val number = list[8]

                set_mycard_Image(imageView_nine,number)
            }

            if (it == "back"){

                imageView_nine.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_nine_tag().observe(this,tag_nine_Observer)

        // tag_ten

        val tag_ten_Observer = Observer<String>{

            tag_ten = it

            if (it == "front"){

                val number = list[9]

                set_mycard_Image(imageView_ten,number)
            }

            if (it == "back"){

                imageView_ten.setImageResource(R.drawable.background)


            }


        }

        viewModel.get_ima_ten_tag().observe(this,tag_ten_Observer)

        // tag_eleven

        val tag_eleven_Observer = Observer<String>{

            tag_eleven = it

            if (it == "front"){

                val number = list[10]

                set_mycard_Image(imageView_eleven,number)
            }

            if (it == "back"){

                imageView_eleven.setImageResource(R.drawable.background)

            }

        }

        viewModel.get_ima_eleven_tag().observe(this,tag_eleven_Observer)


        // tag_twelve

        val tag_twelve_Observer = Observer<String>{

            tag_twelve = it

            if (it == "front"){

                val number = list[11]

                set_mycard_Image(imageView_twelve,number)
            }

            if (it == "back"){

                imageView_twelve.setImageResource(R.drawable.background)


            }

        }

        viewModel.get_ima_twelve_tag().observe(this,tag_twelve_Observer)


        imageView_one.setOnClickListener {

            imageView_one.isEnabled = false

            collected_image.add(imageView_one)

           if (collected_image.size == 2){

               set_disable(imagelist)

           }

            animation(imagelist,collected_image,list[0],imageView_one,this,viewModel,tag_one,compare_list)

        }


        imageView_two.setOnClickListener {

            imageView_two.isEnabled = false

            collected_image.add(imageView_two)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[1],imageView_two,this,viewModel,tag_two,compare_list)


        }

        imageView_three.setOnClickListener {

            imageView_three.isEnabled = false

            collected_image.add(imageView_three)

            if (collected_image.size == 2){

                set_disable(imagelist )



            }

            animation(imagelist,collected_image,list[2],imageView_three,this,viewModel,tag_three,compare_list)


        }

        imageView_four.setOnClickListener {

            imageView_four.isEnabled = false

            collected_image.add(imageView_four)

            if (collected_image.size == 2){

                set_disable(imagelist )


            }

            animation(imagelist,collected_image,list[3],imageView_four,this,viewModel,tag_four,compare_list)

        }

        imageView_five.setOnClickListener {

            imageView_five.isEnabled = false

            collected_image.add(imageView_five)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[4],imageView_five,this,viewModel,tag_five,compare_list)



        }

        imageView_six.setOnClickListener {

            imageView_six.isEnabled = false

            collected_image.add(imageView_six)

            if (collected_image.size == 2){

                set_disable(imagelist )


            }

            animation(imagelist,collected_image,list[5],imageView_six,this,viewModel,tag_six,compare_list)

        }

        imageView_seven.setOnClickListener {

            imageView_seven.isEnabled = false

            collected_image.add(imageView_seven)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[6],imageView_seven,this,viewModel,tag_seven,compare_list)

        }

        imageView_eight.setOnClickListener {

            imageView_eight.isEnabled = false

            collected_image.add(imageView_eight)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[7],imageView_eight,this,viewModel,tag_eight,compare_list)

        }

        imageView_nine.setOnClickListener {

            imageView_nine.isEnabled = false

            collected_image.add(imageView_nine)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[8],imageView_nine,this,viewModel,tag_nine,compare_list)

        }

        imageView_ten.setOnClickListener {

            imageView_ten.isEnabled = false

            collected_image.add(imageView_ten)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[9],imageView_ten,this,viewModel,tag_ten,compare_list)

        }
        imageView_eleven.setOnClickListener {

            imageView_eleven.isEnabled = false

            collected_image.add(imageView_eleven)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[10],imageView_eleven,this,viewModel,tag_eleven,compare_list)


        }
        imageView_twelve.setOnClickListener {

            imageView_twelve.isEnabled = false

            collected_image.add(imageView_twelve)

            if (collected_image.size == 2){

                set_disable(imagelist )

            }

            animation(imagelist,collected_image,list[11],imageView_twelve,this,viewModel,tag_twelve,compare_list)

        }



    }

    fun add_Image_into_list(list: MutableList<ImageView>){

        list.add(imageView_one)
        list.add(imageView_two)
        list.add(imageView_three)
        list.add(imageView_four)
        list.add(imageView_five)
        list.add(imageView_six)
        list.add(imageView_seven)
        list.add(imageView_eight)
        list.add(imageView_nine)
        list.add(imageView_ten)
        list.add(imageView_eleven)
        list.add(imageView_twelve)

    }




}
