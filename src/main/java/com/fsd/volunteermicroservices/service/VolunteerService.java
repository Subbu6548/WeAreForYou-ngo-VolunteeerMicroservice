package com.fsd.volunteermicroservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.volunteermicroservices.entity.Volunteer;
import com.fsd.volunteermicroservices.payload.VolunteerDto;


@Service
public interface VolunteerService {
	public  VolunteerDto saveVolunteer(Volunteer volunteer);
	public VolunteerDto getVolunteerById(long id);
	public List<Volunteer> getAllVolunteers();
   
}
