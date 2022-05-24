package com.kyp.arguniverse.service;

import com.kyp.arguniverse.domain.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    public static List<PostModel> postModels = new ArrayList<>();

    static {
        postModels.add(new PostModel("a", 1, 123, 1, "asdf!@#!@#@"));
        postModels.add(new PostModel("b", 1, 123, 2, "asdf!@#!@#@"));
        postModels.add(new PostModel("c", 1, 123, 3, "asdf!@#!@#@"));
        postModels.add(new PostModel("d", 1, 123, 4, "asdf!@#!@#@"));
        postModels.add(new PostModel("e", 1, 123, 5, "asdf!@#!@!#@#@"));
        postModels.add(new PostModel("f", 1, 123, 6, "asdf!@#!@#@"));
        postModels.add(new PostModel("g", 1, 123, 7, "asdf!@#!@//#@"));
        postModels.add(new PostModel("h", 1, 123, 8, "asdf!@#!@#@"));
        postModels.add(new PostModel("i", 1, 123, 9, "asdf!@#!@#@!#@"));
        postModels.add(new PostModel("j", 1, 123, 10, "asdf!@#!@#ㄷㅂ@"));
        postModels.add(new PostModel("k", 1, 123, 11, "asdf!@#!ㅈ@#@"));
        postModels.add(new PostModel("l", 1, 123, 12, "asdf!@#!@#@"));
        postModels.add(new PostModel("m", 1, 123, 13, "asdf!@#!@#ㅁㅇㄹㄴ@"));
        postModels.add(new PostModel("n", 1, 123, 14, "asdf!@#!@#@"));
        postModels.add(new PostModel("o", 1, 123, 15, "asdf!@#!@#ㅁㄴㄹ@"));
        postModels.add(new PostModel("p", 1, 123, 16, "asdf!@#!@#@"));
        postModels.add(new PostModel("q", 1, 123, 17, "asdf!@#!@#23@"));
        postModels.add(new PostModel("r", 1, 123, 18, "asdf!@#!@#@1"));
        postModels.add(new PostModel("s", 1, 123, 19, "asdf!@#!@#@"));
        postModels.add(new PostModel("t", 1, 123, 20, "asdf!@#!@#@"));
    }

    public static List<PostModel> allPost(){
        return postModels;
    }

    public static PostModel selectPost(int pid){
        for(PostModel postModel : postModels){
            if(postModel.getPostID() == pid){
                return postModel;
            }
        }
        return null;
    }

}
