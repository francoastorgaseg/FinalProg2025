/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author franko
 */
public class Materia {
    
    /**
 * Representa una asignatura o materia académica
 * Contiene información descriptiva de la materia
 */
    private String codigo;
    private String nombre;
    private String descripcion;
    
    /**
     * Constructor para crear una nueva instancia de Materia
     * @param codigo Código único identificador de la materia
     * @param nombre Nombre completo de la materia
     * @param descripcion Descripción opcional de la materia
     */
    public Materia(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    // GETTERS Y SETTERS
    
    /**
     * @return Código único de la materia
     */
    public String getCodigo() { return codigo; }
    
    /**
     * Establece el código de la materia
     * @param codigo Nuevo código
     */
    public void setCodigo(String codigo) { this.codigo = codigo; }
    
    /**
     * @return Nombre de la materia
     */
    public String getNombre() { return nombre; }
    
    /**
     * Establece el nombre de la materia
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    /**
     * @return Descripción de la materia
     */
    public String getDescripcion() { return descripcion; }
    
    /**
     * Establece la descripción de la materia
     * @param descripcion Nueva descripción
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    /**
     * Representación en String del objeto Materia
     * @return String con formato "Nombre (Código)"
     */
    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
    

