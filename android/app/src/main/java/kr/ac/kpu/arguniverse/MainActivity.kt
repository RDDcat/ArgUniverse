package kr.ac.kpu.arguniverse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.kpu.arguniverse.databinding.ActivityMainBinding

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
        popular = MyModel("케이크 논쟁", 12, 3, 0,"\n" +
                "친구가 너 생일이라 케이크를 삼\n" +
                "\n" +
                "근데 친구가 케이크 사놓고 너 기다리고 있는데\n" +
                "배도 고프고 딱히 밥 먹을 곳도 없고 해서\n" +
                "케이크 5분의 1조각 정도 칼로 썰어서 덜어먹음\n" +
                "\n" +
                "너가 딱 케이크 받았을 땐 케이크가 잘려있길래 물어보니까\n" +
                "“내가 너 기다리다가 너무 배고파서 먹었어… 미안해….ㅜㅜㅜㅜ”\n" +
                "라고 하면 너네 기분 어떰?\n" +
                "\n" +
                "전자는 아니 아무리 그래도 나 줄 거라면서 그걸 먹냐\n" +
                "후자는 너무 배고팠으면 그럴 수 있지 받은 것만으로도 기분 좋다\n" +
                "\n" +
                "이거 의외로 갈림")


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
            add(MyModel("깬잎논쟁", 123, 112,1,"(설사 지인이라 할지라도) ‘외간 이성’이 붙어있는 깻잎지를 잘 못 떼어먹을 때, 자신의 애인(배우자)이 젓가락으로 깻잎지를 눌러줘도 되는지 ‘허용’과 ‘불허’의 갈림길에 선 건데요."))
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