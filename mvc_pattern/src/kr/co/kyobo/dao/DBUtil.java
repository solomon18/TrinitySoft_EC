package kr.co.kyobo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	
	private static DBUtil instance;
	private DataSource db;

	//Singleton Pattern
	private DBUtil(){
		try {
			Context	initContext = new InitialContext();
			
			db = (DataSource)initContext
					.lookup("java:/comp/env/jdbc/confluence");
		} catch (NamingException e) {
			System.out.println("Lookup Error!!");
		}
	}
	
	public static DBUtil getInstance(){
		if(instance == null ) instance=new DBUtil();
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		Connection conn=null;
		conn = db.getConnection();
		return conn;
	}
	
	public void close(Statement stmt, Connection conn){
		try {
			if(stmt != null )stmt.close();
			if(conn != null )conn.close();
		} catch (SQLException e) {
			System.out.println("�옄�썝諛섎궔 �떎�뙣!!");
		}
	}
	public void close(ResultSet result, Statement stmt, Connection conn){
		try { 
			if(result != null ) result.close();
			if(stmt != null )stmt.close();
			if(conn != null )conn.close();
		} catch (SQLException e) {
			System.out.println("�옄�썝諛섎궔 �떎�뙣!!");
		}
	}
}
