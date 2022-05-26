package com.example.amazonapp.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonapp.data.FirstRVItems
import com.example.amazonapp.data.OffersItems
import com.example.amazonapp.databinding.BestOfferItemLayoutBinding
import com.example.amazonapp.databinding.ChangeditemLayoutBinding

class OffersAdapter(var itemList:List<OffersItems>):RecyclerView.Adapter<OffersAdapter.OffersRecycleViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersRecycleViewHolder {

        val binding = BestOfferItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OffersRecycleViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: OffersRecycleViewHolder, position: Int) {
        with(holder){
            with(itemList[position]){
                binding.offerIv.setImageResource(  this.offerImage)
                binding.offerTv.text = this.offer
            }
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class OffersRecycleViewHolder(val binding:BestOfferItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}