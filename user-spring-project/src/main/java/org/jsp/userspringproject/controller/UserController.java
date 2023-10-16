package org.jsp.userspringproject.controller;

import java.util.Scanner;

import org.jsp.userspringproject.UserConfig;
import org.jsp.userspringproject.dao.UserDao;
import org.jsp.userspringproject.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController {
	static UserDao dao;
	static Scanner sc = new Scanner(System.in);
	static ApplicationContext context;
	static {
		context = new AnnotationConfigApplicationContext(UserConfig.class);
		dao = context.getBean(UserDao.class);
	}

	public static void main(String[] args) {
		boolean b = true;
		while (b) {
			System.out.println("1.Save user");
			System.out.println("2.Update user");
			System.out.println("3.Find User By Id");
			System.out.println("4.Delete user By id");
			System.out.println("5.Verify User by id and password");
			System.out.println("6.Verify User by phone and password");
			System.out.println("7.Verify User by email and password");
			System.out.println("Enter Your Choice");
			switch (sc.nextInt()) {
			case 1: {
				save();
				break;
			}
			case 2: {
				update();
				break;
			}
			case 3: {
				findById();
				break;
			}
			case 4: {
				delete();
				break;
			}
			case 5: {
				verifyById();
				break;
			}
			case 6: {
				verifyByPhone();
				break;
			}
			case 7: {
				verifyByEmail();
				break;
			}
			default: {
				System.out.println("Thank You!!!Application Closed");
				((AnnotationConfigApplicationContext) context).close();
				b = false;
			}
			}
		}
	}

	public static void save() {
		System.out.println("Enter Your name,phone,email and password to register");
		User u = new User();
		u.setName(sc.next());
		u.setPhone(sc.nextLong());
		u.setEmail(sc.next());
		u.setPassword(sc.next());
		u = dao.saveUser(u);
		System.out.println("user saved with Id:" + u.getId());
	}

	public static void update() {
		System.out.println("Enter the User Id to update");
		int id = sc.nextInt();
		System.out.println("Enter Your name,phone,email and password to register");
		User u = new User();
		u.setId(id);
		u.setName(sc.next());
		u.setPhone(sc.nextLong());
		u.setEmail(sc.next());
		u.setPassword(sc.next());
		u = dao.updateUser(u);
		System.out.println("user  Updated");
	}

	public static void findById() {
		System.out.println("Enter the User Id to display details");
		int id = sc.nextInt();
		User u = dao.findById(id);
		if (u != null) {
			System.out.println("User with Id " + id + " found");
			System.out.println("User id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Email:" + u.getEmail());
			System.out.println("--------------------------");
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}

	public static void delete() {
		System.out.println("Enter the User Id to delete");
		int id = sc.nextInt();
		boolean deleted = dao.deleteById(id);
		if (deleted) {
			System.out.println("User Found and deleted");
		} else {
			System.out.println("You have entered an Invalid Id");
		}
	}

	public static void verifyByPhone() {
		System.out.println("Enter Your Phone Number and password to verify");
		long phone = sc.nextLong();
		String password = sc.next();
		User u = dao.verifyUser(phone, password);
		if (u != null) {
			System.out.println("User Verified Succesfully");
			System.out.println("User id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Email:" + u.getEmail());
			System.out.println("--------------------------");
		} else {
			System.err.println("Invalid Phone Number or Password");
		}
	}

	public static void verifyByEmail() {
		System.out.println("Enter Your Email and password to verify");
		String email = sc.next();
		String password = sc.next();
		User u = dao.verifyUser(email, password);
		if (u != null) {
			System.out.println("User Verified Succesfully");
			System.out.println("User id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Email:" + u.getEmail());
			System.out.println("--------------------------");
		} else {
			System.err.println("Invalid Email or Password");
		}
	}

	public static void verifyById() {
		System.out.println("Enter Your Id and password to verify");
		int id = sc.nextInt();
		String password = sc.next();
		User u = dao.verifyUser(id, password);
		if (u != null) {
			System.out.println("User Verified Succesfully");
			System.out.println("User id:" + u.getId());
			System.out.println("User Name:" + u.getName());
			System.out.println("Phone Number:" + u.getPhone());
			System.out.println("Email:" + u.getEmail());
			System.out.println("--------------------------");
		} else {
			System.err.println("Invalid Id or Password");
		}
	}
}
