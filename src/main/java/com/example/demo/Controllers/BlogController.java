package com.example.demo.Controllers;

import com.example.demo.Entity.Blog;
import com.example.demo.Entity.User;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repo.BlogRepository;
import com.example.demo.Repo.UserRepository;
import com.example.demo.Services.BlogServices;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogServices blogServices;
    @Autowired
    UserRepository userRepository;
    @PostMapping ("/addBlog")
    public Map<String,String> addBlog(@RequestBody Blog blog){

        User author = userRepository.findById(blog.getAuthor().getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with ID " + blog.getAuthor().getUserId() + " not found"));
        blog.setAuthor(author);
        HashMap<String, String> response = new HashMap<>();
       Blog newBlog =  blogServices.createBlog(blog);
       response.put("id",newBlog.getId().toString());
       response.put("timeAndDate", newBlog.getCreatedAt().toString());
       response.put("userId", newBlog.getAuthor().getUserId().toString());
       return response;
    }

    @GetMapping("/getBlogs")
    public ResponseEntity<List<Blog>> getBlogs(){
        List<Blog> blogs = blogServices.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id){
        blogServices.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable Long id, @RequestBody Blog blog){
        Blog updatedBlog = blogServices.updateBlog(id,blog);
        return ResponseEntity.ok(updatedBlog);
    }
}
