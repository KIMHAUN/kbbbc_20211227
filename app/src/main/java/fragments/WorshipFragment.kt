package fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_worship.*
import kr.co.haun.kbbbc_20211227.GreetingActivity
import kr.co.haun.kbbbc_20211227.MannaActivity
import kr.co.haun.kbbbc_20211227.R

class WorshipFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_worship, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        intentSetting()
    }

    private fun intentSetting() {
        //오말찬
        manna.setOnClickListener{
            val  myIntent = Intent(context, MannaActivity::class.java)
            startActivity(myIntent)
        }
    }
}