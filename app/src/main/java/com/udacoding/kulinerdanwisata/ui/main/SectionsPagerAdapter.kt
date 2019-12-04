package com.udacoding.kulinerdanwisata.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.udacoding.kulinerdanwisata.ui.uikuliner.KulinerFragment
import com.udacoding.kulinerdanwisata.ui.uiwisata.WisataFragment

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = KulinerFragment()
            1 -> fragment = WisataFragment()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var nameTabs = ""
        when(position){
            0 -> nameTabs = "Kuliner"
            1 -> nameTabs = "Wisata"
        }
        return nameTabs
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}