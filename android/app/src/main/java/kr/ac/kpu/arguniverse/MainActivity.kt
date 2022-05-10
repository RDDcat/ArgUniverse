package kr.ac.kpu.arguniverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kpu.arguniverse.MyModel.Companion.allData
import kr.ac.kpu.arguniverse.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var mainTitle : Button
    lateinit var mainfireCount : TextView
    lateinit var mainviewCount : TextView
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter //adapter객체 먼저 선언해주기!
    var mDatas = mutableListOf<MyModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainTitle = findViewById(R.id.MainTitle)
        mainfireCount = findViewById(R.id.MainfireCount)
        mainviewCount = findViewById(R.id.MainviewCount)
        test()

        mainTitle.setOnClickListener{
           allData[0].add(1)
            mainviewCount.text = allData[0].viewCount.toString()
            //allData[0].viewCount = allData[0].viewCount + 1
            var intent = Intent(applicationContext,post::class.java)
            intent.putExtra("title", allData[0].title)
            intent.putExtra("fireCount", allData[0].fireCount)
            intent.putExtra("viewCount", allData[0].viewCount)
            intent.putExtra("postID", allData[0].postID)
            intent.putExtra("content", allData[0].content)
            startActivity(intent)
        }

        mainTitle.setText(allData[0].title)
        mainfireCount.setText(allData[0].fireCount.toString())
//        mainviewCount.setText(allData[0].viewCount.toString())
        mainviewCount.text = allData[0].viewCount.toString()
        initializelist()
        initRecyclerView()


    }

    fun test(): ArrayList<MyModel> {


        val jsonString = """ 
            {
            "postList": [
            {
                title: "인기글입니다",
                fireCount: 1,
                viewCount: 1,
                postID : 1,
                content : "인기글내용"
            },
            {
                "title": "리사이클1번",
                "fireCount": 2,
                "viewCount": 2,
                "postID" : 2,
                "content" : "리사이클1번내용"
            },
            {
                "title": "리사이클2번",
                "fireCount": 3,
                "viewCount": 3,
                "postID" : 3,
                "content" : "리사이클2번내용"
            },
            {
                title: "리사이클3번",
                fireCount: 4,
                viewCount: 4,
                postID : 4,
                content : "리사이클3번내용"
            },
            {
                title: "리사이클4번",
                fireCount: 5,
                viewCount: 5,
                postID : 5,
                content : "리사이클4번내용"
            }
            ]
        }
        """.trimIndent()

            // openFileOutput("/data/data/kr.ac.kpu.arguniverse/files/MyModel.txt")

        val jsonObject = JSONObject(jsonString)
        val jsonArray = jsonObject.getJSONArray("postList")


        for (i in 0..jsonArray.length() - 1) {

            val iObject = jsonArray.getJSONObject(i)
            allData.add(
                MyModel(
                    iObject.getString("title"),
                    iObject.getInt("fireCount"),
                    iObject.getInt("viewCount"),
                    iObject.getInt("postID"),
                    iObject.getString("content")
                )
            )

        }
        return allData
    }

    fun initRecyclerView() {
        adapter = RecyclerViewAdapter() //어댑터 객체 만듦
        adapter.datalist = mDatas //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this) //레이아웃 매니저 연결
    }

    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        with(mDatas) {
            for(i in 1..allData.size-1 step(1))
                add(MyModel(allData[i].title,allData[i].fireCount, allData[i].viewCount, allData[i].postID,
                    allData[i].content))

        }
    }


}