package com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.ArtistFragment
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.MovieFragment
import com.example.kotlin_mvvm_clean_architecture_demo.presentation.view.fragment.TVShowFragment

class StateAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity)  {

    val fragments:ArrayList<Fragment> = arrayListOf(
        MovieFragment(),
        TVShowFragment(),
        ArtistFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}