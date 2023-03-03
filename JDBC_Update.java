import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Update {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prasanta");
			
			Statement psmt = con.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
				System.out.print("Enter emp ID: ");
				int num = Integer.parseInt(br.readLine());
				
				System.out.print("Enter the name: ");
				String name = br.readLine().toString();
				
				System.out.println("Enter the salary: ");
				int sal = Integer.parseInt(br.readLine());
				
				int count = psmt.executeUpdate("update emp set esal = "+sal+" where eno = "+num);
				if(count >= 0) {
					System.out.println(count+" record update Successfully");
				}
				else {
					System.out.println("No record update");
				}
			
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}

}
