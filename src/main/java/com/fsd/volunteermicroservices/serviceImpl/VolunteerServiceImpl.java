package com.fsd.volunteermicroservices.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.volunteermicroservices.entity.Volunteer;
import com.fsd.volunteermicroservices.feignclient.ProjectFeign;
import com.fsd.volunteermicroservices.payload.Project;
import com.fsd.volunteermicroservices.payload.VolunteerDto;
import com.fsd.volunteermicroservices.repository.VolunteerRepository;
import com.fsd.volunteermicroservices.service.VolunteerService;
import com.google.gson.Gson;

import feign.Response;


@Service
public class VolunteerServiceImpl implements VolunteerService {	


	@Autowired
	private VolunteerRepository volunteerRepository;
    @Autowired
	private ProjectFeign projectFeign;

	@Override
	public VolunteerDto saveVolunteer(Volunteer volunteer) {
 
 	  Volunteer savedVolunteer=volunteerRepository.save(volunteer);
	Response response = projectFeign.getProjectByCode(savedVolunteer.getVolunteer_project_code());
	VolunteerDto volunteerDto = new VolunteerDto();
   String body=response.body().toString();
   Gson g=new Gson();
   Project project=g.fromJson(body,Project.class);
	volunteerDto.setId(savedVolunteer.getId());
	volunteerDto.setVolunteername(savedVolunteer.getVolunteer_name());

	volunteerDto.setVolunteeremail(savedVolunteer.getVolunteer_email());
	volunteerDto.setVolunteerphno(savedVolunteer.getVolunteer_phno());
	
	volunteerDto.setProjectCode(project.getProjectCode());
	volunteerDto.setProject_name(project.getProject_name());
	volunteerDto.setProject_description(project.getProject_desc());
	volunteerDto.setProjectplace(project.getProjectplace());
	
	return volunteerDto;
}
	
	@Override
	public VolunteerDto getVolunteerById(long id) 
	{

	Volunteer foundDonor = volunteerRepository.findById(id).get();
	Response response = projectFeign.getProjectByCode(foundDonor.getVolunteer_project_code());
	VolunteerDto volunteerDto = new VolunteerDto();
     String body=response.body().toString();
   Gson g=new Gson();
   Project project=g.fromJson(body,Project.class);
	volunteerDto.setId(foundDonor.getId());

	volunteerDto.setVolunteername(foundDonor.getVolunteer_name());

	volunteerDto.setVolunteeremail(foundDonor.getVolunteer_email());
	volunteerDto.setVolunteerphno(foundDonor.getVolunteer_phno());
	volunteerDto.setProjectCode(project.getProjectCode());
     
	volunteerDto.setProject_name(project.getProject_name());
	volunteerDto.setProject_description(project.getProject_desc());
	volunteerDto.setProjectplace(project.getProjectplace());

	return volunteerDto;
	}

}
