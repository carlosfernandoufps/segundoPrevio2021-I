package co.empresa.segundoPrevio.modelo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Candidato implements Serializable {

	private Integer id;
	private String documento;
	private String nombre;
	private String apellido;
	private Integer eleccion;
	private Integer numero;
	
	
	
	public Candidato(Integer id, String documento, String nombre, String apellido, Integer eleccion ,Integer numero) {
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
		this.numero = numero;
	}
	
	public Candidato(String documento, String nombre, String apellido, Integer eleccion ,Integer numero) {
		this(null, documento, nombre, apellido, eleccion, numero);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}public Integer getEleccion() {
		return eleccion;
	}
	public void setEleccion(Integer eleccion) {
		this.eleccion = eleccion;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	
}
