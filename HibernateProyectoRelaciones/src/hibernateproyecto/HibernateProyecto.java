/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hibernateproyecto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Usuario
 */
public class HibernateProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cliente.class)
                .addAnnotatedClass(Cliente_info.class)
                .buildSessionFactory();
		Session miSesion = miFactory.openSession();
		
		try {
			
                        //Creamos el cliente. Iniciamos la transacción. Guardamos cliente. Commit
                        //OJO en cliente_info el ultimo parametro es fk (id de cliente)
			Cliente cliente = new Cliente("Jorge","Martínez","c/jon");
			Cliente_info cliente_info = new Cliente_info("www.miweb.com","123456789","c/jon");
			
                        //Asociamos cliente con cliente_info. Guardamos la info en las dos tablas
                        cliente_info.setCliente(cliente);
                        cliente.setCinfo(cliente_info);
                        
                        miSesion.beginTransaction();
			miSesion.save(cliente);
			miSesion.getTransaction().commit();
			
			System.out.println("Registro insertado en cliente y cliente info");
			
			
		}catch(Exception e) {
			e.printStackTrace();
					
		}finally {
			miSesion.close();
			miFactory.close();
		}
	}
    }
    

