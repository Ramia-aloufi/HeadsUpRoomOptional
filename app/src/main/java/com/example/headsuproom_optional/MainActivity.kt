package com.example.headsuproom_optional

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.util.Log
import android.view.Surface
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import android.content.Intent
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var portratstart: RelativeLayout
    lateinit var portrat: RelativeLayout
    lateinit var land: RelativeLayout
    lateinit var celebrities: MutableList<Celeprteis>
    lateinit var title: TextView
    lateinit var po: TextView
    lateinit var someOf: TextView
    private lateinit var tim: TextView
    private lateinit var btn: Button
    private lateinit var btn2: Button
    var TAG = "MainActivity"
    var ii = 0
    var starta = true
    var startb = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        btn.setOnClickListener {
            start()
        }
        btn2.setOnClickListener {
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        rotation()

    }

    fun init() {
        portratstart = findViewById(R.id.portratstart)
        portrat = findViewById(R.id.portrat)
        land = findViewById(R.id.land)
        po = findViewById(R.id.po)
        title = findViewById(R.id.title)
        someOf = findViewById(R.id.someOf)
        tim = findViewById(R.id.time)
        btn = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)

    }

    fun start() {
        time()
        portratstart.isVisible = false
        portrat.isVisible = true
    }

    fun rotation() {
        val rotation = windowManager.defaultDisplay.rotation
        if (rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180) {
            firstactivity(starta)
            land.visibility = View.GONE
            Log.d("starta","$starta")
            Log.d("startb","$startb")
        } else {
            jsonarrayToUI()
            ii++
            Log.d("starta","$starta")
            Log.d("startb","$startb")

            portrat.visibility = View.GONE
            portratstart.visibility = View.GONE
            secondactivity(startb)

        }
    }

    fun firstactivity(status: Boolean) {
        if(status == true) {
            portrat.visibility = View.GONE
            portratstart.visibility = View.VISIBLE
        } else {
            portrat.visibility = View.VISIBLE
            portratstart.visibility = View.GONE
        }

    }

    fun secondactivity(was: Boolean) {
        if(was) {
            land.visibility = View.VISIBLE
        } else {
            land.visibility = View.GONE
        }
    }

    fun time() {
        starta = !starta
        startb = !startb
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tim.text = "Time: ${millisUntilFinished / 1000}"

            }

            override fun onFinish() {
                starta = !starta
                startb = !startb
                tim.text = "Time: "
            }
        }.start()

    }
    fun jsonarrayToUI() {
        celebrities = tvtxt()
        if(ii >= celebrities.size){
            title.text = "No data.."
            someOf.visibility = View.GONE

        }else {
            title.text = celebrities[ii].name
            var aa = celebrities[ii].tapoo1
            var bb = celebrities[ii].tapoo2
            var qq = celebrities[ii].tapoo3
            someOf.text = "$aa\n$bb\n$qq\n"
            Log.d("titl", title.toString())
            Log.d("titl", "$aa\n$bb\n$qq")
        }
    }

    fun tvtxt():MutableList<Celeprteis>{
        var cil = CeleprteisDatabase.getInstance(applicationContext).CeleprteisDao().getAllUserInfo()
        var MyText  = mutableListOf<Celeprteis>()
        for (i in cil.indices){
            MyText.add(cil[i])
            Log.d(TAG,"$MyText")
        }
        return MyText
    }


}