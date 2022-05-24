package kr.ac.kpu.arguniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class comment : AppCompatActivity() {
        lateinit var commentHeartCount : TextView
        lateinit var commentTitle : TextView
        lateinit var commentFinish : Button
        lateinit var commentGoodCount : TextView
        lateinit var goodCommentGoodReCount : Button
        lateinit var goodCommentBadReCount : Button
        lateinit var GoodCommentComment : Button
        lateinit var commentBadCount : TextView
        lateinit var badCommentGoodReCount : Button
        lateinit var badCommentBadReCount : Button
        lateinit var badCommentComment : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        commentHeartCount = findViewById(R.id.commentHeartCount)
        commentTitle =findViewById(R.id.commentTitle)
        commentFinish = findViewById<Button>(R.id.commentFinish)
        commentGoodCount = findViewById(R.id.commentGoodCount)
        goodCommentGoodReCount = findViewById(R.id.goodCommentGoodReCount)
        goodCommentBadReCount = findViewById(R.id.goodCommentBadReCount)
        GoodCommentComment = findViewById(R.id.GoodCommentComment)
        commentBadCount = findViewById(R.id.commentBadCount)
        badCommentGoodReCount = findViewById(R.id.badCommentGoodReCount)
        badCommentBadReCount = findViewById(R.id.badCommentBadReCount)
        badCommentComment = findViewById(R.id.badCommentComment)
        commentFinish.setOnClickListener{
            finish()
        }
        var intent = intent
        var Cgoodnum = intent.getIntExtra("cgoodnum", -1)
        var Cbadnum = intent.getIntExtra("cbadnum", -1)
        var CFireCount = intent.getIntExtra("iFireCount",-1)
        var CTitle = intent.getStringExtra("cTitle")
        var Cselect = intent.getStringExtra("cselect")
        var CComment = intent.getStringExtra("cComment")

        commentTitle.text = CTitle
        commentHeartCount.text = CFireCount.toString()
        if(Cselect == "good"){
            commentGoodCount.text = Cgoodnum.toString()
            GoodCommentComment.text = CComment.toString()
        }
        else if (Cselect == "bad"){
            commentBadCount.text = Cbadnum.toString()
            badCommentComment.text = CComment.toString()
        }
    }
}