package com.example.amazonapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonapp.data.FirstRVItems
import com.example.amazonapp.databinding.ChangeditemLayoutBinding

class FirstRVAdapter(var itemList:List<FirstRVItems>):RecyclerView.Adapter<FirstRVAdapter.FirstRecycleViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstRecycleViewHolder {

        val binding = ChangeditemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FirstRecycleViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: FirstRecycleViewHolder, position: Int) {
         with(holder){
            with(itemList[position]){
                binding.mainProductImg.setImageResource(  this.itemImage)
                binding.txtItemName.text = this.itemName
            }
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class FirstRecycleViewHolder(val binding:ChangeditemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}