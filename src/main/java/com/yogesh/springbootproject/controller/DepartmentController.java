package com.yogesh.springbootproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yogesh.springbootproject.entity.DepartmentEntity;
import com.yogesh.springbootproject.exception.DepartmentNotFoundException;
import com.yogesh.springbootproject.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/departments")         //@valid is used to validate, which is defined in entity
	public DepartmentEntity savDepartment(@Valid @RequestBody DepartmentEntity departmentEntity) {
		return departmentService.saveDepartment(departmentEntity);
	}
	
	@GetMapping("/departments")
	public List<DepartmentEntity> getDepartments() {
		return departmentService.getDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public DepartmentEntity getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException{
		return departmentService.getDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "department deleted successfully";
	}
	
	
	@PutMapping("/departments/{id}")
	public DepartmentEntity updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentEntity departmentEntity) {
		return departmentService.updateDepartment(departmentId, departmentEntity);
	}
	
	
	@GetMapping("/departments/name/{name}")
    public DepartmentEntity fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
	
}
