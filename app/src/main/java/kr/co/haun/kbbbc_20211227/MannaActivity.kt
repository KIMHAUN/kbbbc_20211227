package kr.co.haun.kbbbc_20211227

import adapters.WorshipAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import data.WorshipData
import kotlinx.android.synthetic.main.detail_greetings.toolbar
import kotlinx.android.synthetic.main.worship_manna.*
import kr.co.haun.kbbbc_20211227.utils.ServerUtil
import org.json.JSONArray


class MannaActivity : BaseActivity() {

    lateinit var worshipAdapter: WorshipAdapter
    var datas = mutableListOf<WorshipData>()

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

    private fun getWorshipList() : MutableList<WorshipData> {
        ServerUtil.getRequestWorshipList("MAN", object : ServerUtil.JsonResponseHandler {
            //var worshipList = ArrayList<WorshipData>()

            override fun onResponse(worshipList: JSONArray) {
                //Log.d("response : ", worshipList.toString())

                for (i in 0 until worshipList.length()) {
                    val worship = worshipList.getJSONObject(i)
                    val worship_id = worship.getString("worship_id")
                    val worship_url = worship.getString("worship_url")
                    val worship_title = worship.getString("worship_title")
                    val worship_subtitle = worship.getString("worship_subtitle")
                    val worship_img = worship.getString("worship_img")
                    val worship_date = worship.getString("worship_date")

                    var wd = WorshipData(
                        worship_id,
                        worship_url,
                        worship_title,
                        worship_subtitle,
                        worship_img,
                        worship_date,
                        "MAN")
                    //Log.d("json to worshipData", wd.toString())
                    datas.add(wd)
                }
                Log.d("worship from server ::", datas.toString())
                Handler(Looper.getMainLooper()).post(Runnable { worshipAdapter.notifyDataSetChanged() })
                //worshipAdapter.setItems(datas)
            }
        })

        return datas
    }

    private fun initRecycler() {
        worshipAdapter = WorshipAdapter(this)
        mannaRecyclerView.adapter = worshipAdapter

        datas = getWorshipList()
        Log.d("worship", datas.toString())
        datas.apply{
            worshipAdapter.worshipList = datas
            worshipAdapter.notifyDataSetChanged()
        }


        //datas.apply {
//            for (i in 0 until datas.size) {
//                Log.d("worship", datas[i].toString())
//                add(datas[i])
//            }
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "복음과 신앙을 변호하는 성도", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "지금은 결산을 생각할 때", worshipDate = "20211230", worshipSubtitle = "고전 4:1-5"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "하나님이 함께하시는 싸움", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "주님이 주신 지혜", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "주님께로 도약", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "성탄의 의미", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))
//            add(WorshipData(worshipThumbnail = R.drawable.manna_211219, worshipTitle = "예수님의 이름", worshipDate = "20211230"))

           // worshipAdapter.datas = datas
           // worshipAdapter.notifyDataSetChanged()
       // }
    }
}