package sms.base;

import java.util.Random;

//THIS IS AN ENCAPSULATED CLASS
public class Student extends Payment { // INHERITANCE TO GET THE PAYMENT DETAILS FROM PAYMENT CLASS

	private String name;
	private String year;
	private String course;
	private String id;

	public Student() { // CONSTRUCTOR TO PRINT THE UI HEADER

		System.out.println(	"------------------------------------------Kongu Engineering College----------------------------------------");
		System.out.println("                                               (Since 1996)");
		System.out.println("                                    Welcome to Student Management Interface!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String createUniqueId(String pre, int limit) {
		Random random = new Random();
		int n = random.nextInt(limit);
		this.id = pre + n;
		System.out.println();
		return id;

	}

	@Override
	public void getInfo() { // THIS IS THE OVERRIDDEN METHOD
		System.out.println("**********************Student Database***********************");
		System.out.println("Student ID                   : " + id);
		System.out.println("Name                         : " + name);
		System.out.println("Year of joining              : " + year);
		System.out.println("Course opted                 : " + course);

	}
}
