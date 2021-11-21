package com.yogesh.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogesh.springbootproject.dao.DepartmentRepository;
import com.yogesh.springbootproject.entity.DepartmentEntity;
import com.yogesh.springbootproject.exception.DepartmentNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
		return departmentRepository.save(departmentEntity);
	}

	@Override
	public List<DepartmentEntity> getDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public DepartmentEntity getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		//return departmentRepository.findById(departmentId).get(); //get() is used here because this findById
		//returns optional, so get() is used to fetch the value from optional.
		
		Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
		
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not found");
		}
		
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public DepartmentEntity updateDepartment(Long departmentId, DepartmentEntity departmentEntity) {
		DepartmentEntity departmentFromDB =  departmentRepository.findById(departmentId).get();
		
		//check responseBody(department Entity), if any field is null skip it, if there is a value update it
		if(departmentEntity.getDepartmentName() != null) {
			departmentFromDB.setDepartmentName(departmentEntity.getDepartmentName());
		}
		
		if(departmentEntity.getDepartmentCode() != null) {
			departmentFromDB.setDepartmentCode(departmentEntity.getDepartmentCode());
		}
		
		if(departmentEntity.getDepartmentAddress() != null) {
			departmentFromDB.setDepartmentAddress(departmentEntity.getDepartmentAddress());
		}
		
		return departmentRepository.save(departmentFromDB);
	}
	
	public DepartmentEntity getDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}
}
