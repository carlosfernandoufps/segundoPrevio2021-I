package co.empresa.segundoPrevio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.segundoPrevio.modelo.Candidato;
import co.empresa.segundoPrevio.util.Conexion;

public class CandidatoDao {
	
	private Conexion conexion;
	private static final String INSERT_USUARIO_SQL = "INSERT INTO candidato (documento, nombre, apellido, eleccion, numero) VALUES (?, ?, ?, ?, ?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM candidato WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE candidato SET documento = ?, nombre = ?, apellido = ?, eleccion = ?, numero = ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM candidato WHERE id = ?;";
	private static final String SELECT_ALL_USUARIO_SQL = "SELECT * FROM candidato;";
	
	
	public CandidatoDao(){
		this.conexion = Conexion.getConexion();
	}
	
	public void insert(Candidato candidato) throws SQLException{
		try{
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, candidato.getDocumento());
			preparedStatement.setString(2, candidato.getNombre());
			preparedStatement.setString(3, candidato.getApellido());
			preparedStatement.setInt(4, candidato.getEleccion());
			preparedStatement.setInt(5, candidato.getNumero());
			conexion.execute();
		}catch(SQLException e){
			
		}
	}
	
	public void delete(int id) throws SQLException{
		try{
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		}catch(SQLException e){
			
		}
	}
	
	public void update(Candidato candidato) throws SQLException{
		try{
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, candidato.getDocumento());
			preparedStatement.setString(2, candidato.getNombre());
			preparedStatement.setString(3, candidato.getApellido());
			preparedStatement.setInt(4, candidato.getEleccion());
			preparedStatement.setInt(5, candidato.getNumero());
			preparedStatement.setInt(6, candidato.getId());
			conexion.execute();
		}catch(SQLException e){
			
		}
	}
	   
	public List<Candidato> selectAll() throws SQLException{
		List<Candidato> candidatos = new ArrayList<>();
		try{
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIO_SQL);
			ResultSet rs = conexion.query();
			while(rs.next()){
				int id = rs.getInt("id");
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int eleccion = rs.getInt("eleccion");
				int numero = rs.getInt("numero");
				candidatos.add(new Candidato(id, documento, nombre, apellido, eleccion, numero));
			}
		}catch(SQLException e){
			
		}
		return candidatos;
	}
	
	public Candidato select(int id) throws SQLException{
		Candidato candidato = null;
		try{
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()){
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int eleccion = rs.getInt("eleccion");
				int numero = rs.getInt("numero");
				candidato = new Candidato(id, documento, nombre, apellido, eleccion, numero);
			}
		}catch(SQLException e){
			
		}
		return candidato;
	}
	
}
