package com.springboot.airmanagement.service;

import com.springboot.airmanagement.entity.News;

import java.util.List;

public interface NewsService {

    public List<News> getPosts();

    public void save(News news);
}
