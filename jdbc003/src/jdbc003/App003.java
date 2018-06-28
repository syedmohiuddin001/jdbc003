package jdbc003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App003 {

	public static void main(String[] args) {
		
		try (
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "syed");
			Statement st = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				){
			while(true) {
				System.out.print("Employee Number :");
				int eno = Integer.parseInt(br.readLine());
				
				System.out.print("Employee Name :");
				String ename = br.readLine();
				
				System.out.print("Employee Salary :");
				float esal = Float.parseFloat(br.readLine());
				
				System.out.print("Employee Address :");
				String eaddr = br.readLine();
				
				int rowCount = st.executeUpdate("insert into emp values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
				if(rowCount == 1) {
					System.out.println("Employee Inserted Successfully");
					System.out.print("Onemore Employee?[yes/no] :");
					String option = br.readLine();
					if(option.equals("yes")) {
						continue;
					}else {
						break;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
