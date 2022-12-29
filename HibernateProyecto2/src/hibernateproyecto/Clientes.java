/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateproyecto;

/**
 *
 * @author Jorge Martinez
 */
import java.io.Serializable;
import javax.persistence.*;
//Si nos pide crear unidad de persistencia podemos indicar suprimir
@Entity
@Table(name="clientes")
public class Clientes implements Serializable{
    /*
    Claves primarias: @GeneratedValue
    Auto. Hibernate elige el campo clave
    Identity. Es la que más se usa. Se basa en un campo auto_increment. Muy usada en MYSQL
    Sequence. Se utiliza en caso de usar una secuencia (elemento que genera valores Oracle y Postgres)
    */
    
	//Especificamos las propiedades
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="direccion")
	private String direccion;
	
	
	//Métodos
	public Clientes() {
		super();
	}


	public Clientes(String nombre, String apellidos, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}
	
	
	

}

