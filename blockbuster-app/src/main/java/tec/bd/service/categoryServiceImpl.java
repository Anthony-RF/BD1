/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tec.bd.service;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.List;
import java.util.Optional;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tec.bd.entity.movieEntity;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//import tec.bd.movies.repository.MovieRepository;
import static java.util.Objects.requireNonNull;
import tec.bd.entity.categoryEntity;
import tec.bd.entity.clientEntity;
import tec.bd.repository.CategoryRepository;
import tec.bd.repository.clientRepository;
/**
 *
 * @author Yarman
 */
public class categoryServiceImpl implements categoryService {
    
    private final FeatureFlags featureFlags;
    private final CategoryRepository categoryRepository;
    
    public categoryServiceImpl(CategoryRepository categoryRepository, FeatureFlags featureFlags){
        requireNonNull(categoryRepository);
        requireNonNull(featureFlags);
        this.featureFlags=featureFlags;
        this.categoryRepository = categoryRepository;
       
        
    }

    @Override
    public List<categoryEntity> getCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<categoryEntity> getCategoryById(int categoryId) {
         return this.categoryRepository.findById(categoryId);
         
         
        
    }

    @Override
    public categoryEntity newCategory(categoryEntity category) {
        requireNonNull(category);
        System.out.println("Creating category...");
        var newCategoryID = this.categoryRepository.save(category);
        System.out.println("New client created with ID "+newCategoryID);
        // Falta Cambiar este metodo
        category.setId(newCategoryID);
        return category;
    }

    @Override
    public void removeCategory(int categoryId) {
        requireNonNull(categoryId);
        System.out.println("Deleting category");
        this.categoryRepository.delete(categoryId);

    }

    @Override
    public categoryEntity updateCategory(categoryEntity category) {
        requireNonNull(category);
        this.categoryRepository.update(category);
        return category;
    }
    @Override
    public void printCategory(categoryEntity category){
        System.out.println(
        "Category ID: " + category.getId()+
                "\nCategory Name: " +category.getName()
                +"\nCategory Description " +category.getDescription()
        );
    }
    
}
