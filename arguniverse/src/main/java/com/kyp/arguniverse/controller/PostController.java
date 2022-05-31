package com.kyp.arguniverse.controller;

import com.kyp.arguniverse.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }


    @GetMapping(value = "/post/new")
    public String createForm() {
        return "/createPostForm";
    }
}
