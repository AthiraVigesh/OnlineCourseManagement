package com.achievers.OnlineCourseManagement.entity;

import java.util.ArrayList;
import java.util.List;

/*
 * - Learner
		- enrollmentNo
		- learnerName
		- noOfRegisteredCourse
		- noOfCompletedCourse
 * */
public class Learner {
	private int enrollmentNo;
	private String learnerName;
	private String qualification;
	private ArrayList<Course> registeredCourseList;
	private ArrayList<Course> completedCourseList;
	public Learner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Learner(int enrollmentNo, String learnerName, String qualification) {
		super();
		this.enrollmentNo = enrollmentNo;
		this.learnerName = learnerName;
		this.qualification = qualification;
		registeredCourseList = new ArrayList<Course>();
		completedCourseList = new ArrayList<Course>();
	}
	public int getEnrollmentNo() {
		return enrollmentNo;
	}
	public void setEnrollmentNo(int enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}
	public String getLearnerName() {
		return learnerName;
	}
	public void setLearnerName(String learnerName) {
		this.learnerName = learnerName;
	}
	public void enrollCourse(Course c) {
		this.registeredCourseList.add(c);
	}
	
	public void cancelCourse(Course c) {
		for(Course c1:registeredCourseList) {
			if(c1.getCourseId() == c.getCourseId()) {
				registeredCourseList.remove(c1);
			}
		}
	}
	public void completeCourse(Course c) {
		this.completedCourseList.add(c);
	}
	
	public List<Course> getCompletedCourseList(){
		return this.completedCourseList;
	}
	public List<Course> getRegisteredCourseList(){
		return this.registeredCourseList;
	}
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return enrollmentNo+"-"+learnerName+"-"+qualification+"-"+registeredCourseList+"-"+completedCourseList;
	}
	
	
}
