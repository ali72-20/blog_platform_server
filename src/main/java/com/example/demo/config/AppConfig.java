package com.example.demo.config;

import com.example.demo.Repo.BlogRepository;
import com.example.demo.Services.BlogServices;
import com.example.demo.Services.BlogServicesImpl;
import com.example.demo.Services.ScienceBlogServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BlogServices blogServices(BlogRepository blogRepository) {
        return new ScienceBlogServices(new BlogServicesImpl(blogRepository));
    }
}
