package springbook.user.domain;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {
	int counter = 0;
	private ConnectionMaker realConnectionMaker;
	
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		this.counter++;
		return this.realConnectionMaker.makeConnection();
	}
	
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker){
		this.realConnectionMaker = realConnectionMaker;
	}
	
	public int getCounter(){
		return this.counter;
	}
}
