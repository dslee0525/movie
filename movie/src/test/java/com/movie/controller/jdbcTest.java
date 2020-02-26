package com.movie.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class jdbcTest {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/movie?serverTimezone=Asia/Seoul";
	private static final String USERID="root";
	private static final String PW="1234";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try {
		Connection conn = DriverManager.getConnection(URL, USERID, PW);
		System.out.println("conn = "+conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
