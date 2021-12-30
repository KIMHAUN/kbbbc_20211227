package fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_worship.*
import kr.co.haun.kbbbc_20211227.*

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
        //주일예배
        sunday.setOnClickListener{
            val  myIntent = Intent(context, SundayActivity::class.java)
            startActivity(myIntent)
        }
        //수요예배
        wednesday.setOnClickListener{
            val  myIntent = Intent(context, WednesdayActivity::class.java)
            startActivity(myIntent)
        }
        //청년부
        youth.setOnClickListener{
            val  myIntent = Intent(context, YouthActivity::class.java)
            startActivity(myIntent)
        }
        //중고등부
        midhigh.setOnClickListener{
            val  myIntent = Intent(context, MidhighActivity::class.java)
            startActivity(myIntent)
        }
        //주일학교
        children.setOnClickListener{
            val  myIntent = Intent(context, ChildrenActivity::class.java)
            startActivity(myIntent)
        }
    }
}