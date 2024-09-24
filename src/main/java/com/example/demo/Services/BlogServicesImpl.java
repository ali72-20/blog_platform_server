package com.example.demo.Services;

import com.example.demo.Entity.Blog;
import com.example.demo.Repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BlogServicesImpl implements BlogServices{

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Blog createBlog(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElseThrow();
    }

    @Override
    public String deleteBlog(Long id) {
        if(blogRepository.existsById(id)){
            blogRepository.deleteById(id);
            return "Deleted Successfully";
        }else{
            throw new RuntimeException("Task not found");
        }
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        if(blogRepository.existsById(id)){
            blog.setId(id);
            blog.setCreatedAt(LocalDateTime.now());
           return blogRepository.save(blog);
        }else{
            throw new RuntimeException("Task not found");
        }
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}
