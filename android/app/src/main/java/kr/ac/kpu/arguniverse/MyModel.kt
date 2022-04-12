package kr.ac.kpu.arguniverse



class MyModel(
    var title: String,
    var fireCount: Int,
    var viewCount: Int,
    var postID: Int,
    var content: String
) {


    companion object {
        var allData = ArrayList<MyModel>()
    }

    fun add(x : Int) {
        this.viewCount = this.viewCount+x
    }



}



