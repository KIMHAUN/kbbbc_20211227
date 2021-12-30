package kr.co.haun.kbbbc_20211227

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.detail_greetings.*

class MapActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_map)

        setupEvents()
        setValues()
    }
    override fun setupEvents() {
    }

    override fun setValues() {

        //tool bar 생성
        //val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val tb = supportActionBar!!
        tb.setDisplayShowTitleEnabled(false)
        tb.setDisplayHomeAsUpEnabled(true)
    }
}