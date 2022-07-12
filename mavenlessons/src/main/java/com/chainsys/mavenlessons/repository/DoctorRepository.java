package com.chainsys.mavenlessons.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.chainsys.mavenlessons.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
		Doctor findById(int id);
		Doctor save(Doctor dr);
		void deleteById(int id);
		List <Doctor> findAll();
//		@Query(value="select a from Doctor a where a.doc_id=?1")
//		jpql - java persistence query language
//		here 'a' is an instance of Doctor entity
//		List <Doctor> findAllByDoctorId(int drId);
	}


