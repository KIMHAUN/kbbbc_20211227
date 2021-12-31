package fragments

import adapters.NoticeAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import data.NoticeData
import kotlinx.android.synthetic.main.fragment_notice.*
import kr.co.haun.kbbbc_20211227.R

class NoticeFragment: Fragment() {
    lateinit var noticeAdapter: NoticeAdapter
    val datas = mutableListOf<NoticeData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notice, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecycler()
    }

    private fun initRecycler() {
        noticeAdapter = NoticeAdapter(requireContext())
        noticeRecyclerView.adapter = noticeAdapter
        datas.clear()
        datas.apply {
            add(NoticeData(noticeTitle = "송구영신예배", noticeDate = "2021.12.30"))
            noticeAdapter.datas = datas
            noticeAdapter.notifyDataSetChanged()
        }

    }
}