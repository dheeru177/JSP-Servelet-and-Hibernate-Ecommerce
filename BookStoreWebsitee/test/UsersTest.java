import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
	
		Users user1 = new Users();
		user1.setEmail("name@codejava.net");
		user1.setFullName("Nam Ha Minh");
		user1.setPassword("helloWorld");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsitee");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		entityManagerFactory.close();
		
		System.out.println("A users object was persisted");

	}

}
