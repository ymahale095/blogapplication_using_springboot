package com.abcv.blog.services;

import com.abcv.blog.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser (UserDto user);

    UserDto updateUser (UserDto user,Integer userId);


    UserDto getById(Integer userId);




    List<UserDto> getallUser();


    UserDto deleteUser(Integer userId);
}
