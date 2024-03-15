package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.db.CP;
import com.example.pojo.Student;

public class StudentDAO {

	public static boolean insertStudentRecordToDB(Student s) {
		
		boolean f=false;
		
		try {
			Connection conn=CP.createc();
					
			String query="insert into students(name,phoneno,city)values(?,?,?)";
			
			PreparedStatement pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1,s.getStudentName());
			pstmt.setString(2, s.getStudentPhone());
			pstmt.setString(3,s.getStudentCity());
			
			pstmt.executeUpdate();
			f=true;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}public static void showAllStudentRecords() {
			// TODO Auto-generated method stub
			boolean f = false;
			try {
				Connection con = CP.createc();
				String query = "select * from students";
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery(query);
				
				while(set.next()) {
					
					String name = set.getString(2);
					String phone = set.getString(3);
					String city = set.getString(4);
					
					System.out.println("  Student Name: " + name + " \nStudent Phone: " + phone + " \nStudent city: " + city);
					System.out.println("----------------------------------------------");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}

	public static boolean updateStudentRecord(int val,String toUpdate,int id,Student st) {
		// TODO Auto-generated method stub
		boolean f = false;
		
		try {
			  Connection con = CP.createc();
			 if(val == 1) {
					//Update Name
					
						String query = "update students set name=? where id=?";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, toUpdate);
						pstmt.setInt(2, id);
						
						//execute..
						pstmt.executeUpdate();
						f = true;
				}
				else if(val == 2) {
					//Update Phone
					String query = "update students set phoneno=? where id=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					//execute..
					pstmt.executeUpdate();
					f = true;
				}
				else if(val == 3) {
					//Update City
					String query = "update students set city=? where id=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					//execute..
					pstmt.executeUpdate();
					f = true;
				}
				else {
					
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	public static boolean deleteStudentRecordFromDB(int userID) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			Connection con = CP.createc();
			String query = "delete from students where id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the value of parameters
			pstmt.setInt(1, userID);
			
			//execute..
			pstmt.executeUpdate();
			
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}

}

	
