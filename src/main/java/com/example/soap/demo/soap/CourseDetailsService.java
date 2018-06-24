package com.example.soap.demo.soap;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.soap.demo.soap.*;
@Component
public class CourseDetailsService {
	
	private static List<Course> courses = new ArrayList<>();
	
	static {
	Course course1 = new Course(1, "Spring MVC", "Basic of Spring MVC");
	courses.add(course1);
	Course course2 = new Course(2, "Spring Boot", "Basic of Spring Boot");
	courses.add(course2);
	Course course3 = new Course(3, "Spring Web Services", "Basic of Spring Web Services");
	courses.add(course3);
	}
	
	public Course findByID(int id) {
	
		for(Course course : courses) {
			if(course.getId()==id) {
				return course;
			}
		}
		return null;
	}
	public List<Course> findAll() {
		return courses;
	}
	
	public int deleteByID(int id) {
		
		Iterator<Course> iterator = courses.iterator();
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId()==id) {
				iterator.remove();
				return 1;
			}
		}	
		return 0;
		
	}
	
	

}
