package com.achievers.OnlineCourseManagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.achievers.OnlineCourseManagement.entity.Learner;

public class LearnerList {
private static ArrayList<Learner> learnerList = new ArrayList<Learner>();
	
	public static List<Learner> getLearnerList(){
		
		learnerList = new ArrayList<Learner>();
		learnerList.add(new Learner(1001,"James","Btech"));
		learnerList.add(new Learner(1002,"Smith","MCA"));
		learnerList.add(new Learner(1004,"Sanju","Bsc"));
		
		
		return learnerList;
	}
}
