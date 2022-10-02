package com.springboot.airmanagement.service;

import com.springboot.airmanagement.entity.News;
import com.springboot.airmanagement.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository repository;

    @Override
    public List<News> getPosts() {
        return repository.findAll();
    }

    @Override
    public void save(News news) {
        repository.save(news);
    }
}
