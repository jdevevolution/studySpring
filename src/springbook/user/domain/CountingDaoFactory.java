package springbook.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.UserDao;

@Configuration
public class CountingDaoFactory {
	@Bean
	public UserDao userDao(){
		UserDao userDao = new UserDao();
//		userDao.setConnectionMaker(connectionMaker());
		return new UserDao();
	}
	
	@Bean
	public ConnectionMaker connectionMaker(){
		return new CountingConnectionMaker(realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker(){
		return new DConnectionMaker();
	}
}
