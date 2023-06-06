package com.fsd.volunteermicroservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.volunteermicroservices.entity.Volunteer;
import com.fsd.volunteermicroservices.payload.VolunteerDto;
import com.fsd.volunteermicroservices.service.VolunteerService;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {
	@Autowired
	private VolunteerService volunteerService;
	@CrossOrigin(origins = {"http://localhost:3000"})
	@PostMapping
	public VolunteerDto createVolunteer(@RequestBody Volunteer volunteer)
	{
		return volunteerService.saveVolunteer(volunteer);
	}
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping("{volunteer_id}")
	public VolunteerDto getVolunteerBy(@PathVariable(name= "volunteer_id")long volunteer_id)
	{
		return volunteerService.getVolunteerById(volunteer_id);
	}
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping
	private List<Volunteer> getvolunteers() 
	{
	return volunteerService.getAllVolunteers();
	}

}
