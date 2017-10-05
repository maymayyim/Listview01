package com.egco428.listview01

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    var pic: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_listview.adapter = MyCustomAdapter(this)

        // show normal
        main_listview.setOnItemClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as String
            Log.d("Result","Item: $item at position $position")

            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("data1",item)
            intent.putExtra("data2",position)



            startActivity(intent)
        }
    }

    private class MyCustomAdapter(context: Context): BaseAdapter(){
        private val mContext: Context
        private val names = arrayListOf<String>("Tay", "May", "Dream", "Kao-oat","Noey","Tay")

        init {
            //,าจาก this ด้านบน
            mContext = context
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            /*val textView = TextView(mContext)
            textView.text = "Show the message"
            return textView*/
            val greyColor = Color.parseColor("#D7D5D2")
            val rowMain: View
            if(convertView == null){
                val layoutInflator = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflator.inflate(R.layout.row_main,viewGroup,false) //input sub layout
                val viewHolder = ViewHolder(rowMain.name_textview,rowMain.position_textview,rowMain.imageView)
                rowMain.tag = viewHolder
            }else{
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            if(position%2 == 0){
                rowMain.setBackgroundColor(greyColor)

                viewHolder.rowImageView.setImageResource(R.drawable.woman)

            }

            Log.d("Result","Load name_textView")
            viewHolder.nameTextView.text = names.get(position)
            Log.d("Result","Load position_textView")
            viewHolder.positionTextView.text = "Row Number: $position"

            //remove row
/*
            rowMain.setOnClickListener {
                rowMain.animate().setDuration(1500).alpha(0F).withEndAction({
                    names.removeAt(position)
                    notifyDataSetChanged()
                    rowMain.setAlpha(1.0F)
                })
            }
*/




            return rowMain

        }
        private class ViewHolder(val nameTextView: TextView, val positionTextView:TextView, val rowImageView: ImageView)
    }
}
