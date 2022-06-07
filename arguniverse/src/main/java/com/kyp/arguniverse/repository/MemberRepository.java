package com.kyp.arguniverse.repository;

import com.kyp.arguniverse.domain.Comment;
import com.kyp.arguniverse.domain.Post;
import com.kyp.arguniverse.domain.Post_detail;
import com.kyp.arguniverse.domain.Reply;

import java.util.List;

public interface MemberRepository {

    Post save(Post model);
    List<Post> findAll();
    Post findByPid(int pid);
    Post findByTitle(String title);
    List<Post> print_Main();
    List<Post_detail> print_Post();
    List<Comment> print_Comment();
    List<Reply> print_Reply();

}
