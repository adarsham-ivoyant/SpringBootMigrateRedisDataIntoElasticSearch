package com.example.MigrateRedisDataIntoElasticSearch.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Employee")
public class Employee implements Serializable {
    @Id
    private int id;
    private String name;
    private String dept;
}
