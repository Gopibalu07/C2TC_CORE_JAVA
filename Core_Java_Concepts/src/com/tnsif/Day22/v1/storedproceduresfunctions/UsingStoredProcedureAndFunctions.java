package com.tnsif.Day22.v1.storedproceduresfunctions;

import java.sql.SQLException;

public class UsingStoredProcedureAndFunctions {

	public static void main(String[] args) {
		try {
			//StoredProcedureFunctionService.deleteStudents();
			//StoredProcedureFunctionService.deleteStudentsByCity("Nashik");
			
			String name=StoredProcedureFunctionService.getstudentName(2);
			System.out.println("Student name is "+name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}