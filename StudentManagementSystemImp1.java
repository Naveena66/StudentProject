package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImp1 implements StudentManagementSystem {
	
	Scanner scan = new Scanner(System.in);
	LinkedHashMap<Integer,Student> db = new LinkedHashMap<Integer,Student>();

	@Override
	public void addStudent() {
		System.out.println("Enter Id,Name, Age, and Marks:");
		int id = scan.nextInt();
		String name =scan.next();
		int age = scan.nextInt();
		double marks = scan.nextDouble();
		
		//Student std = new Student(id, name, age, marks);
		//db.put(std.getId(),std);
		db.put(id, new Student(id, name, age, marks));
		System.out.println("Student Record Inserted Successfully");
		
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter Student Id:");
		int id = scan.nextInt();
		
		if(db.containsKey(id)) {
			db.remove(id);
		}
		else {
			try {
			throw new StudentNotFoundException("Student Data Not Found");
		}
		catch(StudentNotFoundException e) {
			System.out.println(e.getMessage());
		  }
	   }
		
	}

	@Override
	public void removeAllStudents() {
		db.clear();
		System.out.println("All The Student Records Deleted");
		
		
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id:");
		int id = scan.nextInt();
		
		if(db.containsKey(id)) {
			System.out.println(db.get(id));
			/*Student std = db.get(id);
			System.out.println("Id: "+std.getId()+"\nName: "+std.getName()+"\nAge: "+std.getAge()+"\nMarks: "+std.getMarks());*/
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
	}

	@Override
	public void displayAllStudents() {
		Set<Integer> setOfKeys = db.keySet();//Creating a Set Of Student Id's
		
		for(int id : setOfKeys) { //key = id
			System.out.println(db.get(id)); //std = db.get(id)
		}
		
		/*for(int key : setOfKeys) {
			Student s = db.get(setOfKeys);
			System.out.println("Id: "+s.getId()+"\tName: "+s.getName()+"\tAge: "+s.getAge()+"\tMarks: "+s.getMarks());
		}*/
		
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id:");
		int id = scan.nextInt();
		
		if(db.containsKey(id)) {
			Student s = db.get(id);
			
				System.out.println("1:Update AGE\n2:Update NAME\n3:Update MARKS");
				System.out.println("Enter Choice:");
				int choice = scan.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("Enter Age:");
					int age = scan.nextInt();
					s.setAge(age);
					break;
				case 2:
					System.out.println("Enter Age:");
					String name = scan.next();
					s.setName(name);
					break;
				case 3:
					System.out.println("Enter Age:");
					double marks = scan.nextDouble();
					s.setMarks(marks);
					break;
				default:
					System.out.println("Invalid choice");
				}
				System.out.println("Student Data Updated Successfully");
			
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Found");
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
	}

	@Override
	public void countStudents() {
		System.out.println("Number Of Student Records Present: "+db.size());
	
		
	}

	@Override
	public void sortStudents() {
		
		ArrayList<Student> l = new ArrayList<Student>();
		Set<Integer> s = db.keySet();
		for(int id : s) {
			l.add(db.get(id));
		}
		
		System.out.println("1:Sort Based On Id\n2:Sort Based On Name\n3:Sort Based On Age\n4:Sort Based On Marks");
		System.out.println("Enter choice");
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1:
			Collections.sort(l, new SortStudentById());
			display(l);
			break;
		case 2:
			Collections.sort(l, new SortStudentByName());
			display(l);
			break;
		case 3:
			Collections.sort(l, new SortStudentByAge());
			display(l);
			break;
		case 4:
			Collections.sort(l, new SortStudentByMarks());
			display(l);
			break;
		default:
			System.out.println("Invalid choice,Enter valid choice");
		}
		
	}
	 private static void display(List<Student> l) {
		 for(Student s1:l) {
				System.out.println(s1);
			}
	 }
	
	

}
