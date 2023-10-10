package com.example.MigrateRedisDataIntoElasticSearch.controller;

import com.example.MigrateRedisDataIntoElasticSearch.entity.Employee;
import com.example.MigrateRedisDataIntoElasticSearch.entity.EmployeeES;
import com.example.MigrateRedisDataIntoElasticSearch.repository.EmpRepoES;
import com.example.MigrateRedisDataIntoElasticSearch.repository.EmpRepoRedis;
import com.example.MigrateRedisDataIntoElasticSearch.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/")
public class HomeController {

    @Autowired
    private EmpRepoRedis empRepoRedis;

    @PostMapping("/addEmp")
    public Employee save(@RequestBody Employee employee){
        return empRepoRedis.save(employee);
    }

    @GetMapping("/GetAllEmp")
    public List<Employee> getAllEmp(){
        return empRepoRedis.findAll();
    }

    @GetMapping("GetById/{id}")
    public Employee findEmpById(@PathVariable int id){
        return (Employee) empRepoRedis.findEmpById(id);
    }

    @DeleteMapping("DeleteById/{id}")
    public String remove(@PathVariable int id){
        return empRepoRedis.deleteEmp(id);
    }


    @Autowired
    private EmpRepoES empRepoES;

    @PostMapping("insertAll")
    public List<Employee> addAll(){
        List<Employee> emp=empRepoRedis.findAll();
        for (Employee employee : emp) {
            EmployeeES employeeES = new EmployeeES();
            employeeES.setId(employee.getId());
            employeeES.setName(employee.getName());
            employeeES.setDept(employee.getDept());
            empRepoES.save(employeeES);
        }
        return emp;
    }


    @Autowired
    private EmpService empService;
    @GetMapping("/GetEmployeeFromES")
    public Iterable<EmployeeES> getAllEmp111() {
        return empService.getAllEmp();
    }
}
