package com.example.pruebatecnica.view.adapters

import androidx.fragment.app.*
import com.example.pruebatecnica.view.fragments.ArtistFragment
import com.example.pruebatecnica.view.fragments.TracksFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    // Returns total number of pages
    override fun getCount() = 2

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0->  fragment = ArtistFragment.newInstance()
            1-> fragment = TracksFragment.newInstance()
        }
       return fragment
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence? {
        var name = ""
        when(position){
            0->  name = "Artist"
            1-> name = "Tracks"
        }
        return name
    }

}