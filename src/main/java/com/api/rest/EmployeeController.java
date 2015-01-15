package com.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.dto.EmployeeDTO;
import com.api.entity.Employee;
import com.api.exception.CreateEntityException;
import com.api.mapper.EmployeeMapper;
import com.api.repository.EmployeeDaoJpa;
import com.api.service.EmployeeService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/employee")
@Api(value = "Employee", description = "Employee Operations", protocols = "http")
public class EmployeeController extends GenericController<Employee, EmployeeDTO, EmployeeDaoJpa, EmployeeMapper, EmployeeService> {

	

    @Autowired
    public void setEmployeeDaoJpa(EmployeeDaoJpa employeeDaoJpa) {
        this.daoJpa = employeeDaoJpa;
    }

    @Autowired
    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.mapper = employeeMapper;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.service = employeeService;
    }
    
    @ResponseBody
    @RequestMapping(value = "/display", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Display a message", response = EmployeeDTO.class, httpMethod = "GET", notes = "")
    public EmployeeDTO resendEmailConfirmation(){
    	EmployeeDTO employee = new EmployeeDTO();
    	employee.setName("test name");
    	employee.setEmail("test@test.com");
        return employee;
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a new employee", response = EmployeeDTO.class, httpMethod = "POST", produces = "application/json")
    public EmployeeDTO postAffiliate(@RequestBody EmployeeDTO dto) throws CreateEntityException{
        return service.postEntity(dto);
    }
}
