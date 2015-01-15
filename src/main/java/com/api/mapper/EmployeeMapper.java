package com.api.mapper;

import org.springframework.stereotype.Component;

import com.api.dto.EmployeeDTO;
import com.api.entity.Employee;

@Component
public class EmployeeMapper extends GenericMapper<EmployeeDTO, Employee> {

	@Override
	public EmployeeDTO bindDTO(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO bindDTO(Employee entity, String bindMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEntity(EmployeeDTO dto, Employee entity) {
		beanMapper.map(dto, entity);
		return entity;
	}
}
