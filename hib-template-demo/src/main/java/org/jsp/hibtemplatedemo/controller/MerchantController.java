package org.jsp.hibtemplatedemo.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hibtemplatedemo.dao.MerchantDao;
import org.jsp.hibtemplatedemo.dto.Merchant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MerchantController {
	static Scanner s = new Scanner(System.in);
	private static MerchantDao dao;
	static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("hib-template.xml");
		dao = context.getBean(MerchantDao.class);
	}

	public static void main(String[] args) {
		boolean b = true;
		while (b) {
			System.out.println("1.Save Merchant");
			System.out.println("2.Update Merchant");
			System.out.println("3.Find Merchant By Id");
			System.out.println("4.Delete Merchant By Id");
			System.out.println("5.Find All Merchant");
			switch (s.nextInt()) {
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
				;
				break;
			}
			case 5: {
				findAll();
				break;
			}
			default: {
				b = false;
				System.out.println("Thank You!!!Application Closed");
				((ClassPathXmlApplicationContext) context).close();
			}
			}
		}

	}

	public static void save() {
		System.out.println("Enter the name,phone,email,gst and password to save merchant");
		Merchant m = new Merchant();
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setGst(s.next());
		m.setPassword(s.next());
		m = dao.saveMerchant(m);
		System.out.println("Merchant saved with Id:" + m.getId());
	}

	public static void update() {
		System.out.println("Enter the Merchant Id to update");
		int id = s.nextInt();
		System.out.println("Enter the name,phone,email,gst and password to save merchant");
		Merchant m = new Merchant();
		m.setId(id);
		m.setName(s.next());
		m.setPhone(s.nextLong());
		m.setEmail(s.next());
		m.setGst(s.next());
		m.setPassword(s.next());
		m = dao.updateMerchant(m);
		System.out.println("Merchant updated");
	}

	public static void findById() {
		System.out.println("Enter the Merchant Id to find merchant");
		int id = s.nextInt();
		Merchant m = dao.findById(id);
		if (m != null) {
			System.out.println("Merchant Id:" + m.getId());
			System.out.println("Merchant Name:" + m.getName());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email Id:" + m.getEmail());
			System.out.println("GST:" + m.getGst());
		} else {
			System.err.println("You have Entered an Invalid Merchant Id");
		}
	}

	public static void findAll() {
		List<Merchant> merchants = dao.findAll();
		for (Merchant m : merchants) {
			System.out.println("Merchant Id:" + m.getId());
			System.out.println("Merchant Name:" + m.getName());
			System.out.println("Phone Number:" + m.getPhone());
			System.out.println("Email Id:" + m.getEmail());
			System.out.println("GST:" + m.getGst());
			System.out.println("=============================");
		}
	}

	public static void delete() {
		System.out.println("Enter the Merchant Id to find merchant");
		int id = s.nextInt();
		if (dao.deleteMerchant(id)) {
			System.out.println("merchant deleted");
		} else {
			System.err.println("Invalid Merchant Id");
		}
	}
}
