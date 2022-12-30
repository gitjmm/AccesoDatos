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
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable{
    
    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="forma_pago")
    private String forma_pago;
    @Column(name="idcliente")
    private int idcliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", fecha=" + fecha + ", forma_pago=" + forma_pago + ", idcliente=" + idcliente + '}';
    }

    //Constructores

    public Pedido() {
    }

    public Pedido(Date fecha, String forma_pago) {
        this.fecha = fecha;
        this.forma_pago = forma_pago;
    }
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "clienteid")
    private Cliente cliente_pedido;

    public Cliente getCliente() {
        return cliente_pedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente_pedido = cliente;
    }
    
    
    
}
