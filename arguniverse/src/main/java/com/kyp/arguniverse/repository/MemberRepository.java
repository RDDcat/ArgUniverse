package com.kyp.arguniverse.repository;

import com.kyp.arguniverse.domain.Post;

import java.util.List;

public interface MemberRepository {

    Post save(Post model);
    List<Post> findAll();
    Post findByPid(int pid);
    Post findByTitle(String title);

}
