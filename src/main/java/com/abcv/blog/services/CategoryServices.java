package com.abcv.blog.services;

import com.abcv.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryServices {

    // create
      CategoryDto createCategory(CategoryDto categoryDto);


    //update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);
    //get








    CategoryDto getCategory (Integer categoryId);

    //getall

    List<CategoryDto> getAllCategory();
}
