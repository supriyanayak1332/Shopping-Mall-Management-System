package com.example.shoppingmall.repository;

import org.springframework.data.repository.CrudRepository;
//repository--comunicates with the data base

import com.example.shoppingmall.entity.User;

public interface Userrepository extends CrudRepository<User,Long> {

}
