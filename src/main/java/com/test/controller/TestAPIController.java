package com.test.controller;

import com.test.entity.Employee;
import com.test.request.FetchDataRequest;
import com.test.service.TestAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @GetMapping("/fetchDetail")
    public ResponseEntity<HashMap<String,Object>> fetchAllEmployee(@RequestBody FetchDataRequest request){
        return new ResponseEntity<>(testAPIService.fetchEmployeeDetails(request), HttpStatus.OK);
    }
}
