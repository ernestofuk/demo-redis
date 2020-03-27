package com.example.redis.redisdemo.service;

import com.example.redis.redisdemo.dao.User;

public interface AuthorizationService {

  Boolean saveUser(User user);
  User findByName(String name);
}
