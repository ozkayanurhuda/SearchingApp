package com.nurozkaya.searchingapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.nurozkaya.searchingapp.R
import com.nurozkaya.searchingapp.databinding.FragmentDetailScreenBinding

class DetailScreenFragment : Fragment() {

    private lateinit var design:FragmentDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design =DataBindingUtil.inflate(inflater,R.layout.fragment_detail_screen, container, false)
        design.detailScreenFragment=this

        design.detailScreenToolbarTitle="Item Detail"

        //taken object
        val bundle:DetailScreenFragmentArgs by navArgs()
        design.itemObject=bundle.objectSent

        return design.root
    }


}