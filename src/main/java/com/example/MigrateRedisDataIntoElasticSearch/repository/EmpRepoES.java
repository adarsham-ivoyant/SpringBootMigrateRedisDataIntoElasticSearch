package com.example.MigrateRedisDataIntoElasticSearch.repository;

import com.example.MigrateRedisDataIntoElasticSearch.entity.EmployeeES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepoES extends ElasticsearchRepository<EmployeeES,Integer> {
}
