/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebahibernateant;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Usuario
 */
public class HibernateUtil {
    public static SessionFactory buildSessionFactory(){
        
        return (SessionFactory) new Configuration().configure().buildSessionFactory();
        //return (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).openSession();
    }
}
