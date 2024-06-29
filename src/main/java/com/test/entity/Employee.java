package com.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="emp_tbl")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)

    @Column(name="id")
    private Long id;

    private String name;
    private Double salary;
    private String doj;

    private String gender;
    private String client;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", doj='" + doj + '\'' +
                ", gender='" + gender + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}
