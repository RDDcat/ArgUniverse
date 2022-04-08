package kr.ac.kpu.arguniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class comment : AppCompatActivity() {
    lateinit var finish2 : Button
    lateinit var Cgoodcount : TextView
    lateinit var Cbadcount :TextView
    lateinit var Cedit : TextView
    lateinit var cname : TextView
    lateinit var CheartCount : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        Cgoodcount = findViewById(R.id.Cgoodcount)
        Cbadcount = findViewById(R.id.Cbadcount)
        CheartCount = findViewById(R.id.Cheartcount)
        Cedit = findViewById(R.id.Cedit)
        cname =findViewById(R.id.cname)
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
        Cedit.text =CEdit

    }
}
