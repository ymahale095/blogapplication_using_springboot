package com.abcv.blog.ServiceImpl;

import com.abcv.blog.entities.User;
import com.abcv.blog.exceptions.ResourceNotFoundException;
import com.abcv.blog.payloads.UserDto;
import com.abcv.blog.services.UserService;
import com.abcv.blog.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImp implements UserService {

    @Autowired
      private  UserRepo userRepo;


    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {

         User user=this.dtotoUser(userDto);
         User saveUser =this.userRepo.save(user);
         return this.usertoDto(saveUser);


     }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));

        user.setName(userDto.getName());

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updateduser = this.userRepo.save(user);
        UserDto userDto1=this.usertoDto(updateduser);

        return userDto1;
    }

    @Override
    public UserDto getById(Integer userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        return this.usertoDto(user);
    }

    @Override
    public List<UserDto> getallUser() {

        List<User> users=this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(user -> this.usertoDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);
       return null;
    }


    private User dtotoUser(UserDto userDto)
    {
        User user=this.modelMapper.map(userDto,User.class);




        /* user.setName(userDto.getName());
         user.setId(userDto.getId());
         user.setEmail(userDto.getEmail());
         user.setPassword(userDto.getPassword());
         user.setAbout(userDto.getAbout());*/
         return user;

    }

    private UserDto usertoDto (User user)
    {
        UserDto userDto=this.modelMapper.map(user,UserDto.class);
       /* userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());*/
        return userDto;

    }
}
