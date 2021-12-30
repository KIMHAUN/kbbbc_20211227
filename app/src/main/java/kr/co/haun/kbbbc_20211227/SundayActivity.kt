package kr.co.haun.kbbbc_20211227

import android.os.Bundle

class SundayActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.worship_sunday)

        setupEvents()
        setValues()
    }
    override fun setupEvents() {
    }

    override fun setValues() {
    }
}