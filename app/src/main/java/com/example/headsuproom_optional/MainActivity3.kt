package com.example.headsuproom_optional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var tapoo1:EditText
    private lateinit var tapoo2:EditText
   private lateinit var tapoo3:EditText
    var id = 0


    lateinit var update:Button
   lateinit var delete:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        init()

        update.setOnClickListener {
            var tt = Celeprteis(id,name.text.toString(),tapoo1.text.toString(),tapoo2.text.toString(),tapoo3.text.toString())
            CeleprteisDatabase.getInstance(this).CeleprteisDao().UpdateCeleprteis(tt)
            Toast.makeText(this,"Updated ",Toast.LENGTH_SHORT).show()
            clear()

        }

        delete.setOnClickListener {
            var tt = Celeprteis(id,name.text.toString(),tapoo1.text.toString(),tapoo2.text.toString(),tapoo3.text.toString())
            CeleprteisDatabase.getInstance(this).CeleprteisDao().DeleteCeleprteis(tt)
            Toast.makeText(this,"Deleted ",Toast.LENGTH_SHORT).show()
            clear()

        }
    }

    fun init(){
        name = findViewById(R.id.editname)
        tapoo1 = findViewById(R.id.editapoo1)
        tapoo2 = findViewById(R.id.edittapoo2)
        tapoo3 = findViewById(R.id.edittapoo3)
        update = findViewById(R.id.update)
        delete = findViewById(R.id.delete)
        id = intent.getIntExtra("myID",0)
        name.setText(intent.getStringExtra("name"))
        tapoo1.setText(intent.getStringExtra("tapoo1"))
        tapoo2.setText(intent.getStringExtra("tapoo2"))
        tapoo3.setText(intent.getStringExtra("tapoo3"))
    }
    fun clear(){
        name.text.clear()
        tapoo1.text.clear()
        tapoo2.text.clear()
        tapoo3.text.clear()
    }

}