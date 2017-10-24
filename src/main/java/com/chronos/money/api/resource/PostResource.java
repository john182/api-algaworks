package com.chronos.money.api.resource;

import com.chronos.money.api.model.Post;
import com.chronos.money.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by john on 19/10/17.
 */
@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostRepository repository;

    @GetMapping
    public List<Post> listar(){
        List<Post> post = repository.findAll();
        return post ;
    }
}
