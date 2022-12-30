/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernateproyecto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jorge Martínez
 * Importante. Para probar correctamente en los metodos get comprobar que son ids de las tablas
 */
public class HibernateProyectoManyToMany {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(Pedido.class)
                .addAnnotatedClass(Cliente_info.class)
                .addAnnotatedClass(Producto.class)
                .buildSessionFactory();
		 
                Session miSesion = miFactory.openSession();
		
		try {
		
                        
                        //Creamos el cliente y los productos
                        
			Cliente c = new Cliente("Juan","Guzman","avenida");
			Producto p1 = new Producto("Prod1");
                        Producto p2 = new Producto("Prod2");
			
                        //Asociamos  productos y clientes
                       //Desde cliente añadimos producto
                        c.addProducto(p1);
                        //Desde producto añadimos cliente
                        p2.addCliente(c);
                        
                        //Guardamos el cliente
                      
                        miSesion.beginTransaction();
			miSesion.save(c);
                        miSesion.save(p1);
                        miSesion.save(p2);
			miSesion.getTransaction().commit();
			
			System.out.println("Registro insertado en cliente y productos"+c.toString());
			
                        
                        
                        //-----  CONSULTAR LOS PEDIDOS DE UN CLIENTE
                        //NOTA: Debemos comprobar un id que exista en CLIENTE
                        miSesion.beginTransaction();
                        Cliente cli = miSesion.get(Cliente.class, 85);
                        if (cli!=null)
                            System.out.println(cli.toString());
                        else System.out.println("Cliente no existe");
                        //Obtenemos los pedidos del cliente relacionado
                        //System.out.println(cli.getPedidos().toString());
                        for (Producto p:cli.getProductos())
                             System.out.println(p.toString());
                        miSesion.getTransaction().commit();
                        
                       //--------   BORRADO CLIENTE CON PEDIDOS ASOCIADOS -------------------
                        //Previamente comprobar que existe el id del cliente a eliminar
                        //Si no encuentra el cliente c es null
			miSesion.beginTransaction();
                        Cliente clienteBorrado = miSesion.get(Cliente.class,38);
                        if (clienteBorrado != null){
                            miSesion.delete(clienteBorrado);
                            System.out.println("Registro borrado en cliente y pedido"+clienteBorrado.toString());
                        }
                        else 
                            System.out.println("El cliente no existe");
                        
                        miSesion.getTransaction().commit();
                        
                        miSesion.close();
                        
                        
		}catch(Exception e) {
			e.printStackTrace();
					
		}finally {
			
			miFactory.close();
		}
	}
}
