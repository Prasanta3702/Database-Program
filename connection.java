import java.sql.*;

public class connection {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanta", "root", "prasanta");
			Statement statement = connection.createStatement();
	
			
			if(connection != null) {
				System.out.println("Connection success");
				
				ResultSet result = statement.executeQuery("select * from student");
				
				while(result.next()) {
					int id = result.getInt("id");
					String name = result.getString("name");
					String gender = result.getString("gender");
					String program = result.getString("program");
					String state = result.getString("state");
					String city = result.getString("city");
					
					System.out.println(id+"\t"+name+"\t"+gender+"\t"+program+"\t"+state+"\t"+city);
				}
			}
		}
		catch(Exception exc) {
			System.out.println("Error:: ");
			exc.printStackTrace();
		}
	}
}
