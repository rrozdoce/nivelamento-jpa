package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		// busca um Objeto pelo id
		Pessoa p = em.find(Pessoa.class, 2);
		
		// Objeto monitoriado é um Objeto que voce acabou de inserir ou que buscou no banco de dados e ainda nao fechou entityManager
		em.getTransaction().begin();
		
		em.remove(p);
		
		em.getTransaction().commit();
		
		System.out.println(p);
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
