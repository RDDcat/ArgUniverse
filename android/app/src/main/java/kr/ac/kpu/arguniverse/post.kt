package kr.ac.kpu.arguniverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class post : AppCompatActivity() {
    lateinit var finish1: Button
    lateinit var name: TextView
    lateinit var text: TextView
    lateinit var heartcount: Button
    lateinit var goodcount: Button
    lateinit var badcount: Button
    lateinit var edit: EditText
    var goodnum: Int? = 0
    var badnum: Int? = 0
    var Edit: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        name = findViewById(R.id.name)
        text = findViewById(R.id.text)
        heartcount = findViewById(R.id.heartcount)
        goodcount = findViewById(R.id.goodcount)
        badcount = findViewById(R.id.badcount)
        edit = findViewById(R.id.edit)

        var intent = intent
        var Id = intent.getIntExtra("PostID", -1)
        var Reed = intent.getIntExtra("Rereed", -1)
        var Heart = intent.getIntExtra("Reheart", -1)
        var Btn = intent.getStringExtra("Rebtn")
        var MContent = intent.getStringExtra("Content")
        Log.d("test", "id : " + Id)
        Log.d("test", "제목 : " + Btn)
        Log.d("test", "heart : " + Heart)
        Log.d("test", "reed : " + Reed)
        finish1 = findViewById<Button>(R.id.finish1)
        finish1.setOnClickListener {
            finish()
        }
        name.text = Btn
        text.text = MContent
        goodcount.setOnClickListener {
            if (edit.getText().toString().equals("")) {
                Toast.makeText(applicationContext, "자신의 의견을 먼저 써주세요", Toast.LENGTH_SHORT).show()
            } else {
                goodnum = goodnum?.plus(1)
                Edit = edit.toString()
                var intent = Intent(applicationContext, comment::class.java)
                intent.putExtra("cBtn", Btn)
                intent.putExtra("cgoodnum", goodnum)
                intent.putExtra("cEdit", Edit)
                intent.putExtra("cbadnum", badnum)
                intent.putExtra("cHeart", Heart)
                startActivity(intent)
            }
        }
        badcount.setOnClickListener {

            if (edit.getText().toString().equals("")) {
                Toast.makeText(applicationContext, "자신의 의견을 먼저 써주세요", Toast.LENGTH_SHORT).show()
            } else
                 {
                    badnum = badnum?.plus(1)
                    Edit = edit.toString()
                    var intent = Intent(applicationContext, comment::class.java)
                    intent.putExtra("cBtn", Btn)
                    intent.putExtra("cgoodnum", goodnum)
                    intent.putExtra("cEdit", Edit)
                    intent.putExtra("cbadnum", badnum)
                    intent.putExtra("cHeart", Heart)
                    startActivity(intent)
                }

        }

        heartcount.setOnClickListener {
            Heart =Heart?.plus(1)
        }
    }
}