package com.achievers.OnlineCourseManagement.entity;

import java.util.ArrayList;
import java.util.List;

/*Course
           - courseId
		- courseName
		- couseDuration
		- courseCost
		- NoOfLearners
*/
public class Course {
	private int courseId;
	private String courseName;
	private int courseDuration;
	private float courseCost;
	private ArrayList<Learner> learnerList;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Course(int courseId, String courseName, int courseDuration, float courseCost) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseCost = courseCost;
		this.learnerList = new  ArrayList<Learner>();
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getCourseDuration() {
		return courseDuration;
	}


	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}


	public float getCourseCost() {
		return courseCost;
	}


	public void setCourseCost(float courseCost) {
		this.courseCost = courseCost;
	}


	public void addLearner(Learner l) {
		this.learnerList.add(l);
	}

	public void removeLearner(Learner l) {
		for(Learner l1:this.learnerList) {
			if(l1.getEnrollmentNo() == l.getEnrollmentNo()) {
				this.learnerList.remove(l1);
			}
		}
	}

	public List<Learner> getLearnerList(){
		return learnerList;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", courseCost=" + courseCost + ", learnerList=" + learnerList + "]";
	}
	
}
