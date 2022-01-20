package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import data.WorshipData
import kr.co.haun.kbbbc_20211227.R

class WorshipAdapter (private val context: Context) : RecyclerView.Adapter<WorshipAdapter.ViewHolder>() {

    var worshipList = mutableListOf<WorshipData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_worship,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = worshipList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(worshipList[position])
    }

    fun setItems(newItem: List<WorshipData>) {
        this.worshipList.addAll(newItem)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val worshipImg: ImageView = itemView.findViewById(R.id.worshipImg)
        private val worshipTitle: TextView = itemView.findViewById(R.id.worshipTitle)
        private val worshipSubtitle: TextView = itemView.findViewById(R.id.worshipSubtitle)
        private val worshipDate: TextView = itemView.findViewById(R.id.worshipDate)

        fun bind(item: WorshipData) {
            worshipTitle.text = item.worshipTitle
            worshipSubtitle.text = item.worshipSubtitle
            worshipDate.text = item.worshipDate.toString()
            Glide.with(itemView).load(item.worshipImg).into(worshipImg)

        }
    }
}