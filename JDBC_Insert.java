import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class JDBC_Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prasanta");
			
			PreparedStatement psmt = con.prepareStatement("insert into emp values(?,?,?)");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("Enter emp ID: ");
				int num = Integer.parseInt(br.readLine());
				
				System.out.print("Enter the name: ");
				String name = br.readLine().toString();
				
				System.out.println("Enter the salary: ");
				int sal = Integer.parseInt(br.readLine());
				
				// for set the columns position values
				
				psmt.setInt(1, num);
				psmt.setString(2, name);
				psmt.setInt(3, sal);
				
				int count = psmt.executeUpdate();
				if(count >= 0) {
					System.out.println(count+" record Insert Successfully");
				}
				else {
					System.out.println("No record Insert");
				}
				
				System.out.println("Do you want to insert more record (Y/N): ");
				String choice = br.readLine();
				if(choice.equalsIgnoreCase("N")) {
					break;
				}
			}
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}

}
