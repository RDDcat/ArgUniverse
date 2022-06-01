package com.kyp.arguniverse.service;

import com.kyp.arguniverse.domain.Post;
import com.kyp.arguniverse.domain.User;
import com.kyp.arguniverse.repository.MemberRepository;
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


    public static List<Post> postModels = new ArrayList<>();
    static {
        User user = new User(1, "메롱");
        postModels.add(new Post(10007, user, 123, 1, "asdf!@#!@#@", "!@#!@#", 12, 1));
        postModels.add(new Post(10008, user, 123, 1, "asdf!@#!@#@", "!@#!@#", 12, 1));
        postModels.add(new Post(10009, user, 123, 1, "asdf!@#!@#@", "!@#!@#", 12, 1));
        postModels.add(new Post(10010, user, 123, 1, "asdf!@#!@#@", "!@#!@#", 12, 1));
        postModels.add(new Post(10011, user, 123, 1, "asdf!@#!@#@", "!@#!@#", 12, 1));
        postModels.add(new Post(10012, user, 123, 1, "asdf!@#!@#@", "!@#!@#", 12, 1));

    }

    public List<Post> allPost(){ return memberRepository.findAll(); }

    public Post selectPost(int pid){ return memberRepository.findByPid(pid); }

    public Post savePost(Post post){
        return memberRepository.save(post);
    }


}
