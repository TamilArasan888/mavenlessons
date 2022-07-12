package com.chainsys.mavenlessons.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Appointments")
public class Appointments {
	@Id
	@Column(name = "APP_ID")
	private int id;
	@Column(name = "APP_DATE")
	private Date appointDate;
	@Column(name = "PATIENT_NAME")
	private String patName;
	@Column(name = "FEES_COLLECTED")
	private float fee;
	@Column(name = "DOCT_ID")
	private int docId;
	
	// @JoinColumn maps the column of the current Entity Application
	// with the PrimaryKey column(id) of the associated Entity Doctor
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCT_ID" , nullable = false,
	insertable = false ,updatable = false)
	@JsonIgnore
	private Doctor doctor; // It points to an Entity class
	public Doctor getDoctor() {  
		return this.doctor;
	}
	public void setDoctor(Doctor doc) {
		this.doctor=doc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	
	public float getFee() {    
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
//	public int getDocId() {
//		return docId;
//	}
//	public void setDocId(int docId) {
//		this.docId = docId;
//	}
	@Override
	public String toString() {
		return String.format("%d, %s, %s, %.2f",id, 
				appointDate, patName, fee );
	}
	

}
