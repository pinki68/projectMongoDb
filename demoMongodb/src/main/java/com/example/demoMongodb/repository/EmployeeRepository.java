package com.example.demoMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demoMongodb.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {



}
