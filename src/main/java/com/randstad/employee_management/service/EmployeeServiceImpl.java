package com.randstad.employee_management.service;

import com.randstad.employee_management.repository.CountryRepository;
import com.randstad.employee_management.repository.EmployeeRepository;
import com.randstad.employee_management.dto.CountryDto;
import com.randstad.employee_management.dto.EmployeeDto;
import com.randstad.employee_management.model.Country;
import com.randstad.employee_management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CountryRepository countryRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    /**
     *
     * @return list of employees as dto
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList= employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList=new ArrayList<>();
        employeeList.forEach(
                employee -> employeeDtoList.add(convertToDTO(employee))
        );
        return employeeDtoList;
    }

    /**
     *
     * @param employeeDto
     * @return saves employee to database
     */
    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee=convertToEntity(employeeDto);
        return employeeRepository.save(employee);
    }

    /**
     *
     * @param id
     * @return employee with corresponding id
     */
    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new NullPointerException(" Employee not found for id :: " + id);
        }
        return convertToDTO(employee);
    }

    /**
     * @param id
     * delete employee with the id
     */
    @Override
    public void deleteEmployee(Long id) {
        try{
            employeeRepository.deleteById(id);
        }catch (Exception e){
            System.out.print("Employee not found");
        }
    }

    /**
     *
     * @return list of countries as dto
     */
    @Override
    public List<CountryDto> getAllCountries() {
        List<Country> countryList=countryRepository.findAll();
        List<CountryDto> countryDtoList=new ArrayList<>();
        countryList.forEach(
                (country->countryDtoList.add(convertToDTO(country)))
        );
        return countryDtoList;
    }

    /**
     *
     * @param email
     * @return count number of employees with that email
     */
    @Override
    public Long getMail(String email) {
       return employeeRepository.count(email);
    }

    /**
     *
     * @param employee
     * @return employee entity converted to dto
     */
    @Override
    public EmployeeDto convertToDTO(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPassword(employee.getPassword());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setCity(employee.getCity());
        employeeDto.setState(employee.getState());
        employeeDto.setCountryId(employee.getCountry().getId());
        employeeDto.setCountryName(employee.getCountry().getCountryName());
        return employeeDto;
    }

    /**
     *
     * @param employeeDto
     * @return employee dto converted to employee entity
     */
    @Override
    public Employee convertToEntity(EmployeeDto employeeDto) {
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        return employee;
    }

    /**
     *
     * @param country
     * @return country entity converted to employee dto
     */
    @Override
    public CountryDto convertToDTO(Country country){
        CountryDto countryDto=modelMapper.map(country,CountryDto.class);
        return countryDto;
    }
}
