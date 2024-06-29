package com.test.service;

import com.test.entity.Employee;
import com.test.repository.TestAPIRepository;
import com.test.request.FetchDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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


    public HashMap<String,Object> fetchEmployeeDetails( FetchDataRequest fetchDataRequest){
          HashMap<String,Object> response=new HashMap<>();
        List<Employee> emps=testAPIRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
         List<Employee> startWithCharcter=startWithSpecialCharecter(emps,fetchDataRequest);
          response.put("Step-1","Find name which is start by P");
          response.put("Employee Name",startWithCharcter);
          response.put("Step-2","Find the maximum Salary of Employee");
          Employee maxSalary=findMaxSalaryEmployeed(emps);
          response.put("Employee Salary",startWithCharcter);

        return response;


    }

    private Employee findMaxSalaryEmployeed(List<Employee> emps) {
       return emps.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
    }

    private List<Employee> startWithSpecialCharecter(List<Employee> emps,FetchDataRequest fetchDataRequest) {
        return emps.stream()
                .filter(emp->emp.getName().startsWith(fetchDataRequest.getFilter())).collect(Collectors.toUnmodifiableList());
    }


}
