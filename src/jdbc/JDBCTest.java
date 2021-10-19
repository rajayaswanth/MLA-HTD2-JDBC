package jdbc;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JDBCTest {
	
	JDBC jdbc = new JDBC();
	static Statement stm;
	static Connection conn;
	
	@BeforeAll
	public static void setup() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Yaswanth@1994");
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
	
	@AfterAll
	public static void tearDown() throws SQLException {
		stm.close();
		conn.close();
	}
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void createTableTest() throws SQLException {
		String response = jdbc.createTable(stm, "test");
		assertEquals("created successfully", response);
	}
	
	@Test
	public void addPersonTest() throws SQLException {
		String response = jdbc.addPerson(stm, 5L, "test", "AP");
		assertEquals("added successfully", response);
	}
	
	@Test
	public void updatePersonTest() throws SQLException {
		String response = jdbc.updatePerson(stm, 5L, "Test", "AP");
		assertEquals("updated successfully", response);
	}
	
	@Test
	public void deletePersonTest() throws SQLException {
		String response = jdbc.deletePerson(stm, 5L);
		assertEquals("deleted successfully", response);
	}
	
	@Test
	public void getAllPersonsTest() throws SQLException {
		String response = jdbc.getAllPersons(stm);
		assertEquals("fetch data successfull", response);
	}

}
