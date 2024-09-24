package com.example.demo.Services;

import com.example.demo.Entity.Blog;

import java.util.List;

public abstract class BlogServicesDecorator implements BlogServices{
    protected BlogServices blogServices;

    public BlogServicesDecorator(BlogServices blogServices) {
        this.blogServices = blogServices;
    }

    @Override
    public Blog createBlog(Blog blog) {
        return blogServices.createBlog(blog);
    }

    @Override
    public Blog getBlog(Long id) {
        return blogServices.getBlog(id);
    }

    @Override
    public String deleteBlog(Long id) {
        return blogServices.deleteBlog(id);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        return blogServices.updateBlog(id,blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogServices.getAllBlogs();
    }
}
