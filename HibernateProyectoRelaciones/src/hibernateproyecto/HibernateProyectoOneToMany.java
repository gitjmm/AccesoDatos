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
public class HibernateProyectoOneToMany {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(Pedido.class)
                .addAnnotatedClass(Cliente_info.class)
                .buildSessionFactory();
		Session miSesion = miFactory.openSession();
		
		try {
			
                       
                        //Para fechas se puede usar Date o GregorianCalendar
                         Date mifecha = new Date(120,6,4); //año,mes,dia
                        //Otra opcion es transformar la fecha de Java a MYSQL
                        
                        java.util.Date d = new java.util.Date();  
                        java.sql.Date date2 = new java.sql.Date(d.getTime());
                        
                         //Creamos el cliente y pedidos
                        
			Cliente c = miSesion.get(Cliente.class,1);
			Pedido p1 = new Pedido(date2,"Efectivo");
                        Pedido p2 = new Pedido(mifecha,"Paypal");
			
                        //Asociamos cliente con pedidos. Guardamos la info en las dos tablas
                        c.addPedido(p1);
                        c.addPedido(p2);
                        //Guardamos los pedidos
                        miSesion.beginTransaction();
			miSesion.save(p1);
                        miSesion.save(p1);
			miSesion.getTransaction().commit();
			
			System.out.println("Registro insertado en cliente y pedidos"+c.toString());
			
                        //--------   BORRADO CLIENTE CON PEDIDOS ASOCIADOS -------------------
                        //Previamente comprobar que existe el id del cliente a eliminar
                        //Si no encuentra el cliente c es null
			miSesion.beginTransaction();
                        Cliente clienteBorrado = miSesion.get(Cliente.class,3);
                        if (clienteBorrado != null){
                            miSesion.delete(clienteBorrado);
                            System.out.println("Registro borrado en cliente y pedido"+clienteBorrado.toString());
                        }
                        else 
                            System.out.println("El cliente no existe");
                        
                        miSesion.getTransaction().commit();
                        
                        //-----  CONSULTAR LOS PEDIDOS DE UN CLIENTE
                        //NOTA: Debemos comprobar un id que exista en CLIENTE
                        miSesion.beginTransaction();
                        Cliente cli = miSesion.get(Cliente.class, 1);
                        if (cli!=null)
                            System.out.println(cli.toString());
                        else System.out.println("Cliente no existe");
                        //Obtenemos los pedidos del cliente relacionado
                        //System.out.println(cli.getPedidos().toString());
                        for (Pedido p:cli.getPedidos())
                             System.out.println(p.toString());
                        miSesion.getTransaction().commit();
                        
                       
                        
                        
                        
                        
		}catch(Exception e) {
			e.printStackTrace();
					
		}finally {
			miSesion.close();
			miFactory.close();
		}
	}
}
