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
    lateinit var postFinish: Button
    lateinit var posttitle: TextView
    lateinit var postcontent: TextView
    lateinit var postfireCount: Button
    lateinit var postgoodCount: Button
    lateinit var postbadCount: Button
    lateinit var postcomment: EditText
    var goodnum: Int? = 0
    var badnum: Int? = 0
    var iComment: String = ""
    var select : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        posttitle = findViewById(R.id.postTitle)
        postcontent = findViewById(R.id.postContent)
        postfireCount = findViewById(R.id.postFireCount)
        postgoodCount = findViewById(R.id.postGoodCount)
        postbadCount = findViewById(R.id.postBadCount)
        postcomment = findViewById(R.id.postComment)
        postFinish = findViewById<Button>(R.id.postFinish)

        var intent = intent
        var Id = intent.getIntExtra("postID", -1)
        var iFireCount = intent.getIntExtra("fireCount", -1)
        var iViewCount = intent.getIntExtra("viewCount", -1)
        var iTitle = intent.getStringExtra("title")
        var iContent = intent.getStringExtra("content")
        Log.d("test", "id : " + Id)
        Log.d("test", "제목 : " + iTitle)
        Log.d("test", "heart : " + iViewCount)
        Log.d("test", "reed : " + iFireCount)
        Log.d("test", "reed : " + iContent)

        postFinish.setOnClickListener {
            finish()
        }
        posttitle.text = iTitle
        postcontent.text = iContent
        postgoodCount.setOnClickListener {
            if (postcomment.getText().toString().equals("")) {
                Toast.makeText(applicationContext, "자신의 의견을 먼저 써주세요", Toast.LENGTH_SHORT).show()
            } else {
                select = "good"
                goodnum = goodnum?.plus(1)
                iComment = postcomment.text.toString()
                var intent = Intent(applicationContext, comment::class.java)
                intent.putExtra("cTitle", iTitle)
                intent.putExtra("cgoodnum", goodnum)
                intent.putExtra("cComment", iComment)
                intent.putExtra("cbadnum", badnum)
                intent.putExtra("iFireCount",iFireCount)
                intent.putExtra("cselect",select)
                intent.putExtra("cFireCount",iFireCount)
                startActivity(intent)
            }
        }
        postbadCount.setOnClickListener {

            if (postcomment.getText().toString().equals("")) {
                Toast.makeText(applicationContext, "자신의 의견을 먼저 써주세요", Toast.LENGTH_SHORT).show()
            } else {
                select = "bad"
                badnum = badnum?.plus(1)
                iComment = postcomment.text.toString()
                var intent = Intent(applicationContext, comment::class.java)
                intent.putExtra("cTitle", iTitle)
                intent.putExtra("cgoodnum", goodnum)
                intent.putExtra("cComment", iComment)
                intent.putExtra("iFireCount",iFireCount)
                intent.putExtra("cbadnum", badnum)
                intent.putExtra("cselect",select)
                startActivity(intent)
            }

        }


        postfireCount.setOnClickListener {
            iFireCount = iFireCount?.plus(1)!!
            postfireCount.isClickable = false


        }
    }
}
