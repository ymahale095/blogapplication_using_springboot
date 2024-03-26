package com.codewithdurgesh.blog.controllers;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.repositories.UserRepo;
import com.codewithdurgesh.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto userDto){


        UserDto createuserDto =this.userService.createUser(userDto);
        return new ResponseEntity<>(createuserDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser (@RequestBody UserDto userDto,@PathVariable("userId") Integer uid)
    {

       UserDto updateddUser =this.userService.updateUser(userDto,uid);
       return ResponseEntity.ok(updateddUser);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser (@PathVariable("userId")Integer uID)
    {
        this.userService.deleteUser(uID);
          return  new ResponseEntity(Map.of("Message","User Deleted "),HttpStatus.OK);
    }




    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getbyid (@PathVariable Integer userId)
    {

        return ResponseEntity.ok(this.userService.getById(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getallUser());
    }



}
