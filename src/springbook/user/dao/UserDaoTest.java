package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ConnectionMaker connectionMaker = new DConnectionMaker();
		System.out.println(1);
		ApplicationContext context = new GenericXmlApplicationContext("springbook/setting/applicationContext.xml");
		System.out.println(2);
		/*UserDao dao = (UserDao)context.getBean("userDao");

		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId()+" 조회 성공");*/
	}

}
