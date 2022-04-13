package model;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {
	
	
	

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    EntityManagerFactory emf = null;
	    EntityManager entityManager = null;
	    EntityTransaction transaction = null;
	    try {
	      emf = Persistence.createEntityManagerFactory("jbd-pu");
	      entityManager = emf.createEntityManager();
	      transaction = entityManager.getTransaction();
	      
	      int n;	
	      Scanner scanner = new Scanner(System.in);		
			try {
				System.out.print("0 per inserire un cliente \n "
						+ "1 per inserire un auto \n "
						+ "2 per inserire un noleggio \n"
						);
				n = scanner.nextInt();	
				switch(n) {
				case 0: 
					transaction.begin();
					Cliente client = new Cliente();
				    client.setNomeCliente("John");
				    entityManager.persist(client);
				    transaction.commit();
				      
				    Query q = entityManager.createNativeQuery("select * from cliente",Cliente.class);
				    @SuppressWarnings("unchecked")
				    List<Cliente> res = q.getResultList();
				    for(Cliente c: res) {
				    	System.out.println(c);
				    }
					break;
				case 1:
					transaction.begin();
					Auto a = new Auto();
				    a.setColore("Blu");
				    a.setTarga("abcdef");
				    a.setTariffaNoleggio(20);
				    entityManager.persist(a);
				    transaction.commit();
					
					q = entityManager.createNativeQuery("select * from auto",Auto.class);
					@SuppressWarnings("unchecked")
					List<Auto> result = q.getResultList();
					for(Auto c: result) {
						System.out.println(c);
					 }
					      
					break;
					
					
				case 2:
					
					
					
					
					break;
				
				}
	      
	      
			} catch(InputMismatchException ex) {
				System.out.println("Errore, input non valido.");
			} finally {
				scanner.close();
			}
	      
	      

	      /*
	      Iterator it = res.iterator();
	      while(it.hasNext()){
	           Object[] line =(Object[]) it.next();
	           Cliente c = new Cliente();
	           c.setIdCliente(Long.parseLong(String.valueOf(line[0])));
	           c.setNomeCliente((String.valueOf(line[1])));
	
	           list.add(c);
	      }
	      */

	      /*
	      list.forEach(element->System.out.println(element));
	      list.forEach((element)->{
	    	  System.out.println(element);
	      });
	       
	       *
	       */      
	    } catch (Exception e) {
	      System.out.println(e);
	      transaction.rollback();
	    } finally {
	      entityManager.close();
	      emf.close();
	    }
	  
	}

}
