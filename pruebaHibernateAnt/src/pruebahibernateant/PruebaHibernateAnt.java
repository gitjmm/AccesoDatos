/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebahibernateant;

import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Usuario
 */
public class PruebaHibernateAnt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try ( //SessionFactory instancia = (SessionFactory) HibernateUtil.buildSessionFactory();
            SessionFactory instancia = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory()) {
            Session session = instancia.openSession();
            Customer c = new Customer("Juan","Perez",100);
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            System.out.println("Registro insertado");
        }catch(HibernateException he){
            System.out.println(he);
        }finally{
            
        }
        
   }
}
    

