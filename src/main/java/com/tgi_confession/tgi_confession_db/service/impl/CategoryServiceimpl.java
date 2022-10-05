package com.tgi_confession.tgi_confession_db.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tgi_confession.tgi_confession_db.dto.CategoryDto;
import com.tgi_confession.tgi_confession_db.model.Category;
import com.tgi_confession.tgi_confession_db.repository.CategoryRepository;
import com.tgi_confession.tgi_confession_db.service.CategoryService;

@Service
public class CategoryServiceimpl extends BaseServiceimpl<CategoryDto, List<Category>, String, Category>
        implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    protected JpaRepository<Category, String> getModelRepository() {
        return categoryRepository;
    }

    @Override
    protected Category getCreateRespond(CategoryDto modelDto) {
        Category category = new Category(UUID.randomUUID().toString(), modelDto.getName(), "Active");
        return category;
    }

    @Override
    protected Category getUpdateRespond(String id, CategoryDto modelDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.get();
        category.setName(modelDto.getName());
        return categoryRepository.save(category);
    }

}
