package com.milipade.talitha_koum.gadsleaderboard.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.milipade.talitha_koum.gadsleaderboard.fragments.FirstFragment
import com.milipade.talitha_koum.gadsleaderboard.fragments.SecondFragment

class ScreenPagerAdapter (fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> FirstFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> {
                "Learning Leaders"
            }
            1 -> {
               "Skill IQ Leaders"
            }
            else -> "Learning Leaders"
        }
    }

}