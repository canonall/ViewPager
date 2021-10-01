package com.canonal.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class WhatsappPagerAdapter(
    private val fragmentList: List<Fragment>,
    private val fragmentTitleList: List<String>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int = fragmentList.size

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence = fragmentTitleList[position]
}