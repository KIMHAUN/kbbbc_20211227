package kr.co.haun.kbbbc_20211227

import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.detail_greetings.*

class MannaActivity : BaseActivity() {

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
    }


}