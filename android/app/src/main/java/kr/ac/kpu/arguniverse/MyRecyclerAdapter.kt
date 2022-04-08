package kr.ac.kpu.arguniverse

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kpu.arguniverse.databinding.RecyclerViewItemBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var datalist = mutableListOf<MyModel>()//리사이클러뷰에서 사용할 데이터 미리 정의 -> 나중에 MainActivity등에서 datalist에 실제 데이터 추가
    lateinit var binding : RecyclerViewItemBinding

    inner class MyViewHolder(private val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(myModel:MyModel){
            binding.rebtn.text = myModel.rebtn
            binding.rebtn.setOnClickListener {
                var intent1 = Intent(binding.root.context,post::class.java)
                intent1.putExtra("PostID", myModel.postID)
                intent1.putExtra("Rebtn", myModel.rebtn)
                intent1.putExtra("Reheart", myModel.reheart)
                intent1.putExtra("Rereed", myModel.rereed)
                intent1.putExtra("Content",myModel.content)
                binding.root.context.startActivity(intent1)
            }
            binding.reheart.text = myModel.reheart.toString()
            binding.rereed.text = myModel.rereed.toString()
        }
    }


    //만들어진 뷰홀더 없을때 뷰홀더(레이아웃) 생성하는 함수
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding=RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int =datalist.size

    //recyclerview가 viewholder를 가져와 데이터 연결할때 호출
    //적절한 데이터를 가져와서 그 데이터를 사용하여 뷰홀더의 레이아웃 채움
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(datalist[position])
    }
}