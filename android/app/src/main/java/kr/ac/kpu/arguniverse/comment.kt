package kr.ac.kpu.arguniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class comment : AppCompatActivity() {
    lateinit var finish2 : Button
    lateinit var commentGoodcount : TextView
    lateinit var coomentBadcount :TextView
    lateinit var Cedit : TextView
    lateinit var commentTitle : TextView
    lateinit var commentHeartcount : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        commentGoodcount = findViewById(R.id.commentGoodcount)
        coomentBadcount = findViewById(R.id.commentBadcount)
        commentHeartcount = findViewById(R.id.commentHeartcount)
        Cedit = findViewById(R.id.Cedit)
        commentTitle =findViewById(R.id.commentTitle)
        finish2 = findViewById<Button>(R.id.finish2)
        finish2.setOnClickListener{
            finish()
        }
        var intent = intent
        var Cgoodnum = intent.getIntExtra("cgoodnum", -1)
        var Cbadnum = intent.getIntExtra("cbadnum", -1)
        var CHeart = intent.getIntExtra("cHeart", -1)
        var CBtn = intent.getStringExtra("cBtn")
        var CEdit = intent.getStringExtra("cEdit")

        CheartCount.text = CHeart.toString()
        Cgoodcount.text = Cgoodnum.toString()
        Cbadcount.text = Cbadnum.toString()
        cname.text = CBtn
        Cedit.text = CEdit.toString()

    }
}