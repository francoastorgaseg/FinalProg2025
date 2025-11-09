/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Alumno;
import modelo.Calificacion;
import modelo.Materia;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author franko
 */
public class Controlador {
    
    /**
 * Clase controladora que coordina las interacciones entre Modelo y Vista
 * Implementa el patrón MVC como intermediario entre la lógica y la interfaz
 * Gestiona eventos de usuario y actualiza ambos componentes
 * 
 * @author Sistema de Gestión de Notas
 * @version 1.0
 */
    private Modelo modelo;
    private Vista vista;
    
    /**
     * Constructor del controlador que establece las relaciones MVC
     * 
     * @param modelo Instancia del modelo de datos
     * @param vista Instancia de la interfaz de usuario
     */
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        configurarListeners();
        actualizarCombos();
    }
    
    /**
     * Configura todos los listeners de la interfaz gráfica
     * Conecta los eventos de la vista con los métodos correspondientes del controlador
     */
    private void configurarListeners() {
        // Listeners para Alumnos
        vista.agregarListenerAgregarAlumno(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAlumno();
            }
        });
        
        vista.agregarListenerListarAlumnos(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAlumnos();
            }
        });
        
        // Listeners para Materias
        vista.agregarListenerAgregarMateria(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarMateria();
            }
        });
        
        vista.agregarListenerListarMaterias(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarMaterias();
            }
        });
        
        // Listeners para Calificaciones
        vista.agregarListenerAgregarCalificacion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCalificacion();
            }
        });
        
        vista.agregarListenerListarCalificaciones(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarCalificaciones();
            }
        });
        
        // Listeners para Reportes
        vista.agregarListenerPromedioAlumno(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReportePromediosAlumnos();
            }
        });
        
        vista.agregarListenerPromedioMateria(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReportePromediosMaterias();
            }
        });
    }
    
    /**
     * Procesa la adición de un nuevo alumno al sistema
     * Valida los datos ingresados y notifica al modelo
     */
    private void agregarAlumno() {
        try {
            String id = vista.getIdAlumno();
            String nombre = vista.getNombreAlumno();
            String apellido = vista.getApellidoAlumno();
            int edad = vista.getEdadAlumno();
            
            // Validaciones de campos obligatorios
            if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
                vista.mostrarError("Todos los campos son obligatorios");
                return;
            }
            
            // Validación de edad positiva
            if (edad <= 0) {
                vista.mostrarError("La edad debe ser un número positivo");
                return;
            }
            
            // Crear y agregar alumno al modelo
            Alumno alumno = new Alumno(id, nombre, apellido, edad);
            modelo.agregarAlumno(alumno);
            vista.limpiarCamposAlumno();
            vista.mostrarMensaje("Alumno agregado exitosamente");
            actualizarCombos();
        } catch (Exception e) {
            vista.mostrarError("Error al agregar alumno: " + e.getMessage());
        }
    }
    
    /**
     * Solicita al modelo la lista de alumnos y actualiza la vista
     */
    private void listarAlumnos() {
        List<Alumno> alumnos = modelo.getAlumnos();
        vista.actualizarTablaAlumnos(alumnos);
    }
    
    /**
     * Procesa la adición de una nueva materia al sistema
     * Valida los datos ingresados y notifica al modelo
     */
    private void agregarMateria() {
        try {
            String codigo = vista.getCodigoMateria();
            String nombre = vista.getNombreMateria();
            String descripcion = vista.getDescripcionMateria();
            
            // Validaciones de campos obligatorios
            if (codigo.isEmpty() || nombre.isEmpty()) {
                vista.mostrarError("Código y nombre son obligatorios");
                return;
            }
            
            // Crear y agregar materia al modelo
            Materia materia = new Materia(codigo, nombre, descripcion);
            modelo.agregarMateria(materia);
            vista.limpiarCamposMateria();
            vista.mostrarMensaje("Materia agregada exitosamente");
            actualizarCombos();
        } catch (Exception e) {
            vista.mostrarError("Error al agregar materia: " + e.getMessage());
        }
    }
    
    /**
     * Solicita al modelo la lista de materias y actualiza la vista
     */
    private void listarMaterias() {
        List<Materia> materias = modelo.getMaterias();
        vista.actualizarTablaMaterias(materias);
    }
    
    /**
     * Procesa la adición de una nueva calificación al sistema
     * Valida los datos ingresados y notifica al modelo
     */
    private void agregarCalificacion() {
        try {
            String idAlumno = vista.getAlumnoSeleccionado();
            String codigoMateria = vista.getMateriaSeleccionada();
            double nota = vista.getNota();
            int periodo = vista.getPeriodo();
            
            // Validaciones de selección
            if (idAlumno == null || codigoMateria == null) {
                vista.mostrarError("Debe seleccionar un alumno y una materia");
                return;
            }
            
            // Validación de rango de nota
            if (nota < 0 || nota > 10) {
                vista.mostrarError("La nota debe estar entre 0 y 10");
                return;
            }
            
            // Validación de período positivo
            if (periodo <= 0) {
                vista.mostrarError("El período debe ser un número positivo");
                return;
            }
            
            // Crear y agregar calificación al modelo
            Calificacion calificacion = new Calificacion(idAlumno, codigoMateria, nota, periodo);
            modelo.agregarCalificacion(calificacion);
            vista.limpiarCamposCalificacion();
            vista.mostrarMensaje("Calificación agregada exitosamente");
        } catch (Exception e) {
            vista.mostrarError("Error al agregar calificación: " + e.getMessage());
        }
    }
    
    /**
     * Solicita al modelo la lista de calificaciones y actualiza la vista
     */
    private void listarCalificaciones() {
        List<Calificacion> calificaciones = modelo.getCalificaciones();
        vista.actualizarTablaCalificaciones(calificaciones);
    }
    
    /**
     * Genera y muestra el reporte de promedios por alumno
     * Incluye información detallada de cada alumno y sus calificaciones
     */
    private void generarReportePromediosAlumnos() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== PROMEDIOS POR ALUMNO ===\n\n");
        
        for (Alumno alumno : modelo.getAlumnos()) {
            double promedio = modelo.calcularPromedioAlumno(alumno.getId());
            List<Calificacion> calificaciones = modelo.getCalificacionesAlumno(alumno.getId());
            
            reporte.append("Alumno: ").append(alumno.getNombre()).append(" ").append(alumno.getApellido()).append("\n");
            reporte.append("ID: ").append(alumno.getId()).append("\n");
            reporte.append("Promedio General: ").append(String.format("%.2f", promedio)).append("\n");
            reporte.append("Calificaciones:\n");
            
            for (Calificacion calif : calificaciones) {
                Materia materia = modelo.buscarMateria(calif.getCodigoMateria());
                String nombreMateria = materia != null ? materia.getNombre() : "Materia no encontrada";
                reporte.append("  - ").append(nombreMateria)
                      .append(": ").append(calif.getNota())
                      .append(" (Periodo ").append(calif.getPeriodo()).append(")\n");
            }
            reporte.append("\n");
        }
        
        vista.mostrarReporte(reporte.toString());
    }
    
    /**
     * Genera y muestra el reporte de promedios por materia
     * Incluye información de cada materia y las calificaciones individuales
     */
    private void generarReportePromediosMaterias() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== PROMEDIOS POR MATERIA ===\n\n");
        
        for (Materia materia : modelo.getMaterias()) {
            double promedio = modelo.calcularPromedioMateria(materia.getCodigo());
            
            reporte.append("Materia: ").append(materia.getNombre()).append("\n");
            reporte.append("Código: ").append(materia.getCodigo()).append("\n");
            reporte.append("Promedio General: ").append(String.format("%.2f", promedio)).append("\n");
            
            // Mostrar calificaciones individuales por materia
            List<Calificacion> califsMateria = modelo.getCalificaciones().stream()
                    .filter(c -> c.getCodigoMateria().equals(materia.getCodigo()))
                    .collect(Collectors.toList());
            
            if (!califsMateria.isEmpty()) {
                reporte.append("Calificaciones:\n");
                for (Calificacion calif : califsMateria) {
                    Alumno alumno = modelo.buscarAlumno(calif.getIdAlumno());
                    String nombreAlumno = alumno != null ? 
                        alumno.getNombre() + " " + alumno.getApellido() : "Alumno no encontrado";
                    reporte.append("  - ").append(nombreAlumno)
                          .append(": ").append(calif.getNota())
                          .append(" (Periodo ").append(calif.getPeriodo()).append(")\n");
                }
            }
            reporte.append("\n");
        }
        
        vista.mostrarReporte(reporte.toString());
    }
    
    /**
     * Actualiza los combobox de alumnos y materias en la vista
     * Se llama automáticamente después de agregar nuevos elementos al sistema
     */
    private void actualizarCombos() {
        // Actualizar combo de alumnos con IDs disponibles
        List<String> idsAlumnos = modelo.getAlumnos().stream()
                .map(Alumno::getId)
                .collect(Collectors.toList());
        vista.actualizarComboAlumnos(idsAlumnos);
        
        // Actualizar combo de materias con códigos disponibles
        List<String> codigosMaterias = modelo.getMaterias().stream()
                .map(Materia::getCodigo)
                .collect(Collectors.toList());
        vista.actualizarComboMaterias(codigosMaterias);
    }
}
    

