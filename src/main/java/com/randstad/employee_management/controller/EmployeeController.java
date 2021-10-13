package com.randstad.employee_management.controller;

import com.randstad.employee_management.dto.CountryDto;
import com.randstad.employee_management.dto.EmployeeDto;
import com.randstad.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<EmployeeDto> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee",listEmployee);
        model.setViewName("home");
        return model;
    }


    @GetMapping("/newEmployee")
    public ModelAndView newContact(ModelAndView model) {
        EmployeeDto employeeDto = new EmployeeDto();
        List<CountryDto> countryList=employeeService.getAllCountries();
        model.addObject("countryList",countryList);
        model.addObject("employee", employeeDto);
        model.setViewName("employeeForm");
        return model;
    }


    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(EmployeeDto employeeDto) throws IOException {
        employeeService.addEmployee(employeeDto);
        return new ModelAndView("redirect:/");
    }


    @GetMapping("/editEmployee")
    public ModelAndView editContact(HttpServletRequest request) {
        Long employeeId = Long.parseLong(request.getParameter("id"));
        List<CountryDto> countryList=employeeService.getAllCountries();
        EmployeeDto employeedto = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("employeeForm");
        model.addObject("countryList",countryList);
        model.addObject("employee", employeedto);
        return model;
    }


    @GetMapping("/deleteEmployee")
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        Long employeeId = Long.parseLong(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/validateMail")
    @ResponseBody
    public boolean emailValidation(HttpServletRequest request){
        String mail=request.getParameter("email");
        Long res=employeeService.getMail(mail);
        System.out.print(res);
        if(res==0)
            return true;
        else
            return false;
    }
}
