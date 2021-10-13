package com.randstad.employee_management.repository;

import com.randstad.employee_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    @Query(value = "SELECT count(id) FROM Employee where email = :email")
    public Long count(@Param("email") String email);
}
