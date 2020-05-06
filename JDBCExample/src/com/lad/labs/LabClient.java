package com.lad.labs;

import java.util.List;

public class LabClient {

	public static void main(String[] args) {
		List<Employee> emp = new TrainingDAO().getAllEmployees();
		emp.forEach(p -> System.out.printf("%-10d %-10s %-10s %-10d %-10d %n", p.getId(), p.getFirstName(),
				p.getLastName(), p.getDeptId(), p.getCredits()));
	}
}
