package com.test.repository;

import com.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestAPIRepository extends JpaRepository<Employee,Long> {
}
