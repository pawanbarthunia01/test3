package com.test.controller;

import com.test.entity.Employee;
import com.test.service.TestAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TestAPIController {
    @Autowired
    private TestAPIService testAPIService;
    @PostMapping("/addData")
    public String addData(@RequestBody List<Employee> emps){
        return testAPIService.addDataEmployee(emps);
  }

    @GetMapping("/fetch")
    public List<Employee> fetchAllEmployee(){
        return testAPIService.fetchAllEmployees();
    }
}
