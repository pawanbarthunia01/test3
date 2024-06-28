package com.test.service;

import com.test.entity.Employee;
import com.test.repository.TestAPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestAPIService {
    @Autowired
    private TestAPIRepository testAPIRepository;

    public String addDataEmployee(List<Employee> emps) {
         if(testAPIRepository.saveAll(emps).size()!=0){
          return "Add data successfully!";
         }else{
             return "Data not save successfully";
         }

    }

    public List<Employee> fetchAllEmployees() {
        if(testAPIRepository.findAll(Sort.by(Sort.Direction.ASC,"name"))!=null){
            return testAPIRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        }else{
            return new ArrayList<>();
        }
    }

}
