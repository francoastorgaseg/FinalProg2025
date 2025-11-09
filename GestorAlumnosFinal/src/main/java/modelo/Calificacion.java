/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author franko
 */
public class Calificacion {
    
    
    /**
 * Representa una calificación asignada a un alumno en una materia específica
 * Relaciona alumno, materia, nota y período académico
 */
    private String idAlumno;
    private String codigoMateria;
    private double nota;
    private int periodo;
    
    /**
     * Constructor para crear una nueva instancia de Calificación
     * @param idAlumno ID del alumno al que pertenece la calificación
     * @param codigoMateria Código de la materia evaluada
     * @param nota Valor numérico de la calificación (0-10)
     * @param periodo Período académico de la calificación
     */
    public Calificacion(String idAlumno, String codigoMateria, double nota, int periodo) {
        this.idAlumno = idAlumno;
        this.codigoMateria = codigoMateria;
        this.nota = nota;
        this.periodo = periodo;
    }
    
    // GETTERS Y SETTERS
    
    /**
     * @return ID del alumno asociado a la calificación
     */
    public String getIdAlumno() { return idAlumno; }
    
    /**
     * Establece el ID del alumno
     * @param idAlumno Nuevo ID de alumno
     */
    public void setIdAlumno(String idAlumno) { this.idAlumno = idAlumno; }
    
    /**
     * @return Código de la materia asociada
     */
    public String getCodigoMateria() { return codigoMateria; }
    
    /**
     * Establece el código de materia
     * @param codigoMateria Nuevo código de materia
     */
    public void setCodigoMateria(String codigoMateria) { this.codigoMateria = codigoMateria; }
    
    /**
     * @return Valor numérico de la nota
     */
    public double getNota() { return nota; }
    
    /**
     * Establece el valor de la nota
     * @param nota Nueva nota (debe estar entre 0 y 10)
     */
    public void setNota(double nota) { this.nota = nota; }
    
    /**
     * @return Período académico
     */
    public int getPeriodo() { return periodo; }
    
    /**
     * Establece el período académico
     * @param periodo Nuevo período (debe ser positivo)
     */
    public void setPeriodo(int periodo) { this.periodo = periodo; }
}

