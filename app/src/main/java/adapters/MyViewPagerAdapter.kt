package adapters
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import fragments.HomeFragment
import fragments.NoticeFragment
import fragments.WorshipFragment

class MyViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "홈"
            1 -> "말씀과 찬양"
            else -> "공지사항"
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> WorshipFragment()
            else -> NoticeFragment()
        }
    }
}