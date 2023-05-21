package com.fsd.volunteermicroservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="volunteer", uniqueConstraints={
        @UniqueConstraint(columnNames= {"volunteer_phno"})
 })
public class Volunteer {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     private long id;
     
    @Column (nullable = false)
    private String volunteer_name;
    
    @Column (nullable = false)
    private String volunteer_email;
    
    @Column (nullable = false)
    private long volunteer_project_code ;
    
    @Column (nullable = false)
    private long volunteer_phno ;

    @Column (nullable = false)
    private String volunteer_address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVolunteer_name() {
		return volunteer_name;
	}

	public void setVolunteer_name(String volunteer_name) {
		this.volunteer_name = volunteer_name;
	}

	public String getVolunteer_email() {
		return volunteer_email;
	}

	public void setVolunteer_email(String volunteer_email) {
		this.volunteer_email = volunteer_email;
	}

	public long getVolunteer_project_code() {
		return volunteer_project_code;
	}

	public void setVolunteer_project_code(long volunteer_project_code) {
		this.volunteer_project_code = volunteer_project_code;
	}

	public long getVolunteer_phno() {
		return volunteer_phno;
	}

	public void setVolunteer_phno(long volunteer_phno) {
		this.volunteer_phno = volunteer_phno;
	}

	public String getVolunteer_address() {
		return volunteer_address;
	}

	public void setVolunteer_address(String volunteer_address) {
		this.volunteer_address = volunteer_address;
	}

	public Volunteer(long id, String volunteer_name, String volunteer_email, long volunteer_project_code,
			long volunteer_phno, String volunteer_address) {
		super();
		this.id = id;
		this.volunteer_name = volunteer_name;
		this.volunteer_email = volunteer_email;
		this.volunteer_project_code = volunteer_project_code;
		this.volunteer_phno = volunteer_phno;
		this.volunteer_address = volunteer_address;
	}

	public Volunteer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", volunteer_name=" + volunteer_name + ", volunteer_email=" + volunteer_email
				+ ", volunteer_project_code=" + volunteer_project_code + ", volunteer_phno=" + volunteer_phno
				+ ", volunteer_address=" + volunteer_address + "]";
	}
  
    
}
