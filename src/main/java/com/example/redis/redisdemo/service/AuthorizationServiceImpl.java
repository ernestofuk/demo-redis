package com.example.redis.redisdemo.service;

import com.example.redis.redisdemo.dao.User;
import com.example.redis.redisdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

  @Autowired
  private UserDao userDao;

  @Override
  public Boolean saveUser(User user) {
    return userDao.saveUser(user);
  }

  @Override
  public User findByName(String name) {
    return userDao.findByName(name);
  }


}
