package com.canonal.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.canonal.viewpager.adapter.WhatsappPagerAdapter
import com.canonal.viewpager.fragment.CallListFragment
import com.canonal.viewpager.fragment.CameraFragment
import com.canonal.viewpager.fragment.ChatListFragment
import com.canonal.viewpager.fragment.StatusFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraFragment = CameraFragment.newInstance()
        val chatListFragment = ChatListFragment.newInstance()
        val statusFragment = StatusFragment.newInstance()
        val callListFragment = CallListFragment.newInstance()

        val fragmentList: ArrayList<Fragment> = arrayListOf()
        fragmentList.add(cameraFragment)
        fragmentList.add(chatListFragment)
        fragmentList.add(statusFragment)
        fragmentList.add(callListFragment)

        //write in string.xlm
        val fragmentTitleList: ArrayList<String> = arrayListOf()
        fragmentTitleList.add("")
        fragmentTitleList.add("CHATS")
        fragmentTitleList.add("STATUS")
        fragmentTitleList.add("CALLS")

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val adapter = WhatsappPagerAdapter(fragmentList, fragmentTitleList, supportFragmentManager)
        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)
    }
}