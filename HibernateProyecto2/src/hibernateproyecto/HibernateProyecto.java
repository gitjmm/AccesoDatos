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
			Clientes cliente = new Clientes("Juan","Martínez","c/jon");
			Clientes cliente2 = new Clientes("Ana","Nuñez","c/cilla");
			
                        //Inserción registros. Método save
                        miSesion.beginTransaction();
			miSesion.save(cliente);
			miSesion.save(cliente2);
			miSesion.getTransaction().commit();
			
			System.out.println("Registro insertado en clientes");
			
			//Obtener registros. Método get.
			miSesion.beginTransaction();
			System.out.println("Consulta de Id: "+cliente.getId());
                        
                        Clientes miCliente = miSesion.get(Clientes.class, cliente.getId());
			System.out.println("Datos de cliente:"+ miCliente);
			
                        miSesion.getTransaction().commit();
			
                        //-----------------CONSULTAS HQL --------------------
			//Consultas HQL (Hibernate Query Language). createQuery
                        //importamos java.util.List
                        //from Clientes. Clientes es la clase Clientes
                        //Imprime todos los clientes
                        List<Clientes> clientes = miSesion.createQuery("from Clientes").getResultList();
                        for (Clientes c:clientes)
                            System.out.println(c);
                        
                        
                        //Consultar los que se llamen Ana
                        List<Clientes> clientes2 = miSesion.createQuery("from Clientes cl where cl.nombre='Ana'").getResultList();
                        for (Clientes c:clientes2)
                            System.out.println(c);
                        
                        //Consultar los que se llamen Ana y de apellido Nuñez
                        List<Clientes> clientes3 = miSesion
                                                    .createQuery("from Clientes cl where cl.nombre='Ana'"+"and cl.apellidos='Nuñez'")
                                                    .getResultList();
                        for (Clientes c:clientes3)
                            System.out.println(c);
			

                        //------- ACTUALIZAR CLIENTES
                        //Actualizar cliente con id
			int idCliente=26; //Comprobar ids en tabla clientes
                        miSesion.beginTransaction();
			
                        Clientes c = miSesion.get(Clientes.class, idCliente);
                        c.setNombre("Nuevo Nombre");
                        
			miSesion.getTransaction().commit();
                        System.out.println("Registro actualizado");
                        
                        
                        //Actualización con UPDATE
                        miSesion.beginTransaction();
                        miSesion.createQuery("UPDATE Clientes SET apellidos='Moreno' WHERE apellidos LIKE 'M%'")
                                .executeUpdate();
                        miSesion.getTransaction().commit();
                        System.out.println("Registros actualizados");
			
                        //-----------BORRAR CLIENTES
			//Borrar clientes
			miSesion.beginTransaction();
                        miSesion.createQuery("DELETE FROM Clientes WHERE nombre = 'Ana'")
                                .executeUpdate();
                        miSesion.getTransaction().commit();
                        System.out.println("Registros eliminados");
		}catch(Exception e) {
			e.printStackTrace();
					
		}finally {
			miSesion.close();
			miFactory.close();
		}
	}
    //Método que muestra los clientes
    /*private static void mostrarClientes(List<Clientes> clientes) {
        for (Clientes c : clientes)
            System.out.println(c);
    */
    }
//}
    

