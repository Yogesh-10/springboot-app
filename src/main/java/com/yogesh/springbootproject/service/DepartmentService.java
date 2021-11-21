package com.yogesh.springbootproject.service;

import java.util.List;

import com.yogesh.springbootproject.entity.DepartmentEntity;
import com.yogesh.springbootproject.exception.DepartmentNotFoundException;

public interface DepartmentService {

	public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

	public List<DepartmentEntity> getDepartments();

	public DepartmentEntity getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public DepartmentEntity updateDepartment(Long departmentId, DepartmentEntity departmentEntity);

	public DepartmentEntity getDepartmentByName(String departmentName);

	
}
