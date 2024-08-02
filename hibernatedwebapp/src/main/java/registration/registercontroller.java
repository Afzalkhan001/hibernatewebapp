package registration;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.hibernatedwebapp.signin;

public class registercontroller {
   public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner src = new Scanner(System.in);
	int ch;
	do {
		displaymenu();
		 System.out.println("Enter your choice");
		ch = Integer.parseInt(src.nextLine());
		switch (ch) {
        case 1:
            insertion();
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
	
}

private static void getall() {
	// TODO Auto-generated method stub
	
}

private static void update() {
	// TODO Auto-generated method stub
	
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
     
     Transaction t = s.beginTransaction();
      
     register c = s.get(register.class, id);
     s.delete(c);
     t.commit();
     System.out.println("successfuly deleted");
     
	
}

@SuppressWarnings({ "deprecation", "deprecation" })
private static void insertion() {
	// TODO Auto-generated method stub
	 Scanner src = new Scanner(System.in);
	  StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
      Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
      SessionFactory sf = md.getSessionFactoryBuilder().build();
      Session s = sf.openSession();
      Transaction t = s.beginTransaction();
      register c = new register();
     
      System.out.println("Enter name:");
      String name = src.nextLine();
      c.setName(name);

      System.out.println("Enter email:");
      String email = src.nextLine();
      c.setEmail(email);
       
      System.out.println("Enter phno:");
//      @SuppressWarnings("unused")
	long phono = src.nextLong();
     c.setPhono(phono);

      s.save(c);
      t.commit();
      System.out.println("Successfully Inserted");
  }
     





private static void displaymenu() {
	// TODO Auto-generated method stub
	 System.out.println("");
     System.out.println("\t1.insertion");
     System.out.println("\t2.delete");
     System.out.println("\t3.update");
     System.out.println("\t4.getall");
     System.out.println("\t5.getbyid");
     System.out.println("");
	
}
}
