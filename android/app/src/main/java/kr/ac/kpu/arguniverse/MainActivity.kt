package kr.ac.kpu.arguniverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kpu.arguniverse.MyModel.Companion.array1
import kr.ac.kpu.arguniverse.databinding.ActivityMainBinding
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    lateinit var btn : Button
    lateinit var heart : TextView
    lateinit var reed : TextView
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter //adapter객체 먼저 선언해주기!
    private lateinit var popular : MyModel
    var mDatas = mutableListOf<MyModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btn = findViewById(R.id.btn)
        heart = findViewById(R.id.heart)
        reed = findViewById(R.id.reed)
        test()
        popular = MyModel(array1[0].title,array1[0].fireCount, array1[0].viewCount, array1[0].postID,
            array1[0].content)


        btn.setOnClickListener{
            popular.viewCount.plus(1)
            var intent = Intent(applicationContext,post::class.java)
            intent.putExtra("PostID", popular.postID )
            intent.putExtra("Reheart", popular.fireCount )
            intent.putExtra("Rebtn", popular.title )
            intent.putExtra("Rereed", popular.viewCount )
            intent.putExtra("Content",popular.content)
            startActivity(intent)
        }

        btn.setText(popular.title)
        heart.setText(popular.fireCount.toString())
        reed.setText(popular.viewCount.toString())

        initializelist()
        initRecyclerView()


    }

    fun initRecyclerView() {
        adapter = RecyclerViewAdapter() //어댑터 객체 만듦
        adapter.datalist = mDatas //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(this) //레이아웃 매니저 연결
    }

    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        with(mDatas) {
            add(MyModel("깻잎논쟁", 123, 112,1,"(설사 지인이라 할지라도) ‘외간 이성’이 붙어있는 깻잎지를 잘 못 떼어먹을 때, 자신의 애인(배우자)이 젓가락으로 깻잎지를 눌러줘도 되는지 ‘허용’과 ‘불허’의 갈림길에 선 건데요."))
            add(MyModel("모프는", 23, 21,2,"모프를 전공으로 하면 돈을 잘 벌까?"))
            add(MyModel("이상호", 3, 3,3,"이상호 교수님은 진짜 탈론을 잘할까?"))
            add(MyModel("교수님", 4, 412,4,"교수님들은 예쁜 여학생한테 더 잘챙겨 주실까?"))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // 1. xml을 이용한 메뉴 만들기
        menuInflater.inflate(R.menu.menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 1. xml을 이용한 메뉴 만들기
        when (item?.itemId) {
            //R.id.item1
            //->
            //R.id.item2
            //->
            //R.id.item3
            //->
            //R.id.item4
            //->
        }
        return super.onOptionsItemSelected(item)
    }
}