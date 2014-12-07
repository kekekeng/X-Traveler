package edu.jhu.cs.oose.fall2013.group14.xtraveler.Model.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import edu.jhu.cs.oose.fall2013.group14.xtraveler.Control.main.SocketManager;
import edu.jhu.cs.oose.fall2013.group14.xtraveler.Model.main.PlaceDAO;
import edu.jhu.cs.oose.fall2013.group14.xtraveler.Model.main.UserDAO;

/**
 * To test one's visited test, add place to and list the visited list
 * @author kekekeng
 *
 */
public class VisitedListTest {
	static SessionFactory sessionFactory = new Configuration().configure()
			.buildSessionFactory();
	static SocketManager socketManager = new SocketManager(sessionFactory);
	PlaceDAO tester = new PlaceDAO(sessionFactory);
	UserDAO tester2 =new UserDAO(sessionFactory);
	/**
	 * This method is to test if the user can add place to his visited list
	 */
	@Test	
	public void testAddToVisitedList(){
		tester2.insertUser("paul", "100000", 40, "20@slk.com","male");
		tester.insertPlace("Inner Land", "Baltimore", "Maryland","Beautiful place has good view and good restuarants", "Boating", "http://wikitravel.org/upload/en/thumb/c/ce/Baltimore24.jpg/400px-Baltimore24.jpg",5);
		tester.addToVisitedList("paul", "Inner Land");
		assertEquals("is inner harbor add to paul's wishList?","Inner Land",tester.listVisitedList("paul").get(0));
	}
	
	/**
	 * To test if give a place can get the people visited it
	 */
	@Test	
	public void testVisitedPeopleList(){
		tester2.insertUser("andy", "100000", 40, "20@slk.com","male");
		tester2.insertUser("fynn", "100000", 40, "20@slk.com","male");
		tester.insertPlace("Inner Land2", "Baltimore", "Maryland","Beautiful place has good view and good restuarants", "Boating", "http://wikitravel.org/upload/en/thumb/c/ce/Baltimore24.jpg/400px-Baltimore24.jpg",5);
		tester.addToVisitedList("paul", "Inner Land");
		tester.addToVisitedList("fynn", "Inner Land");
		assertEquals("is inner harbor has visitors?","paul",tester.ListVisitedPeople("Inner Land2").get(0));
	}
	
}
