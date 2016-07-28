package springbook.user.domain;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoConnectionCountingTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		/**
		 * DAO ����ڵ�
		 */
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter"+ ccm.getCounter());
		
		
		User user = new User();
		user.setId("whiteship");
		user.setName("��⼱");
		user.setPassword("married");
		
		dao.add(user);
		System.out.println("Connection counter1 "+ ccm.getCounter());
		System.out.println(user.getId() + "��� ����");
		
		User user2 = dao.get(user.getId());
		System.out.println("Connection counter2 "+ ccm.getCounter());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId()+" ��ȸ ����");
	}

}
