import java.sql.Connection;
import java.sql.DriverManager;

public class ConProvider {
	static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nasa","root","");
		}catch(Exception e) {}
	return con;
	}

}
