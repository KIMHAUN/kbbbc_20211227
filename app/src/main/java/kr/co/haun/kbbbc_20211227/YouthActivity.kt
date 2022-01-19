package kr.co.haun.kbbbc_20211227

import adapters.WorshipAdapter
import android.os.Bundle
import data.WorshipData
import kotlinx.android.synthetic.main.detail_greetings.*
import kotlinx.android.synthetic.main.detail_greetings.toolbar
import kotlinx.android.synthetic.main.worship_manna.*

class YouthActivity : BaseActivity() {

    lateinit var worshipAdapter: WorshipAdapter
    val datas = mutableListOf<WorshipData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.worship_youth)

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
        //worshipAdapter = WorshipAdapter(this)
        mannaRecyclerView.adapter = worshipAdapter


        datas.apply {

            worshipAdapter.worshipList = datas
            worshipAdapter.notifyDataSetChanged()

        }
    }
}