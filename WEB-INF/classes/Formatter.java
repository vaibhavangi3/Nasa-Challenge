
import java.text.SimpleDateFormat;

public class Formatter {
	public static java.sql.Date getSqlDate(String strDate){
		java.sql.Date sqlDate=null;
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
			java.util.Date utilDate=format.parse(strDate);
			sqlDate=new java.sql.Date(utilDate.getTime());
		}catch(Exception e) {
			System.out.println(e);
		}
		return sqlDate;
	}
public static java.sql.Date getCurrentDate(){
	java.sql.Date sqlCurentDate=null;
	try{
		java.util.Date utilDate=java.util.Calendar.getInstance().getTime();
				sqlCurentDate=new java.sql.Date(utilDate.getTime());
		}catch(Exception e){
			System.out.println(e);
		}
	return sqlCurentDate;
	}
}