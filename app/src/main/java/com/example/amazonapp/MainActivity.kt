package com.example.amazonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.amazonapp.adapters.FirstRVAdapter
import com.example.amazonapp.adapters.OffersAdapter
import com.example.amazonapp.adapters.TodayDealsAdapter
import com.example.amazonapp.data.FirstRVItems
import com.example.amazonapp.data.OffersItems
import com.example.amazonapp.data.TodyaDealsItem
import com.example.amazonapp.databinding.ActivityMainBinding
import com.example.amazonapp.databinding.TodayOfferItemLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageSlider()
        loadFirstRV()
        loadOfferRV()
        loadTodayRV()

        val mobile1=findViewById<ImageView>(R.id.mobile1)
        var mobile2=findViewById<ImageView>(R.id.mobile2)
        var mobile3=findViewById<ImageView>(R.id.mobile3)
        var mobile4=findViewById<ImageView>(R.id.mobile4)


        mobile1.setOnClickListener {
            val intent = Intent(this,DetailActivity::class.java)
            startActivity(intent)
        }


    }

    fun imageSlider(){
        val imageSlider = binding.imageSlider
        val imageList = ArrayList<SlideModel>()

        //can also add title or img url instead of drawable images
        imageList.add(SlideModel(R.drawable.slider1))
        imageList.add(SlideModel(R.drawable.slider2))
        imageList.add(SlideModel(R.drawable.slider3))
        imageList.add(SlideModel(R.drawable.slider4))
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
    }
    fun loadFirstRV(){

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        binding.changedItemsRv.setLayoutManager(layoutManager)
        val rvAdapter = FirstRVAdapter(loadFirstRVItems())
        binding.changedItemsRv.adapter = rvAdapter
    }

    fun loadFirstRVItems():List<FirstRVItems>{
        val listItems= listOf(
            FirstRVItems(R.drawable.baby,"Toys"),
            FirstRVItems(R.drawable.beuty,"Beauty"),
            FirstRVItems(R.drawable.body,"Bath&Body"),
            FirstRVItems(R.drawable.electronics,"Electronics"),
            FirstRVItems(R.drawable.furniture,"Furniture"),
            FirstRVItems(R.drawable.kitchen,"Kitchen"),
            FirstRVItems(R.drawable.sports,"Sports"),
            FirstRVItems(R.drawable.four,"Mobiles"),

        )
                return listItems
    }

    fun loadOffersItems():List<OffersItems>{
        val itemList= listOf(
                OffersItems(R.drawable.kitchen,"Kitchen & Dining"),
                OffersItems(R.drawable.fashon,"Up to 70% off Women's Fashion"),
                OffersItems(R.drawable.coffee,"Your one-stop Coffee Store"),
                OffersItems(R.drawable.shoes,"Up to 60% off Men's Shoes"),
                OffersItems(R.drawable.bags,"Up to 60% off Bags & Wallets"),
                OffersItems(R.drawable.beuty,"Makeup"),
                OffersItems(R.drawable.babylas,"Up to 60% off personal care"),
                OffersItems(R.drawable.kidsandbaby,"Below EGP 95 Kids & Baby"),

            )

        return itemList
    }

    fun loadOfferRV(){

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        binding.offerRv.setLayoutManager(layoutManager)
        val rvAdapter = OffersAdapter(loadOffersItems())
        binding.offerRv.adapter = rvAdapter
    }

    fun loadTodayOfferData():List<TodyaDealsItem>{
        val itemList= listOf(
            TodyaDealsItem("Save on Heat & Cooling Air Conditioner",8879.00,R.drawable.today1),
            TodyaDealsItem("Save on tools",567.00,R.drawable.today2),
            TodyaDealsItem("Save on lazord cookware",1067.00,R.drawable.today3),
            TodyaDealsItem("Top Chef Deals",5067.00,R.drawable.today4),
            TodyaDealsItem("Save on nebulizer",467.00,R.drawable.today5),
            TodyaDealsItem("Save on kitchen ",10067.00,R.drawable.today6),
        )
        return itemList
    }

    fun loadTodayRV(){
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
       var recyclerView :RecyclerView=findViewById(R.id.rv_best_offer)
          recyclerView.setLayoutManager(layoutManager)
        val rvAdapter = TodayDealsAdapter(loadTodayOfferData())
          recyclerView.adapter = rvAdapter
    }

}


