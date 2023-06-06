package com.fsd.volunteermicroservices.serviceImpl;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.volunteermicroservices.entity.Volunteer;
import com.fsd.volunteermicroservices.feignclient.ProjectFeign;
import com.fsd.volunteermicroservices.payload.Project;
import com.fsd.volunteermicroservices.payload.VolunteerDto;
import com.fsd.volunteermicroservices.repository.VolunteerRepository;
import com.google.gson.Gson;

import feign.Response;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
public class VolunteerServiceImplTest {

	@InjectMocks
	private VolunteerServiceImpl vser;
	@MockBean
	private ProjectFeign projectfeign;
	

	@Mock
	private VolunteerRepository vrepo;
	
	@Before
	public void setUp() {
		Volunteer volunteer =new Volunteer();
		volunteer.setId(1L);
	    volunteer.setVolunteer_name("subbu");
	    volunteer.setVolunteer_email("subbu6548@gmail.com");
	    volunteer.setVolunteer_project_code(101L);
	    volunteer.setVolunteer_phno(93982828L);
	    volunteer.setVolunteer_address("nellore");
	    Mockito.when(vrepo.save(volunteer)).thenReturn(volunteer);
	    
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
		Mockito.when(vrepo.findAll()).thenReturn(volunteers);
			
	}
	@Test
	 public void saveVolunteer() {
		Volunteer volunteer =new Volunteer();
		VolunteerDto volunteerDto = new VolunteerDto();
		Project project =new Project();

		    project.setId(1L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
		    volunteer.setId(1L);
		    volunteer.setVolunteer_name("subbu");
		    volunteer.setVolunteer_email("subbu6548@gmail.com");
		    volunteer.setVolunteer_project_code(101L);
		    volunteer.setVolunteer_phno(93982828L);
		    volunteer.setVolunteer_address("nellore");
           long i= volunteer.getVolunteer_project_code();
			
        Response response = projectfeign.getProjectByCode(i);
    	VolunteerDto volunteDto = new VolunteerDto();
    vrepo.save(volunteer);
    volunteerDto.setId(volunteer.getId());
	volunteerDto.setVolunteername(volunteer.getVolunteer_name());

	volunteerDto.setVolunteeremail(volunteer.getVolunteer_email());
	volunteerDto.setVolunteerphno(volunteer.getVolunteer_phno());
	
	volunteerDto.setProjectCode(project.getProjectCode());
	volunteerDto.setProject_name(project.getProject_name());
	volunteerDto.setProject_description(project.getProject_desc());
	volunteerDto.setProjectplace(project.getProjectplace());
	
		
		
		verify(vrepo, times(1)).save(volunteer);
		 
	    
	}
	
	@Test
	public void getAllVolunteers() {

		List<Volunteer> volunteers = vser.getAllVolunteers();
		Assert.assertEquals(volunteers.size(), 2);
		
	}
	 @Test
	  public void getVolunteerById()
	  {  
		 Volunteer volunteer =new Volunteer(); 
		 Project project= new Project();
		    project.setId(101L);
		    project.setProject_name("wearetheir");
		    project.setProject_desc("we are there for you");
		    project.setProjectCode(101L);
		    project.setProjectplace("nellore");
		    project.setProjectdate("3-5-23");
		    volunteer.setId(1L);
		    volunteer.setVolunteer_name("subbu");
		    volunteer.setVolunteer_email("subbu6548@gmail.com");
		    volunteer.setVolunteer_project_code(101L);
		    volunteer.setVolunteer_phno(93982828L);
		    volunteer.setVolunteer_address("nellore");
		    vrepo.save(volunteer);	   
		    long i= volunteer.getVolunteer_project_code();
		    Response response = projectfeign.getProjectByCode(i);
		    VolunteerDto volunteerDto = new VolunteerDto(volunteer.getId(),volunteer.getVolunteer_name(),volunteer.getVolunteer_email(),volunteer.getVolunteer_phno(),project.getProjectCode(),
		    		project.getProject_name(),project.getProject_desc(),project.getProjectplace()	);
		 
		    
		    Assert.assertEquals(volunteerDto.getProject_name(),"wearetheir");
	  }
}
