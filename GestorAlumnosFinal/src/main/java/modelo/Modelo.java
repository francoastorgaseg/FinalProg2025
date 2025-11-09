/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franko
 */
public class Modelo {
    
    /**
 * Clase principal del modelo que actúa como capa de datos
 * Gestiona las operaciones CRUD para alumnos, materias y calificaciones
 * Implementa la lógica de negocio para cálculos de promedios
 */
    private List<Alumno> alumnos;
    private List<Materia> materias;
    private List<Calificacion> calificaciones;
    
    /**
     * Constructor que inicializa las listas de datos
     */
    public Modelo() {
        this.alumnos = new ArrayList<>();
        this.materias = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }
    
    // MÉTODOS PARA ALUMNOS
    
    /**
     * Agrega un nuevo alumno al sistema
     * @param alumno Objeto Alumno a agregar
     */
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }
    
    /**
     * Obtiene una copia de la lista de todos los alumnos
     * @return Lista inmutable de alumnos
     */
    public List<Alumno> getAlumnos() {
        return new ArrayList<>(alumnos);
    }
    
    /**
     * Busca un alumno por su ID
     * @param id Identificador del alumno a buscar
     * @return Objeto Alumno si se encuentra, null en caso contrario
     */
    public Alumno buscarAlumno(String id) {
        return alumnos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    // MÉTODOS PARA MATERIAS
    
    /**
     * Agrega una nueva materia al sistema
     * @param materia Objeto Materia a agregar
     */
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }
    
    /**
     * Obtiene una copia de la lista de todas las materias
     * @return Lista inmutable de materias
     */
    public List<Materia> getMaterias() {
        return new ArrayList<>(materias);
    }
    
    /**
     * Busca una materia por su código
     * @param codigo Código de la materia a buscar
     * @return Objeto Materia si se encuentra, null en caso contrario
     */
    public Materia buscarMateria(String codigo) {
        return materias.stream()
                .filter(m -> m.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
    
    // MÉTODOS PARA CALIFICACIONES
    
    /**
     * Agrega una nueva calificación al sistema
     * @param calificacion Objeto Calificacion a agregar
     */
    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }
    
    /**
     * Obtiene una copia de la lista de todas las calificaciones
     * @return Lista inmutable de calificaciones
     */
    public List<Calificacion> getCalificaciones() {
        return new ArrayList<>(calificaciones);
    }
    
    /**
     * Obtiene todas las calificaciones de un alumno específico
     * @param idAlumno ID del alumno cuyas calificaciones se buscan
     * @return Lista de calificaciones del alumno
     */
    public List<Calificacion> getCalificacionesAlumno(String idAlumno) {
        List<Calificacion> resultado = new ArrayList<>();
        for (Calificacion c : calificaciones) {
            if (c.getIdAlumno().equals(idAlumno)) {
                resultado.add(c);
            }
        }
        return resultado;
    }
    
    // MÉTODOS PARA CÁLCULOS
    
    /**
     * Calcula el promedio general de un alumno
     * @param idAlumno ID del alumno para calcular promedio
     * @return Promedio numérico, 0.0 si no tiene calificaciones
     */
    public double calcularPromedioAlumno(String idAlumno) {
        List<Calificacion> califs = getCalificacionesAlumno(idAlumno);
        if (califs.isEmpty()) return 0.0;
        
        double suma = 0.0;
        for (Calificacion c : califs) {
            suma += c.getNota();
        }
        return suma / califs.size();
    }
    
    /**
     * Calcula el promedio general de una materia
     * @param codigoMateria Código de la materia para calcular promedio
     * @return Promedio numérico, 0.0 si no tiene calificaciones
     */
    public double calcularPromedioMateria(String codigoMateria) {
        double suma = 0.0;
        int count = 0;
        
        for (Calificacion c : calificaciones) {
            if (c.getCodigoMateria().equals(codigoMateria)) {
                suma += c.getNota();
                count++;
            }
        }
        
        return count > 0 ? suma / count : 0.0;
    }

    
}
