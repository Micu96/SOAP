package com.example.soap.demo.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;



@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;
	
	
	@PayloadRoot(namespace="http://in28minutes.com/courses", localPart ="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse courseDetailsResponse (@RequestPayload GetCourseDetailsRequest courseDetailsRequest) {
		 
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		
		Course course = service.findByID(courseDetailsRequest.getId());
		
		
		CourseDetails courseDetails = new CourseDetails();
		
		
			courseDetails.setId(course.getId());
			courseDetails.setName(course.getName());
			courseDetails.setDescription(course.getDescription());
		
		response.setCourseDetails(courseDetails);
		
		return response;
		
	}
	

}
