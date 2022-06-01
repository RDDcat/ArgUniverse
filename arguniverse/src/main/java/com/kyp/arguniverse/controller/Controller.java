package com.kyp.arguniverse.controller;
import com.kyp.arguniverse.domain.Post;
import com.kyp.arguniverse.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController("/")
public class Controller {
    private PostService service;

    @Autowired
    public Controller(PostService service){
        this.service = service;
    }

    @GetMapping("post/{pid}")
    public Optional<Post> test(@PathVariable("pid") int pid){
        return Optional.ofNullable(service.selectPost(pid));
    }

    @GetMapping(value = "post")
    public List<Post> ttest() {
        return service.allPost();
    }

}



