package kr.ac.kpu.arguniverse

data class MyModel(
    val title :String, // 제목
    val fireCount : Int, // 공감(활활타오르는거)
    val viewCount : Int, // 조회수
    val postID : Int, // 글 아이디
    val content : String // 내용
)