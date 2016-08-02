package springbook.user.dao;

import java.sql.SQLException;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import springbook.user.domain.User;

public class UserDaoTest {

	public void addAndGet() throws ClassNotFoundException, SQLException {
//		ConnectionMaker connectionMaker = new DConnectionMaker();
		ApplicationContext context = new GenericXmlApplicationContext("springbook/setting/applicationContext.xml");
		UserDao dao = (UserDao)context.getBean("userDao", UserDao.class);
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		User user1 = new User("lovelyman", "정원석", "@111111");
		User user2 = new User("lovelygirl", "염선혜", "@22222");
		dao.add(user1);
		dao.add(user2);

		
		User userGet1 = dao.get(user1.getId());
		User userGet2 = dao.get(user2.getId());
		/*System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId()+" 조회 성공");*/
		
		
		assertThat(userGet1.getName(), is(user1.getName()));
		assertThat(userGet1.getPassword(), is(user1.getPassword()));
		assertThat(userGet2.getName(), is(user2.getName()));
		assertThat(userGet2.getPassword(), is(user2.getPassword()));
	}
	
	/*public static void main(String[] args){
		JUnitCore.main("springbook.user.dao.UserDaoTest");
	}*/
	@Test
	public void count() throws SQLException{
		ApplicationContext context = new GenericXmlApplicationContext("springbook/setting/applicationContext.xml");
		UserDao dao = (UserDao)context.getBean("userDao", UserDao.class);
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		User user1 = new User("lovelyman", "정원석", "@1234");
		User user2 = new User("lovelyman2", "정원석2", "@1234");
		User user3 = new User("lovelyman3", "정원석3", "@1234");
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
		
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException{
		ApplicationContext context = new GenericXmlApplicationContext("springbook/setting/applicationContext.xml");
		UserDao dao = (UserDao)context.getBean("userDao", UserDao.class);
		dao.deleteAll();
		
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
	}
}
