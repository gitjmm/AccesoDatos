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

@Entity
@Table(name="cliente_info")
public class Cliente_info implements Serializable{
	
	//Especificamos las propiedades con sus anotaciones
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="web")
	private String web;
	@Column(name="tlf")
	private String tlf;
	@Column(name="comentarios")
	private String comentarios;
        

    public Cliente_info() {
    }

    public Cliente_info(String web, String tlf, String comentarios) {
        this.web = web;
        this.tlf = tlf;
        this.comentarios = comentarios;
        
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    

    // Que columna en la tabla cliente_info tiene la FK
    @JoinColumn(name = "idcliente")
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}



