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
    lateinit var finishpost: Button
    lateinit var posttitle: TextView
    lateinit var postcontent: TextView
    lateinit var postfireCount: Button
    lateinit var postgoodCount: Button
    lateinit var postbadCount: Button
    lateinit var postcomment: EditText
    var goodnum: Int? = 0
    var badnum: Int? = 0
    var Edit: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        posttitle = findViewById(R.id.postTitle)
        postcontent = findViewById(R.id.postContent)
        postfireCount = findViewById(R.id.postFireCount)
        postgoodCount = findViewById(R.id.postGoodCount)
        postbadCount = findViewById(R.id.postBadCount)
        postcomment = findViewById(R.id.postComment)

        var intent = intent
        var Id = intent.getIntExtra("postID", -1)
        var Reed = intent.getIntExtra("fireCount", -1)
        var Heart = intent.getIntExtra("viewCount", -1)
        var Btn = intent.getStringExtra("title")
        var MContent = intent.getStringExtra("content")
        Log.d("test", "id : " + Id)
        Log.d("test", "제목 : " + Btn)
        Log.d("test", "heart : " + Heart)
        Log.d("test", "reed : " + Reed)
        Log.d("test", "reed : " + MContent)

        finishpost = findViewById<Button>(R.id.finishPost)
        finishpost.setOnClickListener {
            finish()
        }
        posttitle.text = Btn
        postcontent.text = MContent
        postgoodCount.setOnClickListener {
            if (postcomment.getText().toString().equals("")) {
                Toast.makeText(applicationContext, "자신의 의견을 먼저 써주세요", Toast.LENGTH_SHORT).show()
            } else {
                goodnum = goodnum?.plus(1)
                Edit = postcomment.text.toString()
                var intent = Intent(applicationContext, comment::class.java)
                intent.putExtra("cBtn", Btn)
                intent.putExtra("cgoodnum", goodnum)
                intent.putExtra("cEdit", Edit)
                intent.putExtra("cbadnum", badnum)
                intent.putExtra("cHeart", Heart)
                startActivity(intent)
            }
        }
        postbadCount.setOnClickListener {

            if (postcomment.getText().toString().equals("")) {
                Toast.makeText(applicationContext, "자신의 의견을 먼저 써주세요", Toast.LENGTH_SHORT).show()
            } else
                 {
                    badnum = badnum?.plus(1)
                    Edit = postcomment.text.toString()
                    var intent = Intent(applicationContext, comment::class.java)
                    intent.putExtra("cBtn", Btn)
                    intent.putExtra("cgoodnum", goodnum)
                    intent.putExtra("cEdit", Edit)
                    intent.putExtra("cbadnum", badnum)
                    intent.putExtra("cHeart", Heart)
                    startActivity(intent)
                }

        }

<<<<<<< HEAD
        heartcount.setOnClickListener {
            Heart = Heart?.plus(1)!!
=======
        postfireCount.setOnClickListener {
            postfireCount.isClickable = false
            Heart =Heart?.plus(1)
>>>>>>> cfa498e16eed00f2b0ced79c6712053e32969814
        }
    }
}