package com.tanujsharma.springJdbcMaven.TestClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tanujsharma.springJdbcMaven.Bean.Customer;

public class Tester 
{  
@SuppressWarnings("deprecation")
public static void main(String[] args)throws Exception
 {
	 SessionFactory sessionFactory = null;
	 Transaction tx = null;
	 Session session = null;
   try
	 {
		  Configuration cfg  = new Configuration();
		cfg.configure("com/tanujsharma/springJdbcMaven/resources/hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Customer c = new Customer();
		c.setCid(6);
		c.setCname("Tanuj");
		c.setCaddr("Punjab");
		
		Integer  pk = (Integer) session.save(c);
		tx.commit();
		System.out.println("primary key value "+pk+"inserted with success");
	} 
	 catch (Exception e)
	 {
		 tx.rollback();
		 e.printStackTrace();
      }
     finally
     {
	session.close();
	sessionFactory.close();
     }
	 
 } 
 }