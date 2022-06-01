package com.kyp.arguniverse.repository;

import com.kyp.arguniverse.domain.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Post save(Post model) {
        em.persist(model);
        return model;
    }

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("select p from post p", Post.class);
        List<Post> postList = query.getResultList();
        return postList;
    }

    @Override
    public Post findByPid(int pid) {
        Post model = em.find(Post.class, pid);
        return model;
    }

    @Override
    public Post findByTitle(String title) {
        Post model = em.find(Post.class, title);
        return model;
    }

}
