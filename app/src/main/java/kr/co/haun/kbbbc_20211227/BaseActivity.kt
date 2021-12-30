package kr.co.haun.kbbbc_20211227

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    val mContext = this
    //this 대신 mContext사용.

    //overiding 무조건 구현해서 사용해야됨.
    abstract fun setupEvents()
    abstract fun setValues()
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}