package co.empresa.segundoPrevio.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Conexion {

	private Connection con = null;
	private static Conexion db;
	private PreparedStatement preparedStatement;
	
	private static final String url = "postgres://mnjgxshj:Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV@queenie.db.elephantsql.com/mnjgxshj";
	private static final String dbname = "mnjgxshj";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String username = "mnjgxshj";
	private static final String password = "mnjgxshj";
	
	public Conexion(){
		try{
			Class.forName(driver).newInstance();
			con = (Connection) DriverManager.getConnection(url+dbname, username, password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion(){
		if(db == null){
			db = new Conexion();
		}
		return db;
	}
	
	public ResultSet query() throws SQLException{
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	public int execute() throws SQLException{
		int res = preparedStatement.executeUpdate();
		return res;
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException{
		this.preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		return this.preparedStatement;
	}
	
}
