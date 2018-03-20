import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;



public class Conn {

	public static void main(String[] args) throws Exception{
			String url="jdbc:mysql://localhost/niveau";
			String login="root";
			String password="";
			/*Connection cn=null;
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("ok");
				cn=DriverManager.getConnection(url,login,password);
				System.out.println("connection ok");*/
			JdbcRowSet rowset = RowSetProvider.newFactory().createJdbcRowSet();
			rowset.setUrl(url);
			rowset.setUsername(login);
			rowset.setPassword(password);
			
			rowset.setCommand("select * from niveau4");
			rowset.execute();
			while(rowset.next()){
				System.out.println(rowset.getString(1));
				System.out.println(rowset.getString(2));
				System.out.println(rowset.getString(3));
				System.out.println(rowset.getString(4));
				System.out.println(rowset.getString(5));
				System.out.println(rowset.getString(6));
				System.out.println(rowset.getString(7));
			}
			}
			}


