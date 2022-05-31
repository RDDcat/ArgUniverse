package com.kyp.arguniverse.repository;

import com.kyp.arguniverse.domain.PostModel;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    PostModel save(PostModel model);
    List<PostModel> findAll();
    Optional<PostModel> findByPid(int pid);
    Optional<PostModel> findByTitle(String title);

}
