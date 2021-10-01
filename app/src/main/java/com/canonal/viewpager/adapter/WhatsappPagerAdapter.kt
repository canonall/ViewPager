package com.canonal.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//viewPager2 migration
//PagerAdapter(for views)   -->RecyclerView.Adapter
//FragmentPagerAdapter      -->FragmentStateAdapter
//FragmentStatePagerAdapter -->FragmentStateAdapter
//change the parameter of constructor from fragmentManger to fragmentActivity
//with lifecycle fragment as parameter check google
//overridden functions are so similar
//In the mainActivity.xml change to viewPager2 but Tablayout has to be in the same
//hierarchical level with viewPager2, not inside of it

class WhatsappPagerAdapter(
    private val fragmentList: List<Fragment>,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]


//    viewPager
//    override fun getCount(): Int = fragmentList.size
//
//    override fun getItem(position: Int): Fragment = fragmentList[position]
//
//    override fun getPageTitle(position: Int): CharSequence = fragmentTitleList[position]
}