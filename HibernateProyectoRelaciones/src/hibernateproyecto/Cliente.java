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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	//Especificamos las propiedades con sus anotaciones
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellidos;
	@Column(name="direccion")
	private String direccion;
	
	
	//Métodos
	public Cliente() {
		super();
	}


	public Cliente(String nombre, String apellidos, String direccion) {
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
	
	//Relacionamos con la tabla cliente
        //mappedBy. Indica la tabla principal y hacemos referencia al atributo cliente de cliente_info
        //CascadeType.ALL. Aplica en la tabla hija cualquier cambio realizado en la principal
        //@JoinColumn. Indica la columna usada en la join
        @OneToOne(mappedBy = "cliente",cascade=CascadeType.ALL)
        private Cliente_info cinfo;
        public Cliente_info getCinfo() {
            return cinfo;
        }
        public void setCinfo(Cliente_info cinfo) {
            this.cinfo = cinfo;
        }
        
        
        //Relación con la tabla pedido
        @OneToMany(mappedBy = "cliente_pedido", cascade = CascadeType.ALL)
       
        private List<Pedido> pedidos;
        
        public List<Pedido> getPedidos(){
            return pedidos;
        }
        
        public void addPedido(Pedido p){
            if (pedidos == null) pedidos=new ArrayList<>();
            pedidos.add(p);
            p.setCliente(this);
        }

}

