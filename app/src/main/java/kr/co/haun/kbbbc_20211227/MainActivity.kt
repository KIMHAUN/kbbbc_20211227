package kr.co.haun.kbbbc_20211227

import adapters.MyViewPagerAdapter
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var mvpa : MyViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        mvpa = MyViewPagerAdapter(supportFragmentManager)
        myViewPager.adapter = mvpa
        kbbbcTabLayout.setupWithViewPager(myViewPager)

        //vp_slider = findViewById(R.id.viewPager_banner)




    }


}