package com.tgi_confession.tgi_confession_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi_confession.tgi_confession_db.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
