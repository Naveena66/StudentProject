package sdbms;

import java.util.Scanner;

public class Registration {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("WELCOME TO SDBMS");
		System.out.println("================");
		
		//UPCASTING -> ABSTRACTION
		StudentManagementSystem obj = new StudentManagementSystemImp1();
		
		//MENU DRIVEN PROGRAM
		
		while(true) {
			System.out.println("1:ADD STUDENT\n2:REMOVE STUDENT");
			System.out.println("3:REMOVEALL STUDENT\n4:DISPLAY STUDENT");
			System.out.println("5:DISPLAYALL STUDENT\n6:UPDATE STUDENT");
			System.out.println("7:COUNT STUDENTS\n8:SORT STUDENTS\n9:EXIT");
			
			System.out.println("Enter Choice:");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				obj.addStudent();
				break;
			case 2:
				obj.removeStudent();
				break;
			case 3:
				obj.removeAllStudents();
				break;
			case 4:
				obj.displayStudent();
				break;
			case 5:
				obj.displayAllStudents();
				break;
			case 6:
				obj.updateStudent();
				break;
			case 7:
				obj.countStudents();
				break;
			case 8:
				obj.sortStudents();
				break;
			case 9:
				System.out.println("THANK YOU!!");
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
				System.out.println("Kindly Enter Valid Choice");
			}
			System.out.println("--------------");
		}
		
	}

}
