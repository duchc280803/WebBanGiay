package com.example.webgiay.service.impl;

import com.example.webgiay.entity.Category;
import com.example.webgiay.repository.CategoryRepository;
import com.example.webgiay.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
