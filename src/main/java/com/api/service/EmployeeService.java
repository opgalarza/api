package com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.dto.EmployeeDTO;
import com.api.entity.Employee;
import com.api.mapper.EmployeeMapper;
import com.api.repository.EmployeeDaoJpa;

@Service
@Transactional(readOnly = true)
public class EmployeeService extends GenericService<Employee, EmployeeDTO, EmployeeDaoJpa, EmployeeMapper> {

    @Autowired
    public void setEmployeeDaoJpa(EmployeeDaoJpa employeeDaoJpa) {
        this.daoJpa = employeeDaoJpa;
    }

    @Autowired
    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.mapper = employeeMapper;
    }
    
	@Override
	protected Employee getEntityInstance() {
		return new Employee();
	}
}
