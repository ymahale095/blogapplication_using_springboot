package com.abcv.blog.repositories;

import com.abcv.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer>


{

}
