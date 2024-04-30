/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package entornosdesarrollo.empleado;

/**
* Esta clase contiene los atributos y metodos de un empleado
* @author Jorge Martínez
* @version 1.0
*/
public class Empleado {
  
   private int numeroEmpleado;
   private String departamento;
   private String puesto;
  
   /**
    * Metodo constructores por defecto
    */
   public Empleado(){
   }
  
   /**
    * Metodo constructor parametrizado
    * @param numeroEmpleado Numero de empleado
    * @param departamento Departamento donde trabajara el empleado
    * @param puesto Puesto que ocupara el empleado dentro de la empresa
    */
   public Empleado(
                   int numeroEmpleado,
                   String departamento,
                   String puesto){
      
       this.numeroEmpleado = numeroEmpleado;
       this.departamento = departamento;
       this.puesto = puesto;
   }
  
   /**
    * Metodo para regresar el numero de empelado
    * @return Regresa el numero del empleado
    */
   public int getNumeroEmpleado() {
       return numeroEmpleado;
   }
  
   /**
    * Establece el numero del empleado
    * @param numeroEmpleado Numero que se le asignara al empleado
    */
   public void setNumeroEmpleado(int numeroEmpleado) {
       this.numeroEmpleado = numeroEmpleado;
   }
  
   /**
    * Metodo que regresa el nombre del departamento asignado al empleado
    * @return Regresa el departamento
    */
   public String getDepartamento() {
       return departamento;
   }
  
   /**
    * Metodo que le asigna departamento a un empelado
    * @param departamento Nombre de departamento
    */
   public void setDepartamento(String departamento) {
       this.departamento = departamento;
   }
  
   /**
    * Metodo que regresa el puesto del empleado
    * @return Regresa un String que indica el puesto
    */
   public String getPuesto() {
       return puesto;
   }
  
   /**
    * Metodo que establece el puesto del empleado
    * @param puesto Indica el puesto del empleado
    */
   public void setPuesto(String puesto) {
       this.puesto = puesto;
   }
}