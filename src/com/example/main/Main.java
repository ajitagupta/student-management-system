package com.example.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.example.dao.StudentDAO;
import com.example.pojo.Student;

public class Main {

	public static void main(String[] args) throws Exception {
	
		Scanner br=new Scanner(System.in);
		System.out.println("Hello User Please Enter Your Name: \n");
		String user = br.next();
		System.out.println("Welcome To Student Management System, " + user);
		
		int ch;
		
	do {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to DISPLAY student");
			System.out.println("PRESS 4 to UPDATE student");
			System.out.println("PRESS 5 to EXIT App");
		
			 ch = br.nextInt();
			
			switch(ch) {
			case 1:
				//Add student
				
				System.out.println("Enter User Name: ");
				String name = br.next();
				System.out.println("Enter User Phone: ");
				String phone = br.next();
				System.out.println("Enter User City: ");
				String city = br.next();
				
				//create student object
				Student st = new Student(name,phone,city);
				boolean ans = StudentDAO.insertStudentRecordToDB(st);
				if(ans) {
					System.out.println("Student record Inserted Successfully...");
					System.out.println("Student Record:" + st);
				}else {
					System.out.println("Some error Occured While Inserting...Please try Again!");
				}
				
			break;
			case 2:
			 
				//Delete student
				System.out.println("Enter Student ID To Delete: ");
				int userID = br.nextInt();
				boolean f = StudentDAO.deleteStudentRecordFromDB(userID);
				if(f) {
					System.out.println("Student Of ID " + userID + " Record Deleted... ");
				}else {
					System.out.println("Something Went Wrong.. Please try Again!");
				}
			break;
			case 3:
				//Display student
				StudentDAO.showAllStudentRecords();
			break;
			case 4: 
				//Update student
				System.out.println("PRESS 1 to UPDATE name");
				System.out.println("PRESS 2 to UPDATE phone");
				System.out.println("PRESS 3 to UPDATE city");
				int val = br.nextInt();
				if(val == 1) {
					//Update Name
					System.out.println("Enter name to UPDATE...");
					 name = br.next();
					System.out.println("Enter ID to identify student!");
					int id = br.nextInt();;
					Student st1 = new Student();
					st1.setStudentName(name);
					 f = StudentDAO.updateStudentRecord(val,name,id,st1);
					if(f) {
						System.out.println("Student Name Updated Successfully...");
					}else {
						System.out.println("Something Went Wrong Please try Again!");
					}
				}
				else if(val == 2) {
					//Update Phone
					System.out.println("Enter phone to UPDATE...");
					 phone = br.next();
					System.out.println("Enter ID to identify student!");
					int id = Integer.parseInt(br.next());
					Student st2 = new Student();
					st2.setStudentPhone(phone);
					 f = StudentDAO.updateStudentRecord(val,phone,id,st2);
					if(f) {
						System.out.println("Student Phone Updated Successfully...");
					}else {
						System.out.println("Something Went Wrong Please try Again!");
					}
				}
				else if(val == 3) {
					//Update city
					System.out.println("Enter city to UPDATE...");
					 city = br.next();
					System.out.println("Enter ID to identify student!");
					 int id = Integer.parseInt(br.next());
					Student st3 = new Student();
					st3.setStudentCity(city);
					 f = StudentDAO.updateStudentRecord(val,city,id,st3);
					if(f) {
						System.out.println("Student City Updated Successfully...");
					}else {
						System.out.println("Something Went Wrong Please try Again!");
					}
				}
				else {
					System.out.println("Hey You have not updated Anything... Please choose option Correctly!");
				}
				
			break;
			case 5: 
				//Exit
				
				System.out.println("Thank You For Using Application...If You Enjoyed, Please Experience It Again!" + user);
				break;
			default:
				System.out.println("Wrong choice");
				
			
			}	
		}while(ch!=5);
	
}}
	
	

