package jdbc;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JDBCTest {
	
	JDBC jdbc = new JDBC();
	static Statement stm;
	
	@BeforeAll
	public static void setup() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connect to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Yaswanth@1994");
			//creating new statement
			stm = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void getAllPersonsTest() throws SQLException {
		String response = jdbc.getAllPersons(stm);
		assertEquals("fetch data successfull", response);
	}

}
