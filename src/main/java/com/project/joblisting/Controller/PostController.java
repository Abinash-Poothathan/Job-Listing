package com.project.joblisting.Controller;

import com.project.joblisting.Model.Post;
import com.project.joblisting.reposiroty.PostRepository;
import com.project.joblisting.reposiroty.SearchRepository;
import com.project.joblisting.reposiroty.SearchRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;


    @ApiIgnore
    @RequestMapping(value="/")
    @CrossOrigin
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/posts")
    @CrossOrigin
    public List<Post>getAllPosts(){
        return repo.findAll();
    }

    // posts/java
    @GetMapping("/posts{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post ){
       return  repo.save(post);
    }





}


