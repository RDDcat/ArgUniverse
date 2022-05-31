package com.kyp.arguniverse.controller;
import com.kyp.arguniverse.domain.PostModel;
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
    public Optional<PostModel> test(@PathVariable("pid") int pid){
        return service.selectPost(pid);
    }

    @GetMapping(value = "post")
    public List<PostModel> ttest() {
        return service.allPost();
    }

}



