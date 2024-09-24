package com.example.demo.Controllers;

import com.example.demo.Entity.Blog;
import com.example.demo.Repo.BlogRepository;
import com.example.demo.Services.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogServices blogServices;

    @PostMapping ("/addBlog")
    public Map<String,String> addBlog(@RequestBody Blog blog){
        HashMap<String, String> response = new HashMap<>();
       Blog newBlog =  blogServices.createBlog(blog);
       response.put("id",newBlog.getId().toString());
       response.put("timeAndDate", newBlog.getCreatedAt().toString());
       response.put("userId", newBlog.getAuthor().getUserId().toString());
       return response;
    }

}
