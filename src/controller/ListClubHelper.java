/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Jan 30, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListClub;

public class ListClubHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PremierLeagueClubs");
	
	public void insertClub(ListClub lc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListClub> showAllClubs() {
		EntityManager em = emfactory.createEntityManager();
		List<ListClub> allClubs = em.createQuery("SELECT i FROM ListClub i").getResultList();
		return allClubs;
	}
	
	public void deleteClub(ListClub toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListClub>typedQuery = em.createQuery("select lc from ListClub lc where lc.city = :selectedCity and lc.club = :selectedClub", ListClub.class);
		
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedClub", toDelete.getClub());
		
		typedQuery.setMaxResults(1);
		
		ListClub result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param cityName
	 * @return
	 */
	public List<ListClub> searchForClubByCity(String cityName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListClub>typedQuery = em.createQuery("select lc from ListClub lc where lc.city = :selectedCity", ListClub.class);
		typedQuery.setParameter("selectedCity", cityName);
		
		List<ListClub> foundClubs = typedQuery.getResultList();
		em.close();
		return foundClubs;
	}

	/**
	 * @param clubName
	 * @return
	 */
	public List<ListClub> searchForClubByClub(String clubName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListClub>typedQuery = em.createQuery("select lc from ListClub lc where lc.club = :selectedClub", ListClub.class);
		typedQuery.setParameter("selectedClub", clubName);
		
		List<ListClub> foundClubs = typedQuery.getResultList();
		em.close();
		return foundClubs;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public ListClub searchForClubById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListClub found = em.find(ListClub.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateClub(ListClub toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
