package com.wjahatsyed.portfolio.ai_career_mobility_tool.service;

import com.wjahatsyed.portfolio.ai_career_mobility_tool.dto.EmployeeDto;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.model.Employee;
import com.wjahatsyed.portfolio.ai_career_mobility_tool.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public long addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSkillSet(employeeDto.getSkillSet());
        return employeeRepository.save(employee).getId();
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> {
                    EmployeeDto dto = new EmployeeDto();
                    dto.setId(emp.getId());
                    dto.setName(emp.getName());
                    dto.setEmail(emp.getEmail());
                    dto.setDepartment(emp.getDepartment());
                    dto.setSkillSet(emp.getSkillSet());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void updateEmployee(long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSkillSet(employeeDto.getSkillSet());
        employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
