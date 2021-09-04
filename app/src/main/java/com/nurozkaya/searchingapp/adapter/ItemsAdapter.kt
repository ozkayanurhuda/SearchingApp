package com.nurozkaya.searchingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nurozkaya.searchingapp.databinding.RowDesignBinding
import com.nurozkaya.searchingapp.entity.Items
import com.nurozkaya.searchingapp.fragment.SearchScreenFragmentDirections
import com.nurozkaya.searchingapp.viewmodel.SearchScreenViewModel

class ItemsAdapter(private var mContext: Context, var itemsList:List<Items>)
    :RecyclerView.Adapter<ItemsAdapter.RowDesignHolder>(){

    //inner class for binding
    inner class RowDesignHolder (rowDesignBinding: RowDesignBinding)
        :RecyclerView.ViewHolder(rowDesignBinding.root) {

            var rowDesign:RowDesignBinding = rowDesignBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val design=RowDesignBinding.inflate(layoutInflater, parent, false)
        return RowDesignHolder(design)
    }

    //what happens when you click
    override fun onBindViewHolder(holder: RowDesignHolder, position: Int) {
        val item=itemsList[position]
        holder.rowDesign.itemObject=item

        //transition to detail screen
        holder.rowDesign.rowCard.setOnClickListener {
            val transition= SearchScreenFragmentDirections
                .actionSearchScreenFragmentToDetailScreenFragment(item)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}