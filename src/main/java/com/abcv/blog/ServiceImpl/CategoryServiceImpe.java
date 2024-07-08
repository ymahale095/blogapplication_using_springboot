package com.abcv.blog.ServiceImpl;

import com.abcv.blog.entities.Category;
import com.abcv.blog.repositories.CategoryRepo;
import com.abcv.blog.services.CategoryServices;
import com.abcv.blog.payloads.CategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpe implements CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
     private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category cat=this.modelMapper.map(categoryDto,Category.class);
        Category addedCat=this.categoryRepo.save(cat);


        return this.modelMapper.map(addedCat,CategoryDto.class);
    }



    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {


        return null;



    }

    @Override
    public void deleteCategory(Integer categoryId) {

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        return null;
    }




    @Override
    public List<CategoryDto> getAllCategory() {



        return null;
    }
}
