package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import data.NoticeData
import kr.co.haun.kbbbc_20211227.R

class NoticeAdapter (private val context: Context) : RecyclerView.Adapter<NoticeAdapter.ViewHolder>() {

    var datas = mutableListOf<NoticeData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_notice,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val noticeTitle: TextView = itemView.findViewById(R.id.noticeTitle)
        private val noticeDate: TextView = itemView.findViewById(R.id.noticeDate)
        //private val worshipSubtitle: TextView = itemView.findViewById(R.id.worshipSubtitle)
        //private val worshipDate: TextView = itemView.findViewById(R.id.worshipDate)

        fun bind(item: NoticeData) {
            noticeTitle.text = item.noticeTitle
            noticeDate.text = item.noticeDate
            //worshipDate.text = item.worshipDate.toString()
            //Glide.with(itemView).load(item.worshipThumbnail).into(worshipThumbnail)
        }
    }
}