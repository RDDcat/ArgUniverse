package com.kyp.arguniverse.controller;
import com.kyp.arguniverse.domain.PostModel;
import com.kyp.arguniverse.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/")
public class Controller {
    private PostService service;
    
    public Controller(PostService service){
        this.service = service;
    }

    @GetMapping("post/{pid}")
    public PostModel test(@PathVariable("pid") int pid){
        return service.selectPost(pid);
    }


    @GetMapping(value = "post")
    public List<PostModel> ttest() {
        return service.allPost();
    }

}



