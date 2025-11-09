/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author franko
 */
public class Alumno {
    
    /**
 * Representa un estudiante en el sistema
 * Contiene información personal y académica básica
 */

    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    
    /**
     * Constructor para crear una nueva instancia de Alumno
     * @param id Identificador único del alumno
     * @param nombre Nombre del alumno
     * @param apellido Apellido del alumno
     * @param edad Edad del alumno en años
     */
    public Alumno(String id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
    // GETTERS Y SETTERS
    
    /**
     * @return Identificador único del alumno
     */
    public String getId() { return id; }
    
    /**
     * Establece el identificador del alumno
     * @param id Nuevo identificador
     */
    public void setId(String id) { this.id = id; }
    
    /**    public void setId(String id) { this.id = id; }

     * @return Nombre del alumno
     */
    public String getNombre() { return nombre; }
    
    /**
     * Establece el nombre del alumno
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    /**
     * @return Apellido del alumno
     */
    public String getApellido() { return apellido; }
    
    /**
     * Establece el apellido del alumno
     * @param apellido Nuevo apellido
     */
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    /**
     * @return Edad del alumno en años
     */
    public int getEdad() { return edad; }
    
    /**
     * Establece la edad del alumno
     * @param edad Nueva edad (debe ser positiva)
     */
    public void setEdad(int edad) { this.edad = edad; }
    
    /**
     * Representación en String del objeto Alumno
     * @return String con formato "Nombre Apellido (X años)"
     */
    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + edad + " años)";
    }
}
    

