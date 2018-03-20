package advancia.service;

import javax.persistence.*;
import advancia.entity.*;

public class crea {

	public static void main(String[] args) {

		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		try {
			Employee emp = new Employee();
			Project pro = new Project();
			em.getTransaction().begin();
			
			emp.setName("Gabriele");
			emp.setlName("De Biase");
			pro.setCod("AAA");
			em.persist(emp);
			em.persist(pro);
			em.getTransaction().commit();
			
			Query query1 = em.createQuery("Select pro from Project pro where pro.cod = 'AAA'");
			Project pro1 = (Project) query1.getSingleResult();
			Query query2 = em.createQuery("Select emp from Employee emp where emp.name = 'Gabriele'");
			Employee emp1 = (Employee) query2.getSingleResult();
			
			em.getTransaction().begin();
			pro1.addEmployee(emp1, true);
			em.merge(pro);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}
}


