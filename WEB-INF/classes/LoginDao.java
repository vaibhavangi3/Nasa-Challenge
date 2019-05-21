import java.sql.*;
import java.sql.PreparedStatement;



public class LoginDao {

	public static int validate(String n, String p) {
		int z=0;
		try {
			Connection con=null;
		    con=ConProvider.getConnection();
		    PreparedStatement ps= con.prepareStatement("Select * from log_in where l_id=? and pass=? and autherized=?");
		    ps.setString(1, n);
		    ps.setString(2, p);
		    ps.setString(3,"yes");
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()) {
		    	z=1;
		    }
		}catch(Exception ex) {
			System.out.println(ex);
			
		}
		if(z==1)
			return 1;
		else
		return 0;
	}

}
