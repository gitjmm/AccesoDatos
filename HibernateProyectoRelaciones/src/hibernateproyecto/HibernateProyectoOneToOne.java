/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hibernateproyecto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jorge Martínez
 */
public class HibernateProyectoOneToOne {

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
                      
			Cliente cliente = new Cliente("Toni","Martínez","c/cilla");
			Cliente_info cliente_info = new Cliente_info("www.miotraweb.com","123456","c/jon");
			//-------------   INSERCION -------------
                        //Asociamos cliente con cliente_info. Guardamos la info en las dos tablas
                        cliente_info.setCliente(cliente);
                        cliente.setCinfo(cliente_info);
                        
                        miSesion.beginTransaction();
			miSesion.save(cliente);
			miSesion.getTransaction().commit();
			
			System.out.println("Registro insertado en cliente y cliente info"+cliente.toString());
			
                        //--------   BORRADO -------------------
                        //Previamente comprobar que existe el id del cliente a eliminar
                        //Si no encuentra el cliente c es null
			miSesion.beginTransaction();
                        Cliente clienteBorrado = miSesion.get(Cliente.class,25);
                        if (clienteBorrado != null){
                            miSesion.delete(clienteBorrado);
                            System.out.println("Registro borrado en cliente y cliente info"+clienteBorrado.toString());
                        }
                        else 
                            System.out.println("El cliente no existe");
                        
                        miSesion.getTransaction().commit();
                        
                        //-----  CONSULTAS DESDE CLIENTE_INFO (bidireccional)
                        //NOTA: Debemos comprobar un id que exista en cliente_info
                        miSesion.beginTransaction();
                        Cliente_info cinfo = miSesion.get(Cliente_info.class, 28);
                        System.out.println(cinfo.toString());
                        //Obtenemos la información del cliente relacionado
                        System.out.println(cinfo.getCliente().toString());
                        miSesion.getTransaction().commit();
                        
                        //----- CONSULTAS DESDE CLIENTE (bidireccional)
                        //NOTA: Debemos comprobar un id que exista en cliente
                        miSesion.beginTransaction();
                        Cliente clienteConsulta = miSesion.get(Cliente.class, 27);
                        System.out.println(clienteConsulta.toString());
                        //Obtenemos la información del cliente_info relacionado
                        System.out.println(clienteConsulta.getCinfo().toString());
                        miSesion.getTransaction().commit();
                        
                        
                        
                        
		}catch(Exception e) {
			e.printStackTrace();
					
		}finally {
			miSesion.close();
			miFactory.close();
		}
	}
    }
    

