package main.model;
import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import com.sun.rowset.JdbcRowSetImpl;
public class DbConnect {
	static String url="jdbc:mysql://localhost/niveau";
	static String login="root";
	static String pass="";
	public static void connect(){
		try{
		JdbcRowSet rowset;
			rowset = RowSetProvider.newFactory().createJdbcRowSet();
		rowset.setUrl(url);
		rowset.setUsername(login);
		rowset.setPassword(pass);
		
		rowset.setCommand("select * from niveaux");
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
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}


