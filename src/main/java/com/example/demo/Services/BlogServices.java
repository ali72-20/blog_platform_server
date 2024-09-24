package com.example.demo.Services;

import com.example.demo.Entity.Blog;

import java.util.List;

public interface BlogServices {
    Blog createBlog(Blog blog);
    Blog getBlog(Long id);
    String deleteBlog(Long id);
    Blog updateBlog(Long id, Blog blog);
    List<Blog> getAllBlogs();
}
