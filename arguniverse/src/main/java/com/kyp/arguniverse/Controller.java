package com.kyp.arguniverse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController("/")
public class Controller {

    @GetMapping("post/{pid}")
    public PostModel test(@PathVariable("pid") int id){
        PostModel m = new PostModel("a", 1, 123, 1, "asdf");
        return m;
    }


    @GetMapping(value = "post")
    public String ttest() {
        ArrayList<PostModel> postModelList = new ArrayList<PostModel>();
        postModelList.add(new PostModel("a", 1, 123, 1, "asdf"));
        postModelList.add(new PostModel("b", 123, 123, 1, "asdf"));
        postModelList.add(new PostModel("c", 13244, 123, 1, "asdf"));

        JsonArray jsonArray = new JsonArray();
        for (PostModel pm : postModelList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("title", pm.getTitle());
            jsonObject.addProperty("fireCount", pm.getFireCount());
            jsonObject.addProperty("viewCount", pm.getViewCount());
            jsonObject.addProperty("postID", pm.getPostID());
            jsonObject.addProperty("content", pm.getContent());

            jsonArray.add(jsonObject);
        }


        return jsonArray.toString();
    }

}



