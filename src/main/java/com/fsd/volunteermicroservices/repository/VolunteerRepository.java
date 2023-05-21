package com.fsd.volunteermicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.volunteermicroservices.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer,Long> 
{

}
