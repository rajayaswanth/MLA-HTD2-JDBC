package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connect to database
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Yaswanth@1994");
			Statement stm = conn.createStatement();
			
			//create person table
//			stm.execute("create table person(id int not null AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), address VARCHAR(255))");
			
			//add person - 1
//			stm.execute("insert into person values(1, 'Yaswanth', 'Andhra pradesh')");
			//add person - 2
//			stm.execute("insert into person values(2, 'Test', 'Andhra pradesh')");
			//add person - 3
//			stm.execute("insert into person values(3, 'Test', 'Andhra pradesh')");
			//add person - 4
//			stm.execute("insert into person values(4, 'Test', 'Andhra pradesh')");
			
			//update person-3 name and address
//			stm.execute("update person set name='Test-3', address='Delhi' where id=3;");
			
			//delete person with id - 3 from table
//			stm.execute("delete from person where id = 3");
			
			//get persons
			ResultSet rs = stm.executeQuery("select * from person");
			while(rs.next()) {
				System.out.println(rs.getString("id") + ", " + rs.getString("name") + ", " + rs.getString("address"));
			}
			
			stm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
