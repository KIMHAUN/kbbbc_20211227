package kr.co.haun.kbbbc_20211227

import adapters.WorshipAdapter
import android.os.Bundle
import data.WorshipData
import kotlinx.android.synthetic.main.detail_greetings.*
import kotlinx.android.synthetic.main.detail_greetings.toolbar
import kotlinx.android.synthetic.main.worship_manna.*

class WednesdayActivity : BaseActivity() {

    lateinit var worshipAdapter: WorshipAdapter
    val datas = mutableListOf<WorshipData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.worship_wednesday)

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

            worshipAdapter.datas = datas
            worshipAdapter.notifyDataSetChanged()

        }
    }
}