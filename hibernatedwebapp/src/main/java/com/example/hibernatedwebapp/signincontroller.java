package com.example.hibernatedwebapp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import registration.register;

public class signincontroller {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        int ch;
        do {
            displaymenu();
            System.out.println("Enter your choice");
            ch = Integer.parseInt(src.nextLine());
            switch (ch) {
                case 1:
                    insertion(src);
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    getall();
                    break;
                case 5:
                    getbyid();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        } while (ch > 0);
    }

    private static void getbyid() {
        // TODO Auto-generated method stub
    	Scanner scr= new Scanner(System.in);
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory sf = mt.buildSessionFactory();
    	Session s = sf.openSession();
    	System.out.println("enter id");
    	int id = scr.nextInt();
    	Transaction t = s.beginTransaction();
    	signin si = s.get(signin.class, id);
    	if(si!=null) {
    		System.out.println("id :"+si.getId());
    		System.out.println("name"+si.getName());
    		System.out.println("email"+si.getEmail());
    		System.out.println("password"+si.getPassword());
    	}else {
    		System.out.println("data not found");
    	}
    	t.commit();
    }

    private static void getall() {
        // TODO Auto-generated method stub
    	 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
         Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
         SessionFactory sf = md.getSessionFactoryBuilder().build();
         org.hibernate.Session s = sf.openSession();
         org.hibernate.Transaction t = s.beginTransaction();
         List<signin> li = s.createQuery("from signin",signin.class).list();
         
         t.commit();
         
         for(signin c:li) {
        	 System.out.println("id: "+c.getId());
        	 System.out.println("Name: "+c.getName());
        	 System.out.println("email: "+c.getEmail());
        	 System.out.println("password: "+c.getPassword());
        	 
         }
    }

    private static void update() {
        // TODO Auto-generated method stub
    	Scanner scr= new Scanner(System.in);
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory sf = mt.buildSessionFactory();
    	Session s = sf.openSession();
    	System.out.println("enter id");
    	int id = scr.nextInt();
    	Transaction t = s.beginTransaction();
    	signin si = s.get(signin.class, id);
    	if(si!=null) {
    		System.out.println("enter new name :");
    		String name = scr.next();
    		System.out.println("enter new email");
    		String email =scr.next();
    		System.out.println("enter new password");
    		String password = scr.next();
    		si.setName(name);
    		si.setEmail(email);
    		si.setPassword(password);
    		s.update(si);
    		t.commit();
    		System.out.println("data successfully updated");
    		}else {
    		System.out.println("data not updated");
    	}
    	
    }

    

    @SuppressWarnings("deprecation")
	private static void delete() {
        // TODO Auto-generated method stub
    	Scanner src = new Scanner(System.in);
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	 Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
         SessionFactory sf = md.getSessionFactoryBuilder().build();
         Session s = sf.openSession();
         
         System.out.println("enter id");
         int id = src.nextInt();
         
         Transaction t = s. beginTransaction();
         signin c = s.get(signin.class, id);
         s.delete(c);
         t.commit();
         System.out.println("successfuly deleted");
    }

    @SuppressWarnings("deprecation")
	private static void insertion(Scanner src) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        org.hibernate.Session s = sf.openSession();
        org.hibernate.Transaction t = s.beginTransaction();

        signin c = new signin();

        System.out.println("Enter name:");
        String name = src.nextLine();
        c.setName(name);

        System.out.println("Enter email:");
        String email = src.nextLine();
        c.setEmail(email);

        System.out.println("Enter password:");
        String password = src.nextLine();
        c.setPassword(password);

        s.save(c);
        t.commit();
        System.out.println("Successfully Inserted");
    }

    private static void displaymenu() {
        System.out.println("");
        System.out.println("\t1.insertion");
        System.out.println("\t2.delete");
        System.out.println("\t3.update");
        System.out.println("\t4.getall");
        System.out.println("\t5.getbyid");
        System.out.println("");
    }
}
