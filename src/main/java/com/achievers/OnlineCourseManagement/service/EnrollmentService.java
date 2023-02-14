package com.achievers.OnlineCourseManagement.service;

import com.achievers.OnlineCourseManagement.entity.Course;
import com.achievers.OnlineCourseManagement.entity.Learner;

public class EnrollmentService {
	private CourseService cSvc = new CourseService();
	private LearnerService lSvc = new LearnerService();
	
	public String enrollCourse(int courseId, int enrollmentNo)
	{
		
		Course c = cSvc.getCourse(courseId);
		
		Learner l = lSvc.getLearner(enrollmentNo);
		
		if(c != null && l!= null) {
			c.addLearner(l);
			l.enrollCourse(c);
			System.out.println(c);
			System.out.println(l);
			return "Enrolled Successsfully";
		}
		return "Invalid Input";
	}
	
	public String cancelCourse(int courseId, int enrollmentNo) {
		Course c = cSvc.getCourse(courseId);
		Learner l = lSvc.getLearner(enrollmentNo);
		if(c!=null && l!=null) {
			c.removeLearner(l);
			l.cancelCourse(c);
			return "Cancelled Successfully";
		}
		return "Invalid Input";
	}
	
	public String certifyLearner(int courseId, int enrollmentNo) {
		
		Learner l = lSvc.getLearner(enrollmentNo);
		if(l!=null) {
			for(Course c1:l.getRegisteredCourseList()) {
				if(c1.getCourseId() == courseId) {
					l.completeCourse(c1);
					return "Certified Successfully";
				}
			}
		}
		return "Invalid Input";
	}
}
