package com.example.MigrateRedisDataIntoElasticSearch.service;

import com.example.MigrateRedisDataIntoElasticSearch.entity.EmployeeES;
import com.example.MigrateRedisDataIntoElasticSearch.repository.EmpRepoES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired
    private EmpRepoES empRepoES;

    public Iterable<EmployeeES> getAllEmp() {
        return empRepoES.findAll();
    }


}
