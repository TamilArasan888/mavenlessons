package com.chainsys.mavenlessons.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.chainsys.mavenlessons.entity.Appointments;

public interface AppointmentRepository extends CrudRepository<Appointments,Integer>{
	Appointments findById(int id);
	Appointments save(Appointments apt);
	Appointments deleteById(int id);
	List <Appointments> findAll();
//	@Query(value="select a from Appointments a where a.doc_id=?1")
//	jpql - java persistence query language
//	here 'a' is an instance of Appointments entity
	List <Appointments> findByDoctorId(int drId);
}
