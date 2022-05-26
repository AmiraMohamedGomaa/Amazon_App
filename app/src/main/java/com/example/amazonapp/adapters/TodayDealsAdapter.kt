package com.example.amazonapp.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonapp.data.FirstRVItems
import com.example.amazonapp.data.OffersItems
import com.example.amazonapp.data.TodyaDealsItem
import com.example.amazonapp.databinding.BestOfferItemLayoutBinding
import com.example.amazonapp.databinding.ChangeditemLayoutBinding
import com.example.amazonapp.databinding.TodayOfferItemLayoutBinding

class TodayDealsAdapter(var itemList:List<TodyaDealsItem>):RecyclerView.Adapter<TodayDealsAdapter.DealsViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsViewHolder {

        val binding = TodayOfferItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DealsViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        with(holder){
            with(itemList[position]){
                binding.countryPrice2.text= this.price.toString()
                binding.todayItemImage.setImageResource(  this.image)
                binding.todayOfferTv.text = this.deal
            }
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class DealsViewHolder(val binding:TodayOfferItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}