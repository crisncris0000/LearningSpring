package com.springboot.airmanagement.repository;

import com.springboot.airmanagement.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
