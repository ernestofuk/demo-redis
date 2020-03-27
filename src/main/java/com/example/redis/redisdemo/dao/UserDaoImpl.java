package com.example.redis.redisdemo.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

  @Autowired
  private RedisTemplate redisTemplate;

  private static final String KEY = "user";

  @Override
  public Boolean saveUser(User user) {
    try {
      Map userHash = new ObjectMapper().convertValue(user, Map.class);
      redisTemplate.opsForHash().put(KEY, user.getName(), userHash);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public User findByName(String name) {
    Map userMap = (Map) redisTemplate.opsForHash().get(KEY, name);
    User user = new ObjectMapper().convertValue(userMap, User.class);
    return user;
  }
}
