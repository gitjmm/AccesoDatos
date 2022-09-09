/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema4Conectores1;

/**
 *
 * @author Jorge Martínez
 */


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMysql {
        /*
    Definimos e inicializamos constantes:
    DRIVER. Nombre del driver que vamos a utilizar. En este caso de MYSQL
    URL_CONEXION. equipo:puerto/basededatos
    
        */
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/prueba";
        
        public static void main(String args[]) throws SQLException {

            final String usuario = "root";
            final String password = "admin";
            Connection dbConnection = null;
            Statement statement = null;
            try {
                //Registramos el driver de mysql
                Class.forName(DRIVER);
                //Clase DriverManager gestiona todos los drivers que tenemos en nuestra aplicación
                //Devuelve un objeto conexión que utilizaremos para conectarnos a la base de datos
                Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
                //Guardamos en una variable la consulta
                String selectTableSQL = "SELECT ID,USERNAME,PASSWORD,NOMBRE FROM usuarios";
                //Ejecutamos el método createStatement y creamos un objeto statement
                //que nos va a permitir ejecutar consultas
                statement = conn.createStatement();
                //Ejecutamos la consulta y nos devolver un resultset (cursor)
                ResultSet rs = statement.executeQuery(selectTableSQL);
                //Recorremos el resultset y mostramos la información de las columnas
                while (rs.next()) {
                    String id = rs.getString("ID");
                    String usr = rs.getString("USERNAME");
                    String psw = rs.getString("PASSWORD");
                    String nombre = rs.getString("NOMBRE");
                    System.out.println("userid : " + id);
                    System.out.println("usr : " + usr);
                    System.out.println("psw : " + psw);
                    System.out.println("nombre : " + nombre);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
    }   
}

