package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import springbook.user.domain.User;

public class UserDao {
//	private ConnectionMaker connectionMaker;
	private Connection c;
	private User user;
	private DataSource dataSource;
	
	public UserDao(){
		/*DaoFactory daoFactory = new DaoFactory();
		this.connectionMaker = daoFactory.connectionMaker();
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		ApplicationContext context = new GenericXmlApplicationContext("springbook/setting/applicationContext.xml");
		this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);*/
	}
	
	public UserDao(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void setdataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void add(User user) throws SQLException{
		Connection c = dataSource.getConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users (id, name, password) values(?,?,?)");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws SQLException{
		this.c = dataSource.getConnection();

		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		this.user = new User();
		this.user.setId(rs.getString("id"));
		this.user.setName(rs.getString("name"));
		this.user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return this.user;
	}
}
