package com.example.demo.Services;

import com.example.demo.Entity.Blog;

public class ScienceBlogServices extends BlogServicesDecorator{
    public ScienceBlogServices(BlogServices blogServices){
        super(blogServices);
    }

    @Override
    public Blog createBlog(Blog blog) {
        blog.setCategory("Science");
        return super.createBlog(blog);
    }

}
