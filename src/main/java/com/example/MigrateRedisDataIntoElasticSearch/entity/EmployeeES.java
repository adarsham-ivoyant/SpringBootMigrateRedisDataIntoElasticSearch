package com.example.MigrateRedisDataIntoElasticSearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data@ToString
@Document(indexName = "employee")
public class EmployeeES {
    @Id
    private int id;
    private String name;
    private String dept;
}
