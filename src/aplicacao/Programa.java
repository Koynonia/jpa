package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

//		  Estanciando objetos
//		  
//		  Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com"); 
//		  Pessoa p2 = new Pessoa(null, "Joaquim Torrers", "joaquim@gmail.com"); 
//		  Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

//		Usando o JPA (Mapeamento Objeto-Relacional)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

//		  Cria Tabela (se não existir) e insere registros no BD por JPA
//		  
//		  em.getTransaction().begin(); 
//		  em.persist(p1); 
//		  em.persist(p2); 
//		  em.persist(p3);
//		  em.getTransaction().commit();

//		Recupera um registro (pode ser entidade destacada) no BD por JPA
		Pessoa p = em.find(Pessoa.class, 2);

//		Apaga um registro (precisa ser entidade monitorada) no BD por JPA
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();

		System.out.println(p);
		System.out.println("Pronto!");

		em.close();
		emf.close();
	}
}