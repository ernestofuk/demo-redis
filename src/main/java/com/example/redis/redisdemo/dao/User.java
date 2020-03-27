package com.example.redis.redisdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("User")
public class User {

  @Id
  private Long id;

  private String name;

  private String surname;

  private String age;

}
