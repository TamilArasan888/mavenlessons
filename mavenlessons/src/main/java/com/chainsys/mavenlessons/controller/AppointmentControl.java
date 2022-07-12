package com.chainsys.mavenlessons.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.chainsys.mavenlessons.entity.Appointments;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;
import org.springframework.web.servlet.view.RedirectView;
@RestController
public class AppointmentControl {
	@Autowired
	private AppointmentRepository aptRepo;
	
	@GetMapping(value = "/fetchdoctorbyappointmentid")
	public String getDoctorByAppointmentId(int id) {
		Appointments app = aptRepo.findById(id);
		Doctor doc = app.getDoctor();
		return doc.toString();
	}
	
	@GetMapping(value = "/fetchappointment")
	public String getAppointmentById(int id) {
		Appointments app= aptRepo.findById(id);
		return app.toString();
	}
	
//	@GetMapping(value = "/fetchappointmentbydoctor")
//	public List<Appointment> getAppointmentByDocId(int id) {
//		return aptRepo.findAllByDoctorId(id);
//	}
	
	@GetMapping(value = "/fetchallappointments")
	public List<Appointments> getAllAppointments(){
		return aptRepo.findAll();
	}
	
	@PostMapping(value = "/newappointment", consumes = "application/json")
	public RedirectView addAppointment(@RequestBody Appointments apt) {
		 aptRepo.save(apt);
		 return new RedirectView("/fetchallappointments");
	}
	
	@PostMapping(value = "/modifyappointment", consumes = "application/json")
	public RedirectView updateAppointment(@RequestBody Appointments apt) {
		 aptRepo.save(apt);
		 return new RedirectView("/fetchallappointments");
	}
	
	@DeleteMapping(value = "/removeappointment")
	public RedirectView deleteAppointment(int id) {
		aptRepo.deleteById(id);
		 return new RedirectView("/fetchallappointments");
	}
}
