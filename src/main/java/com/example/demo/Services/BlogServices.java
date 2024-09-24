package com.example.demo.Services;

import com.example.demo.Entity.Blog;

import java.util.List;

public interface BlogServices {
    Blog createBlog(Blog blog);
    Blog getBlog(int id);
    Blog deleteBlog(int id);
    Blog updateBlog(int id);
    List<Blog> getAllBlogs();
}
