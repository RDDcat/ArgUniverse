package kr.ac.kpu.arguniverse

import org.json.JSONObject
import java.io.File
import java.io.FileInputStream

class MyModel(
    val title: String,
    val fireCount: Int,
    val viewCount: Int,
    val postID: Int,
    val content: String
) {


    companion object {
        var array1 = ArrayList<MyModel>()
    }



}


fun test(): ArrayList<MyModel> {


    val jsonString = openFileOutput("/data/data/kr.ac.kpu.arguniverse/files/MyModel.txt")

    val jsonObject = JSONObject(jsonString)
    val jsonArray = jsonObject.getJSONArray("person")
    //val jsonObject = JSONObject(jsonString)
    // val jsonArray = jsonObject.getJSONArray("person")

    for (i in 0..jsonArray.length() - 1) {

        val iObject = jsonArray.getJSONObject(i)
        MyModel.array1.add(
            MyModel(
                iObject.getString("title"),
                iObject.getInt("fireCount"),
                iObject.getInt("viewCount"),
                iObject.getInt("postID"),
                iObject.getString("content")
            )
        )

    }
    return MyModel.array1
}
