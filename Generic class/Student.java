package Q1;

public class Student implements Comparable<Student>{

	private String firstName;
	private String lastName;
	private String  id;
	private String birthYear;
	
	public Student(String firstName, String lastName, String id, String birthYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.birthYear = birthYear;
	}
	
	//comper 2 string 
	public int compareTo(Student s) {
		return this.id.compareTo(s.id);
	}
	
	
	//Returns a string if the student details
	public String toString() {
		return "name: " + firstName + " " + lastName + ", id: " + id + ", birth year: " + birthYear;
	}
}

