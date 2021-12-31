package kr.co.haun.kbbbc_20211227

import adapters.WorshipAdapter
import android.os.Bundle
import data.WorshipData
import kotlinx.android.synthetic.main.detail_greetings.toolbar
import kotlinx.android.synthetic.main.worship_manna.*

class MannaActivity : BaseActivity() {

    lateinit var worshipAdapter: WorshipAdapter
    val datas = mutableListOf<WorshipData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.worship_manna)

        setupEvents()
        setValues()
    }
    override fun setupEvents() {
    }

    override fun setValues() {

        setSupportActionBar(toolbar)
        val tb = supportActionBar!!
        tb.setDisplayShowTitleEnabled(false)
        tb.setDisplayHomeAsUpEnabled(true)

        initRecycler()
    }

    private fun initRecycler() {
        worshipAdapter = WorshipAdapter(this)
        mannaRecyclerView.adapter = worshipAdapter


        datas.apply {
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "복음과 신앙을 변호하는 성도", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "지금은 결산을 생각할 때", worshipDate = "20211230", worshipSubtitle = "고전 4:1-5"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "하나님이 함께하시는 싸움", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "주님이 주신 지혜", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "주님께로 도약", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "성탄의 의미", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))

            worshipAdapter.datas = datas
            worshipAdapter.notifyDataSetChanged()

        }
    }
}