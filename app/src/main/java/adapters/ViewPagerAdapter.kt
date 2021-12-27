package adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import fragments.HomeFragment
import fragments.WorshipFragment
import kotlinx.android.synthetic.main.banner_list_item.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kr.co.haun.kbbbc_20211227.R


class ViewPagerAdapter(bannerList: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = bannerList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.idol.setImageResource(item[position])
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
    (LayoutInflater.from(parent.context).inflate(R.layout.banner_list_item, parent, false)) {

        val idol = itemView.img_slide_image!!
    }
}