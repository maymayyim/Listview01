package com.egco428.listview01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        var name: String
        var Position: Int
        val extras = intent.extras
        name = extras.getString("data1")
        Position = extras.getInt("data2")

        pname.setText(name)
        position.setText(Position.toString())

        if(Position%2 == 0){

            imageView3.setImageResource(R.drawable.woman)

        }
        else{
            imageView3.setImageResource(R.mipmap.ic_launcher_round)
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
            when (item.itemId) {
                android.R.id.home -> {
                    finish()
                    return true
                }
            }

            return super.onOptionsItemSelected(item)
    }

}
