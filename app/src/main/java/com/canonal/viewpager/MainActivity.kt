package com.canonal.viewpager

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.canonal.viewpager.adapter.WhatsappPagerAdapter
import com.canonal.viewpager.fragment.CallListFragment
import com.canonal.viewpager.fragment.CameraFragment
import com.canonal.viewpager.fragment.ChatListFragment
import com.canonal.viewpager.fragment.StatusFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
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

        viewPager = findViewById(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val adapter = WhatsappPagerAdapter(fragmentList, this)
        viewPager.adapter = adapter

       // tabLayout.setupWithViewPager(viewPager) for viewPager
        TabLayoutMediator(tabLayout,viewPager){tab, position ->
            //if needed setOnClick here
            //tab.view.setOnClickListener{}
           if(position==0){
               tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_camera)
           }else{
               tab.text= fragmentTitleList[position]
           }
        }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            //Here we have same 3 functions onPageScrolled,onPageSelected,onPageScrollStateChange
            //override what you need, no need to override all of them

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        //Main imp of viewPager till here
        //------------------
        //Here some additional details

       /* val tabLayoutCamera = tabLayout.getTabAt(0)
        tabLayoutCamera?.icon = ContextCompat.getDrawable(this, R.drawable.ic_camera)
        //To understand whether the user clicked to a particular tab rather than swiped to
        //tab, we can access view and setOnClickListener. Here, we can define a flag and use
        //accordingly.Set flag true here and other views and make it false inside onPageChangeListener
        //functions
        tabLayoutCamera?.view?.setOnClickListener {
            Toast.makeText(this, "tab Clicked", Toast.LENGTH_SHORT).show()
        }

        val tabLayoutChats = tabLayout.getTabAt(1)
        tabLayoutChats?.text = "CHATS"

        val tabLayoutStatus = tabLayout.getTabAt(2)
        tabLayoutStatus?.text = "STATUS"

        val tabLayoutCalls = tabLayout.getTabAt(3)
        tabLayoutCalls?.text = "CALLS"*/

       /* viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                //on swipe executed: 2 / on select via tab: 3
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val title = (viewPager.adapter as WhatsappPagerAdapter).getPageTitle(position)
                "onPageScrolled" showLog "title = $title"
            }

            override fun onPageSelected(position: Int) {
                //on swipe executed: 3 / on select via tab: 2
                val title = (viewPager.adapter as WhatsappPagerAdapter).getPageTitle(position)
                "onPageSelected" showLog "title = $title"
            }

            override fun onPageScrollStateChanged(state: Int) {
                //on swipe executed: 1 / on select via tab: 1
                "onPageScrollStateChanged" showLog "state = $state"
            }
        })*/


        //to add animation to swipe events
        // viewPager.setPageTransformer()

        //open viewPager with given index fragment
        //viewPager.currentItem = 3
    }

    //If you have onBoarding screen you can use such an logic
    //When you press back currentItem decreases by one and
    //screen goes back to previous fragment, If currentItem is 0
    //app closes
    override fun onBackPressed() {

        if (viewPager.currentItem == 0) {
            super.onBackPressed()

        } else {
            viewPager.currentItem = viewPager.currentItem - 1
            //viewPager.currentItem = fragmentList.size
            //jumps to last item
        }
    }
}


infix fun String.showLog(message: String) {
    Log.e(this, message)
}