package kr.co.haun.kbbbc_20211227

import android.os.Bundle

class GreetingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_greetings)

        setupEvents()
        setValues()
    }
    override fun setupEvents() {
    }

    override fun setValues() {
    }
}