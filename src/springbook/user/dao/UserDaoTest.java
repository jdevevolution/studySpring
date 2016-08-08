package springbook.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/springbook/setting/applicationContext.xml")
public class UserDaoTest {
	@Autowired
//	private ApplicationContext context;
	private UserDao dao;
	private User user1;
	private User user2;
	private User user3;
	
	@Before
	public void setUp(){
//		ApplicationContext context = new GenericXmlApplicationContext("springbook/setting/applicationContext.xml");
//		this.dao = (UserDao)context.getBean("userDao", UserDao.class);
//		DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost:3306/springbook","spring","book", true);
//		dao.setdataSource(dataSource);
		this.user1 = new User("lovelyman", "정원석", "@111111");
		this.user2 = new User("lovelygirl", "염선혜", "@22222");
		this.user3 = new User("lovely", "설현", "@1234");
	}
	
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException {
//		ConnectionMaker connectionMaker = new DConnectionMaker();
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

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
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
		
	}
	
//	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException{
		dao.deleteAll();
		
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
	}
}
