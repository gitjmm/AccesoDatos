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
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session miSesion = miFactory.openSession();
		
		try {
			//Creamos el cliente. Iniciamos la transacción. Guardamos cliente. Commit
			Clientes cliente = new Clientes("Jorge","Martínez","c/jon");
			Clientes cliente2 = new Clientes("Toni","Gomez","c/cilla");
			miSesion.beginTransaction();
			miSesion.save(cliente);
			miSesion.save(cliente2);
			miSesion.getTransaction().commit();
			
			System.out.println("Registro insertado en clientes");
			
			//Lectura registros
			
			
			
			//Actualizar cliente
			
			
			//Borrar cliente
			
		}catch(Exception e) {
			e.printStackTrace();
					
		}finally {
			miSesion.close();
			miFactory.close();
		}
	}
    }
    

