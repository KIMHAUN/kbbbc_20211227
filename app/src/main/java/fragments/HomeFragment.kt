package fragments

import adapters.ViewPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import kr.co.haun.kbbbc_20211227.R


class HomeFragment: Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_home)


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
    }

    // 뷰 페이저에 들어갈 아이템
    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3)
    }
}