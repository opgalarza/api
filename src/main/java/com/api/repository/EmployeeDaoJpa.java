package com.api.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.api.entity.Employee;

@Repository
@Transactional(readOnly = true)
public interface EmployeeDaoJpa extends GenericDaoJpa<Employee, Integer> {

}
