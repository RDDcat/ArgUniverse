package com.kyp.arguniverse.repository;

import com.kyp.arguniverse.domain.PostModel;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Integer, PostModel> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public PostModel save(PostModel model) {
        model.setPostID(++sequence);
        store.put(model.getPostID(), model);
        return model;
    }

    @Override
    public List<PostModel> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<PostModel> findByPid(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<PostModel> findByTitle(String title) {
        return store.values().stream()
                .filter(member -> member.getTitle().equals(title))
                .findAny();
    }

    public void clearStore(){
        store.clear();
    }
}
