package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connect to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Yaswanth@1994");
			//creating new statement
			Statement stm = conn.createStatement();
			
			JDBC jdbc = new JDBC();
			
			//create person table
//			jdbc.createTable(stm, "person");
			
			//add person data
//			jdbc.addPerson(stm, 5L, "test", "andhra pradesh");
			
			//update person's name and address
//			jdbc.updatePerson(stm, 5L, "Test", "Andhra pradesh");
			
			//delete person with id
//			jdbc.deletePerson(stm, 5L);
			
			//get persons
			jdbc.getAllPersons(stm);
			
			stm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * Create new person table
	 */
	public String createTable(Statement stm, String tableName) throws SQLException {
		stm.execute("create table " + tableName + "(id int not null AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), address VARCHAR(255))");
		return "created successfully";
	}
	
	/*
	 * Adding new person
	 */
	public String addPerson(Statement stm, Long id, String name, String address) throws SQLException {
		stm.execute("insert into person values(" + id + ", '" + name + "', '" + address +"')");
		return "added successfully";
	}
	
	/*
	 * Updating existing person using person id
	 */
	public String updatePerson(Statement stm, Long id, String name, String address) throws SQLException {
		stm.execute("update person set name = '" + name + "', address= '" + address +"' where id = " + id);
		return "updated successfully";
	}
	
	/*
	 * Delete existing person using person id
	 */
	public String deletePerson(Statement stm, Long id) throws SQLException {
		stm.execute("delete from person where id = " + id);
		return "deleted successfully";
	}
	
	/*
	 * Get all persons data
	 */
	public String getAllPersons(Statement stm) throws SQLException {
		ResultSet rs = stm.executeQuery("select * from person");
		while(rs.next()) {
			System.out.println(rs.getString("id") + ", " + rs.getString("name") + ", " + rs.getString("address"));
		}
		return "fetch data successfull";
	}

}
