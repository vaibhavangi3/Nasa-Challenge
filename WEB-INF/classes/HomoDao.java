import java.sql.Connection;
import java.sql.PreparedStatement;

public class HomoDao {
	public static int save(String e, String a, String b, String c,String d) {
		try {
			
		Connection con=null;
	    con=ConProvider.getConnection();
	    PreparedStatement ps= con.prepareStatement("insert into homo(id,h_category,h_diseases,h_effected,h_symptoms,date) values(?,?,?,?,?,?)");
	    ps.setString(1, e);
	    ps.setString(2, a);
	    ps.setString(3, b);
	    ps.setString(4, c);
	    //ps.setBlob(5, inputStream);
	    ps.setString(5, d);
	    ps.setDate(6,Formatter.getCurrentDate());
	    ps.executeUpdate();
	    return 1;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

}