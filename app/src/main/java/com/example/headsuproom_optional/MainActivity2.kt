package com.example.headsuproom_optional

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var tapoo1:EditText
    lateinit var tapoo2:EditText
    lateinit var tapoo3:EditText
    lateinit var updel:EditText
    lateinit var save:Button
    lateinit var upddelbtn:Button
    lateinit var tv:TextView
    lateinit var al :ArrayList<Celeprteis>
    var myName = ""
    var myTapo1 = ""
    var myTapoo2 = ""
    var myTapoo3 = ""
    var MyText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        name = findViewById(R.id.editTextTextPersonName)
        tapoo1 = findViewById(R.id.editTextTextPersonName2)
        tapoo2 = findViewById(R.id.editTextTextPersonName3)
        tapoo3 = findViewById(R.id.editTextTextPersonName4)
        updel = findViewById(R.id.updel)
        save = findViewById(R.id.button3)
        upddelbtn = findViewById(R.id.upddelbtn)
        tv = findViewById(R.id.Clibritestv)
        al = arrayListOf()
        tvtxt()





        upddelbtn.setOnClickListener{
            var myclibrites = CeleprteisDatabase.getInstance(this).CeleprteisDao().getAllUserInfo()
            var nametoUpdate = updel.text.toString()
            for (i in myclibrites){
                if (i.name == nametoUpdate){
                    startActivity(Intent(this,MainActivity3::class.java)
                        .putExtra("myID",i.id)
                        .putExtra("name","${i.name}")
                        .putExtra("tapoo1","${i.tapoo1}")
                        .putExtra("tapoo2","${i.tapoo2}")
                        .putExtra("tapoo3","${i.tapoo3}"))

                    Log.d("ppp","$i")
                    updel.text.clear()
                }
            }


        }




        save.setOnClickListener {
            myName = name.text.toString()
            myTapo1 = tapoo1.text.toString()
            myTapoo2 = tapoo2.text.toString()
            myTapoo3 = tapoo3.text.toString()
            MyText += "$myName $myTapo1 $myTapoo2 $myTapoo3 \n"
            tv.text = MyText
            var tt = Celeprteis(null,myName,myTapo1,myTapoo2,myTapoo3)
            var status =  CeleprteisDatabase.getInstance(this).CeleprteisDao().insertCeleprteis(tt)
            name.text.clear()
            tapoo1.text.clear()
            tapoo2.text.clear()
            tapoo3.text.clear()
            Toast.makeText(this,"data Saved successfully +$status", Toast.LENGTH_SHORT).show()


        }


    }
    fun tvtxt(){
        var cil = CeleprteisDatabase.getInstance(this).CeleprteisDao().getAllUserInfo()

        for (i in cil.indices){
            MyText += "${cil[i].name} ${cil[i].tapoo1} ${cil[i].tapoo2} ${cil[i].tapoo3}\n"
            tv.text = MyText
        }

    }
}