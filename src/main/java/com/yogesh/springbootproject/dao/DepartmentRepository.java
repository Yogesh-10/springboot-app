package com.yogesh.springbootproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yogesh.springbootproject.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{

	//defining custom methods - for JPA Repository

	DepartmentEntity findByDepartmentName(String departmentName);

	DepartmentEntity findByDepartmentNameIgnoreCase(String departmentName);

}
