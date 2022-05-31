package com.kyp.arguniverse.service;

import com.kyp.arguniverse.domain.PostModel;
import com.kyp.arguniverse.repository.MemberRepository;
import com.kyp.arguniverse.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final MemberRepository memberRepository;

    public PostService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /*public static List<PostModel> postModels = new ArrayList<>();
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
    }*/

    public int newPost(PostModel model){
        //validateDuplicateMember(model);
        memberRepository.save(model);
        return model.getPostID();
    }

    //중복 Title 여부
    /*private void validateDuplicateMember(PostModel model) {
        memberRepository.findByTitle(model.getTitle())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 글입니다.");
                });
    }*/

    public List<PostModel> allPost(){ return memberRepository.findAll(); }

    public Optional<PostModel> selectPost(int pid){ return memberRepository.findByPid(pid); }


}
