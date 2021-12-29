package fragments

import adapters.ViewPagerAdapter
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_home.*
import kr.co.haun.kbbbc_20211227.*

class HomeFragment: Fragment() {

    private var currentPosition = Int.MAX_VALUE / 2
    private val intervalTime = 2000.toLong() // 몇초 간격으로 페이지를 넘길것인지 (1500 = 1.5초)
    private var myHandler = MyHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        banner.adapter = ViewPagerAdapter(getBannerList()) // 어댑터 생성
        banner.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
        banner.setCurrentItem(currentPosition, false)

        //spring_dots_indicator.setViewPager2(banner) //indicator 설정

        banner.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 뷰페이저 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }

        //Intent setting
        intentSetting()

    }

    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // 이거 안하면 핸들러가 1개, 2개, 3개 ... n개 만큼 계속 늘어남
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime 만큼 반복해서 핸들러를 실행하게 함
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }

    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                banner.setCurrentItem(++currentPosition, true) // 다음 페이지로 이동
                autoScrollStart(intervalTime) // 스크롤을 계속 이어서 한다.
            }
        }
    }

    // 다른 페이지 갔다가 돌아오면 다시 스크롤 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // 다른 페이지로 떠나있는 동안 스크롤이 동작할 필요는 없음. 정지
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }



    // 뷰 페이저에 들어갈 아이템
    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3)
    }

    private fun intentSetting() {
        //인사말
        greetings.setOnClickListener{
            val  myIntent = Intent(context, GreetingActivity::class.java)
            startActivity(myIntent)
        }
        //연혁
        history.setOnClickListener{
            val  myIntent = Intent(context, HistoryActivity::class.java)
            startActivity(myIntent)
        }

        //비전
        vision.setOnClickListener{
            val  myIntent = Intent(context, VisionActivity::class.java)
            startActivity(myIntent)
        }

        //신앙의 믿음
        faith.setOnClickListener{
            val  myIntent = Intent(context, FaithActivity::class.java)
            startActivity(myIntent)
        }

        //사역자
        profiles.setOnClickListener{
            val  myIntent = Intent(context, ProfilesActivity::class.java)
            startActivity(myIntent)
        }

        //예배 안내
        timetable.setOnClickListener{
            val  myIntent = Intent(context, TimetableActivity::class.java)
            startActivity(myIntent)
        }

        //찾아오는 길
        map.setOnClickListener{
            val  myIntent = Intent(context, MapActivity::class.java)
            startActivity(myIntent)
        }

        //heart
        heart.setOnClickListener {

            Log.d("heart click : ", ":: clicked!!!" )
            Toast.makeText(context, "JESUS LOVES YOU", Toast.LENGTH_SHORT).show()
        }
    }

}