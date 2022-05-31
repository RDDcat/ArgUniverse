package kr.ac.kpu.arguniverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kpu.arguniverse.MyModel.Companion.myModelData
import kr.ac.kpu.arguniverse.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var hotMainTitle: Button
    lateinit var hotFireCount : TextView
    lateinit var hotViewCount : TextView
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter //adapter객체 먼저 선언해주기!
    var myDatas = mutableListOf<MyModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hotMainTitle = findViewById(R.id.hotMainTitle)
        hotFireCount = findViewById(R.id.hotFireCount)
        hotViewCount = findViewById(R.id.hotViewCount)
        test()
        var max = myModelData[0].viewCount
        for(i in 1..myModelData.size-1 step(1))
        {
            
        }
        hotMainTitle.setOnClickListener{
           myModelData[0].add(1)
            hotViewCount.text = myModelData[0].viewCount.toString()
            //allData[0].viewCount = allData[0].viewCount + 1
            var intent = Intent(applicationContext,post::class.java)
            intent.putExtra("title", myModelData[0].title)
            intent.putExtra("fireCount", myModelData[0].fireCount)
            intent.putExtra("viewCount", myModelData[0].viewCount)
            intent.putExtra("postID", myModelData[0].postID)
            intent.putExtra("content", myModelData[0].content)
            startActivity(intent)
        }

        hotMainTitle.setText(myModelData[0].title)
        hotFireCount.setText(myModelData[0].fireCount.toString())
//        mainviewCount.setText(allData[0].viewCount.toString())
        hotViewCount.text = myModelData[0].viewCount.toString()
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
            myModelData.add(
                MyModel(
                    iObject.getString("title"),
                    iObject.getInt("fireCount"),
                    iObject.getInt("viewCount"),
                    iObject.getInt("postID"),
                    iObject.getString("content")
                )
            )

        }
        return myModelData
    }

    fun initRecyclerView() {
        adapter = RecyclerViewAdapter() //어댑터 객체 만듦
        adapter.datalist = myDatas //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this) //레이아웃 매니저 연결
    }

    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        with(myDatas) {
            for(i in 0..myModelData.size-1 step(1))
                add(MyModel(myModelData[i].title,myModelData[i].fireCount, myModelData[i].viewCount, myModelData[i].postID,
                    myModelData[i].content))

        }
    }


}