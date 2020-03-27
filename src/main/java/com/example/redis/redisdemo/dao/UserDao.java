package com.example.redis.redisdemo.dao;

public interface UserDao {

  public Boolean saveUser(User user);
  public User findByName(String name);

}
