package sms.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String n;

	public int opening() {
		System.out.println("What do you want to explore?"); // TO PRINT THE OPENING OPTIONS FOR USER
		System.out.println("1.Register for a Course(Enter 1)");
		System.out.println("2.Payment (Enter 2)");
		System.out.println("3.View Status (Enter 3)");
		System.out.println("4.Exit");
		System.out.println();
		System.out.print("Enter your choice here : ");
		int in = sc.nextInt();
		return in;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Student s1 = new Student();
		Main m1 = new Main();
		Payment pay = new Payment();

		// JDBC CONNECTION
		String query = "INSERT INTO student VALUES(?,?,?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");
		PreparedStatement st = con.prepareStatement(query);

		do {
			int option = m1.opening();
			if (option == 1) { // TO REGISTER THE DETAILS OF STUDENT
				String course = ""; // RECEIVES INPUTS OF NAME, YEAR OF JOINING, COURSE SELECTION AND UPDATING DB
				System.out.println();
				System.out.println("***Register a Student***");
				System.out.print("Name                   : ");
				String name = sc.next();

				st.setString(2, name);
				s1.setName(name);

				System.out.print("Year of joining        : ");
				String yoj = sc.next();
				st.setString(3, yoj);
				s1.setYear(yoj);

				System.out.println();
				System.out.println("Please select the course ");
				System.out.println(" 1.Java Full Stack Professtional");
				System.out.println(" 2.Solution Architect");
				System.out.println(" 3.DevOps professional");
				System.out.println(" 4.Linux System Administrator");
				System.out.println();
				System.out.print("Enter your choice       : ");
				int cin = sc.nextInt();
				switch (cin) {
				case 1:
					s1.setCourse("Java Full Stack Professional");
					course = s1.getCourse();
					break;
				case 2:
					s1.setCourse("Solution Architect");
					course = s1.getCourse();
					break;
				case 3:
					s1.setCourse("DevOps professional");
					course = s1.getCourse();
					break;
				case 4:
					s1.setCourse("Linux System Administrator");
					course = s1.getCourse();
					break;

				default:
					System.err.println("***Please enter a number from 1-4***");

				}
				String id = s1.createUniqueId(yoj, 100); // CALLING THIS METHOD TO SET UNIQUE ID FOR EACH STUDENT
				st.setString(1, id);
				st.setString(4, course);

			}
			System.out.println();
			System.out.println("***********Student details are added successfully************");
		
			if (option == 2) {
				System.out.println("************************Payment******************************");
				System.out.println("1.View pending fees"); // TO VIEW THE PENDING FEES AND MAKING PAYMENT
				System.out.println("2.Do payment");
				System.out.print("Please enter your choice here : ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					pay.showPendingPayment();

					break;
				case 2:
					System.out.println();
					System.out.print("Enter the amount to be paid : $");
					double payIn = sc.nextDouble();
					double pen = pay.setPay(payIn);
					st.setDouble(5, pen);
					break;
				}

			}
			if (option == 3) { // FETCHES ALL THE DATA ABOUT A STUDENT THAT WAS REGISTERED AT LATEST

				s1.getInfo();
				pay.getInfo();
				int count = st.executeUpdate();
				System.out.println("Data are added into the database successfully( " + count + " rows affected)");
			}

			if (option == 4) { // EXITING FROM THE PROGRAM

				System.out.println(
						"---------------------------THANKS FOR USING STUDENT MANAGEMENT INTERFACE-----------------------");
				System.out.println(
						"---------------------------------------SEE YOU AGAIN!!!----------------------------------------");
				System.exit(0);
			}
			System.out.print("Do you want to continue? (y/n) : ");
			n = sc.next();
			System.out.println();
		} while (!n.equals("n"));
		int count = st.executeUpdate();
		System.out.println("Data are added into the database successfully( " + count + " rows affected)");
		System.out.println();
		con.close();
		st.close();
		System.out.println("-------THANKS FOR USING STUDENT MANAGEMENT INTERFACE-------");
		System.out.println("---------------------SEE YOU AGAIN!!!----------------------");

	}
}
