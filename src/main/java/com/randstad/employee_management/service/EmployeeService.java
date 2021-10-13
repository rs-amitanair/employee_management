package com.randstad.employee_management.service;

import com.randstad.employee_management.dto.CountryDto;
import com.randstad.employee_management.dto.EmployeeDto;
import com.randstad.employee_management.model.Country;
import com.randstad.employee_management.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    Employee addEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    void deleteEmployee(Long id);
    List<CountryDto> getAllCountries();
    Long getMail(String email);
    EmployeeDto convertToDTO (Employee employee);
    Employee convertToEntity(EmployeeDto employeeDto);
    CountryDto convertToDTO(Country country);
}
