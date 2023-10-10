package com.example.MigrateRedisDataIntoElasticSearch.repository;

import com.example.MigrateRedisDataIntoElasticSearch.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmpRepoRedis {

    public static final String HASH_KEY="Employee";
    @Autowired
    private RedisTemplate<String,Employee> redisTemplate;
    @Autowired
    public EmpRepoRedis(RedisTemplate<String, Employee> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    private  HashOperations<String,Integer,Employee> hashOperations;



    public Employee save(Employee employee){
        hashOperations.put(HASH_KEY,employee.getId(),employee);
        return employee;
    }
    public List<Employee> findAll(){
        Map<Integer,Employee> employee = hashOperations.entries(HASH_KEY);
        return new ArrayList<>(employee.values());
        //return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Object findEmpById(int id){
        return hashOperations.get(HASH_KEY,id);
    }

    public String deleteEmp(int id){
//            redisTemplate.opsForHash().delete(HASH_KEY,id);
        return "Emp removed";
    }
}
