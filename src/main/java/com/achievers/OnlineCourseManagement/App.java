package com.achievers.OnlineCourseManagement;

import java.util.Scanner;

import com.achievers.OnlineCourseManagement.entity.Course;
import com.achievers.OnlineCourseManagement.entity.Learner;
import com.achievers.OnlineCourseManagement.service.CourseService;
import com.achievers.OnlineCourseManagement.service.EnrollmentService;
import com.achievers.OnlineCourseManagement.service.LearnerService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		CourseService cSvc = new CourseService();
		LearnerService lSvc = new LearnerService();
		EnrollmentService enSvc = new EnrollmentService();
		int mOption = 0;
		System.out.println("Welcome to Online Course Enrollment System");
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Main Menu\n1.Course Management \n2.Learner Management\n3Enrollment Management\n4.Exit\n");
		System.out.println("Enter your choice: ");
		mOption = ip.nextInt();
		while (mOption == 1 || mOption == 2 || mOption == 3) {
			switch (mOption) {
			case 1:

				int sOption = 0;
				int cID = 0;
				String cName = "";
				int cDuration = 0;
				float cCost = 0.0f;
				Course c;

				System.out.println("\nCourse Management");
				System.out.println("-----------------");
				System.out.println(
						"\n1.Add Course\n2.View Course\n3.View All Courses\n4.update COurse\n5.Delete Course\n6.Exit");

				System.out.println("Enter your choice: ");
				sOption = ip.nextInt();

				switch (sOption) {
				case 1:
					System.out.println("Add a Course");
					System.out.println("Enter the Course ID:");
					cID = ip.nextInt();
					System.out.println("Enter the Course Name:");
					cName = ip.next();
					System.out.println("Enter the Course Duration:");
					cDuration = ip.nextInt();
					System.out.println("Enter the Course Cost:");
					cCost = ip.nextFloat();
					c = new Course(cID, cName, cDuration, cCost);
					System.out.println(cSvc.addCourse(c));
					break;
				case 2:
					System.out.println("View a Course");
					System.out.println("Enter the Course ID:");
					cID = ip.nextInt();
					c = cSvc.getCourse(cID);
					if (c != null)
						System.out.println(c);
					else
						System.out.println("Course Unavilable");
					break;
				case 3:
					System.out.println("View " + cSvc.getAllCourse().size() + " Course");
					System.out.println("CID\tCNAME\tCDURATION    CCOST   \tNoOfLearners");
					for (Course c1 : cSvc.getAllCourse()) {
						System.out
								.println(c1.getCourseId() + "\t" + c1.getCourseName() + "\t   " + c1.getCourseDuration()
										+ "\t    " + c1.getCourseCost() + "\t   " + c1.getLearnerList().size());
					}
					System.out.println();
					break;
				case 4:
					System.out.println("Update a Course");
					System.out.println("Enter the Course ID:");
					cID = ip.nextInt();
					System.out.println("Enter the Course Name:");
					cName = ip.next();
					System.out.println("Enter the Course Duration:");
					cDuration = ip.nextInt();
					System.out.println("Enter the Course Cost:");
					cCost = ip.nextFloat();
					c = new Course(cID, cName, cDuration, cCost);
					System.out.println(cSvc.updateCourse(cID, c));
					break;
				case 5:
					System.out.println("Delete a Course");
					System.out.println("Enter the Course ID:");
					cID = ip.nextInt();
					System.out.println(cSvc.deleteCourse(cID));
					break;
				case 6:
					System.out.println("Thank you for working with Course Management..");
					break;
				default:
					System.out.println("Wrong Option");
					break;
				}
				break;

			// LEARNER INFORMATION

			case 2:

				int sOption1 = 0;
				int EnrollmentNumber = 0;
				String lName = "";
				String Qualification = "";
				Learner l;

				System.out.println("\nLearner Management");
				System.out.println("-----------------");
				System.out.println(
						"\n1.Add Learner\n2.View Learner\n3.View All Learner\n4.update Learner\n5.Delete Learner\n6.List Registered Course\n7.List Completed Course\n8.Exit");

				System.out.println("Enter your choice: ");
				sOption1 = ip.nextInt();

				switch (sOption1) {

				case 1:

					System.out.println("Add a Learner");
					System.out.println("Enter the Learner EnrollmentNo :");
					EnrollmentNumber = ip.nextInt();
					System.out.println("Enter the Learner Name:");
					lName = ip.next();
					System.out.println("Enter the Learner Qualification:");
					Qualification = ip.next();

					l = new Learner(EnrollmentNumber, lName, Qualification);
					System.out.println(lSvc.addLearner(l));
					break;

				case 2:
					System.out.println("View a Learner");
					System.out.println("Enter the EnrollmentNo ");
					EnrollmentNumber = ip.nextInt();
					l = lSvc.getLearner(EnrollmentNumber);
					if (l != null)
						System.out.println(l);
					else
						System.out.println("Learner Unavilable");
					break;

				case 3:
					System.out.println("View " + lSvc.getAllLearner().size() + " Learner");
					System.out.println("EnrollmentNumber\t LearnerNAME\t  LearnerQualification");
					for (Learner l1 : lSvc.getAllLearner()) {
						System.out.println(
								l1.getEnrollmentNo() + "\t" + l1.getLearnerName() + "\t   " + l1.getQualification());
					}
					System.out.println();
					break;

				case 4:
					System.out.println("Update a Learner");
					System.out.println("Enter the EnrollmentNumber");
					EnrollmentNumber = ip.nextInt();
					System.out.println("Enter the Learner Name:");
					lName = ip.next();

					l = new Learner(EnrollmentNumber, lName, Qualification);
					System.out.println(lSvc.updateLearner(EnrollmentNumber, l));
					break;

				case 5:
					System.out.println("Delete a Learner");
					System.out.println("Enter EnrollmentNumber :");
					EnrollmentNumber = ip.nextInt();
					System.out.println(lSvc.deleteLearner(EnrollmentNumber));
					break;

				case 6:
					System.out.println("Registered Course List");
					System.out.println("Enter EnrollmentNumber :");
					EnrollmentNumber = ip.nextInt();
					for (Course c1 : lSvc.getLearner(EnrollmentNumber).getRegisteredCourseList()) {
						System.out.println(c1);
					}
					break;
				case 7:
					System.out.println("Registered Course List");
					System.out.println("Enter EnrollmentNumber :");
					EnrollmentNumber = ip.nextInt();
					for (Course c1 : lSvc.getLearner(EnrollmentNumber).getCompletedCourseList()) {
						System.out.println(c1);
					}
					break;
				case 8:
					System.out.println("Thank you for working with Course Management..");
					break;
				default:
					System.out.println("Wrong Option");
					break;
				}
				break;
			case 3:
				System.out.println("Enrolment Management");
				System.out.println("1. Enroll a Course\n2.Cancel a Course\n3.Certify a Course");
				int sOption2 = 0, courseId = 0, enrollmentNo = 0;
				System.out.println("Enter your choice: ");
				sOption2 = ip.nextInt();
				switch (sOption2) {
				case 1:
					System.out.println("Course Enrollment");
					System.out.println("Enter the Course ID: ");
					courseId = ip.nextInt();
					System.out.println("Enter the Learner ID(Enrollment no): ");
					enrollmentNo = ip.nextInt();
					System.out.println(enSvc.enrollCourse(courseId, enrollmentNo));
					break;
				case 2:
					System.out.println("Course Cancellation");
					System.out.println("Enter the Course ID: ");
					courseId = ip.nextInt();
					System.out.println("Enter the Learner ID(Enrollment no): ");
					enrollmentNo = ip.nextInt();
					System.out.println(enSvc.cancelCourse(courseId, enrollmentNo));
					break;
				case 3:
					System.out.println("Certify a Learner");

					System.out.println("Enter the Course ID: ");
					courseId = ip.nextInt();
					System.out.println("Enter the Learner ID(Enrollment no): ");
					enrollmentNo = ip.nextInt();
					System.out.println(enSvc.certifyLearner(courseId, enrollmentNo));
					break;
				case 4:
					System.out.println("Thank you for working with Enrollment Management..");
					break;
				default:
					System.out.println("Wrong Option");
					break;
				}
				break;
				default:
					System.out.println("Wrong Option");
					break;
			}

			System.out.println("Would you like to continue with COurse or Learner ? Press 1 -  Coourse or 2 - Learner or 3 - Enrollment");
			mOption = ip.nextInt();

		}
		//System.out.println(enSvc.enrollCourse(101, 1001));
		//System.out.println(cSvc.getCourse(101));
	}

}
