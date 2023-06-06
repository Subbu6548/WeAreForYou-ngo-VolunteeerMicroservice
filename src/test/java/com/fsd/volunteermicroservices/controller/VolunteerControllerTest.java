package com.fsd.volunteermicroservices.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fsd.volunteermicroservices.entity.Volunteer;
import com.fsd.volunteermicroservices.payload.VolunteerDto;
import com.fsd.volunteermicroservices.service.VolunteerService;
import com.fsd.volunteermicroservices.payload.Project;



@RunWith(SpringRunner.class)
@WebMvcTest(VolunteerController.class)
public class VolunteerControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private VolunteerService vservice;
	@Test
	public void createVolunteer() throws Exception {
		
		com.fsd.volunteermicroservices.payload.Project project =new com.fsd.volunteermicroservices.payload.Project();
		 project.setId(1L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
		    
		Volunteer volunteer =new Volunteer();
		 volunteer.setId(1L);
		    volunteer.setVolunteer_name("subbu");
		    volunteer.setVolunteer_email("subbu6548@gmail.com");
		    volunteer.setVolunteer_project_code(101L);
		    volunteer.setVolunteer_phno(93982828L);
		    volunteer.setVolunteer_address("nellore");
		    VolunteerDto volunteerDto = new VolunteerDto(volunteer.getId(),volunteer.getVolunteer_name(),volunteer.getVolunteer_email(),volunteer.getVolunteer_phno(),project.getProjectCode(),
		    		project.getProject_name(),project.getProject_desc(),project.getProjectplace()	);
		    
		when(vservice.saveVolunteer(volunteer)).thenReturn(volunteerDto);
		
	}
	@Test
	public void getVolunteers() throws Exception
	{

		
		
		Volunteer volunteer =new Volunteer();
		volunteer.setId(1L);
	    volunteer.setVolunteer_name("subbu");
	    volunteer.setVolunteer_email("subbu6548@gmail.com");
	    volunteer.setVolunteer_project_code(101L);
	    volunteer.setVolunteer_phno(93982828L);
	    volunteer.setVolunteer_address("nellore");
	   
	    Volunteer volunteer1 =new Volunteer();
		volunteer1.setId(1L);
	    volunteer1.setVolunteer_name("karthik");
	    volunteer1.setVolunteer_email("karthik6548@gmail.com");
	    volunteer1.setVolunteer_project_code(102L);
	    volunteer1.setVolunteer_phno(9367328L);
	    volunteer1.setVolunteer_address("nellore");
	    
	    
	    List<Volunteer> volunteers=new ArrayList<Volunteer>();
	    volunteers.add(volunteer);
	    volunteers.add(volunteer1);
	  		when(vservice.getAllVolunteers()).thenReturn(volunteers);

	  		mvc.perform(get("/api/volunteer").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
	  		.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
		
		
	}
	
	@Test 
	public void getVolunteerBy() throws Exception{
		
		Volunteer volunteer =new Volunteer();
		volunteer.setId(1L);
	    volunteer.setVolunteer_name("subbu");
	    volunteer.setVolunteer_email("subbu6548@gmail.com");
	    volunteer.setVolunteer_project_code(101L);
	    volunteer.setVolunteer_phno(93982828L);
	    volunteer.setVolunteer_address("nellore");
	    Project project =new Project();
	    project.setId(1L);
	    project.setProject_name("wearetheir");
	    project.setProject_desc("we are there for you");
	    project.setProjectCode(101L);
	    project.setProjectplace("nellore");
	    project.setProjectdate("3-5-23");

	    VolunteerDto volunteerDto = new VolunteerDto(volunteer.getId(),volunteer.getVolunteer_name(),volunteer.getVolunteer_email(),volunteer.getVolunteer_phno(),project.getProjectCode(),
	    		project.getProject_name(),project.getProject_desc(),project.getProjectplace()	);
		when(vservice.getVolunteerById(101L)).thenReturn(volunteerDto);
		
	}

}
