/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Calificacion;
import modelo.Materia;

/**
 *
 * @author franko
 */
    
    /**
 * Clase principal de la interfaz gráfica de usuario
 * Implementa la vista usando Swing y gestiona todos los componentes visuales
 * Sigue el patrón MVC como capa de presentación
 */
public class Vista extends JFrame {
    private JTabbedPane tabbedPane;
    
    // COMPONENTES PARA ALUMNOS
    private JPanel panelAlumnos;
    private JTextField txtIdAlumno, txtNombreAlumno, txtApellidoAlumno, txtEdadAlumno;
    private JButton btnAgregarAlumno, btnListarAlumnos;
    private JTable tablaAlumnos;
    private DefaultTableModel modeloTablaAlumnos;
    
    // COMPONENTES PARA MATERIAS
    private JPanel panelMaterias;
    private JTextField txtCodigoMateria, txtNombreMateria, txtDescripcionMateria;
    private JButton btnAgregarMateria, btnListarMaterias;
    private JTable tablaMaterias;
    private DefaultTableModel modeloTablaMaterias;
    
    // COMPONENTES PARA CALIFICACIONES
    private JPanel panelCalificaciones;
    private JComboBox<String> comboAlumnos, comboMaterias;
    private JTextField txtNota, txtPeriodo;
    private JButton btnAgregarCalificacion, btnListarCalificaciones;
    private JTable tablaCalificaciones;
    private DefaultTableModel modeloTablaCalificaciones;
    
    // COMPONENTES PARA REPORTES
    private JPanel panelReportes;
    private JButton btnPromedioAlumno, btnPromedioMateria;
    private JTextArea areaReportes;
    
    /**
     * Constructor principal de la vista
     * Inicializa todos los componentes de la interfaz
     */
    public Vista() {
        inicializarVista();
    }
    
    /**
     * Configuración inicial de la ventana principal
     * Establece título, tamaño, posición y crea los paneles
     */
    private void inicializarVista() {
        setTitle("Sistema de Gestión de Notas de Alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        tabbedPane = new JTabbedPane();
        
        crearPanelAlumnos();
        crearPanelMaterias();
        crearPanelCalificaciones();
        crearPanelReportes();
        
        add(tabbedPane);
    }
    
    /**
     * Crea y configura el panel de gestión de alumnos
     * Incluye campos de entrada, botones y tabla de visualización
     */
    private void crearPanelAlumnos() {
        panelAlumnos = new JPanel(new BorderLayout());
        
        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(5, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("ID Alumno:"));
        txtIdAlumno = new JTextField();
        panelEntrada.add(txtIdAlumno);
        
        panelEntrada.add(new JLabel("Nombre:"));
        txtNombreAlumno = new JTextField();
        panelEntrada.add(txtNombreAlumno);
        
        panelEntrada.add(new JLabel("Apellido:"));
        txtApellidoAlumno = new JTextField();
        panelEntrada.add(txtApellidoAlumno);
        
        panelEntrada.add(new JLabel("Edad:"));
        txtEdadAlumno = new JTextField();
        panelEntrada.add(txtEdadAlumno);
        
        // Panel de botones
        btnAgregarAlumno = new JButton("Agregar Alumno");
        btnListarAlumnos = new JButton("Listar Alumnos");
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAgregarAlumno);
        panelBotones.add(btnListarAlumnos);
        
        panelEntrada.add(new JLabel()); // Espacio vacío
        panelEntrada.add(panelBotones);
        
        panelAlumnos.add(panelEntrada, BorderLayout.NORTH);
        
        // Configuración de la tabla
        String[] columnasAlumnos = {"ID", "Nombre", "Apellido", "Edad"};
        modeloTablaAlumnos = new DefaultTableModel(columnasAlumnos, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        tablaAlumnos = new JTable(modeloTablaAlumnos);
        tablaAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        panelAlumnos.add(new JScrollPane(tablaAlumnos), BorderLayout.CENTER);
        
        tabbedPane.addTab("Alumnos", panelAlumnos);
    }
    
    /**
     * Crea y configura el panel de gestión de materias
     * Incluye campos de entrada, botones y tabla de visualización
     */
    private void crearPanelMaterias() {
        panelMaterias = new JPanel(new BorderLayout());
        
        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("Código Materia:"));
        txtCodigoMateria = new JTextField();
        panelEntrada.add(txtCodigoMateria);
        
        panelEntrada.add(new JLabel("Nombre:"));
        txtNombreMateria = new JTextField();
        panelEntrada.add(txtNombreMateria);
        
        panelEntrada.add(new JLabel("Descripción:"));
        txtDescripcionMateria = new JTextField();
        panelEntrada.add(txtDescripcionMateria);
        
        // Panel de botones
        btnAgregarMateria = new JButton("Agregar Materia");
        btnListarMaterias = new JButton("Listar Materias");
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAgregarMateria);
        panelBotones.add(btnListarMaterias);
        
        panelEntrada.add(new JLabel()); // Espacio vacío
        panelEntrada.add(panelBotones);
        
        panelMaterias.add(panelEntrada, BorderLayout.NORTH);
        
        // Configuración de la tabla
        String[] columnasMaterias = {"Código", "Nombre", "Descripción"};
        modeloTablaMaterias = new DefaultTableModel(columnasMaterias, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaMaterias = new JTable(modeloTablaMaterias);
        tablaMaterias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        panelMaterias.add(new JScrollPane(tablaMaterias), BorderLayout.CENTER);
        
        tabbedPane.addTab("Materias", panelMaterias);
    }
    
    /**
     * Crea y configura el panel de gestión de calificaciones
     * Incluye combos de selección, campos de entrada y tabla
     */
    private void crearPanelCalificaciones() {
        panelCalificaciones = new JPanel(new BorderLayout());
        
        // Panel de entrada de datos
        JPanel panelEntrada = new JPanel(new GridLayout(5, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelEntrada.add(new JLabel("Alumno:"));
        comboAlumnos = new JComboBox<>();
        comboAlumnos.addItem("Seleccione un alumno");
        panelEntrada.add(comboAlumnos);
        
        panelEntrada.add(new JLabel("Materia:"));
        comboMaterias = new JComboBox<>();
        comboMaterias.addItem("Seleccione una materia");
        panelEntrada.add(comboMaterias);
        
        panelEntrada.add(new JLabel("Nota (0-10):"));
        txtNota = new JTextField();
        panelEntrada.add(txtNota);
        
        panelEntrada.add(new JLabel("Periodo:"));
        txtPeriodo = new JTextField();
        panelEntrada.add(txtPeriodo);
        
        // Panel de botones
        btnAgregarCalificacion = new JButton("Agregar Calificación");
        btnListarCalificaciones = new JButton("Listar Calificaciones");
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAgregarCalificacion);
        panelBotones.add(btnListarCalificaciones);
        
        panelEntrada.add(new JLabel()); // Espacio vacío
        panelEntrada.add(panelBotones);
        
        panelCalificaciones.add(panelEntrada, BorderLayout.NORTH);
        
        // Configuración de la tabla
        String[] columnasCalificaciones = {"ID Alumno", "Código Materia", "Nota", "Periodo"};
        modeloTablaCalificaciones = new DefaultTableModel(columnasCalificaciones, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaCalificaciones = new JTable(modeloTablaCalificaciones);
        tablaCalificaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        panelCalificaciones.add(new JScrollPane(tablaCalificaciones), BorderLayout.CENTER);
        
        tabbedPane.addTab("Calificaciones", panelCalificaciones);
    }
    
    /**
     * Crea y configura el panel de generación de reportes
     * Incluye botones para diferentes reportes y área de visualización
     */
    private void crearPanelReportes() {
        panelReportes = new JPanel(new BorderLayout());
        
        // Panel de botones
        btnPromedioAlumno = new JButton("Promedio por Alumno");
        btnPromedioMateria = new JButton("Promedio por Materia");
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnPromedioAlumno);
        panelBotones.add(btnPromedioMateria);
        
        // Área de reportes
        areaReportes = new JTextArea();
        areaReportes.setEditable(false);
        areaReportes.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        panelReportes.add(panelBotones, BorderLayout.NORTH);
        panelReportes.add(new JScrollPane(areaReportes), BorderLayout.CENTER);
        
        tabbedPane.addTab("Reportes", panelReportes);
    }
    
    // MÉTODOS PARA OBTENER DATOS DE LA INTERFAZ
    
    /**
     * @return Texto ingresado en el campo ID Alumno
     */
    public String getIdAlumno() { return txtIdAlumno.getText().trim(); }
    
    /**
     * @return Texto ingresado en el campo Nombre Alumno
     */
    public String getNombreAlumno() { return txtNombreAlumno.getText().trim(); }
    
    /**
     * @return Texto ingresado en el campo Apellido Alumno
     */
    public String getApellidoAlumno() { return txtApellidoAlumno.getText().trim(); }
    
    /**
     * Obtiene y parsea la edad del alumno
     * @return Edad como entero, 0 si hay error de formato
     */
    public int getEdadAlumno() { 
        try {
            return Integer.parseInt(txtEdadAlumno.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    /**
     * @return Texto ingresado en el campo Código Materia
     */
    public String getCodigoMateria() { return txtCodigoMateria.getText().trim(); }
    
    /**
     * @return Texto ingresado en el campo Nombre Materia
     */
    public String getNombreMateria() { return txtNombreMateria.getText().trim(); }
    
    /**
     * @return Texto ingresado en el campo Descripción Materia
     */
    public String getDescripcionMateria() { return txtDescripcionMateria.getText().trim(); }
    
    /**
     * @return Alumno seleccionado en el combo box
     */
    public String getAlumnoSeleccionado() { 
        String seleccionado = (String) comboAlumnos.getSelectedItem();
        return "Seleccione un alumno".equals(seleccionado) ? null : seleccionado;
    }
    
    /**
     * @return Materia seleccionada en el combo box
     */
    public String getMateriaSeleccionada() { 
        String seleccionado = (String) comboMaterias.getSelectedItem();
        return "Seleccione una materia".equals(seleccionado) ? null : seleccionado;
    }
    
    /**
     * Obtiene y parsea la nota ingresada
     * @return Nota como double, 0.0 si hay error de formato
     */
    public double getNota() { 
        try {
            return Double.parseDouble(txtNota.getText().trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    /**
     * Obtiene y parsea el período ingresado
     * @return Periodo como entero, 0 si hay error de formato
     */
    public int getPeriodo() { 
        try {
            return Integer.parseInt(txtPeriodo.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    // MÉTODOS PARA LIMPIAR CAMPOS
    
    /**
     * Limpia todos los campos del formulario de alumnos
     */
    public void limpiarCamposAlumno() {
        txtIdAlumno.setText("");
        txtNombreAlumno.setText("");
        txtApellidoAlumno.setText("");
        txtEdadAlumno.setText("");
    }
    
    /**
     * Limpia todos los campos del formulario de materias
     */
    public void limpiarCamposMateria() {
        txtCodigoMateria.setText("");
        txtNombreMateria.setText("");
        txtDescripcionMateria.setText("");
    }
    
    /**
     * Limpia todos los campos del formulario de calificaciones
     */
    public void limpiarCamposCalificacion() {
        txtNota.setText("");
        txtPeriodo.setText("");
    }
    
    // MÉTODOS PARA ACTUALIZAR COMPONENTES
    
    /**
     * Actualiza el combo box de alumnos con los IDs disponibles
     * @param idsAlumnos Lista de IDs de alumnos a mostrar
     */
    public void actualizarComboAlumnos(List<String> idsAlumnos) {
        String seleccionActual = (String) comboAlumnos.getSelectedItem();
        comboAlumnos.removeAllItems();
        comboAlumnos.addItem("Seleccione un alumno");
        for (String id : idsAlumnos) {
            comboAlumnos.addItem(id);
        }
        // Restaurar selección si aún existe
        if (idsAlumnos.contains(seleccionActual)) {
            comboAlumnos.setSelectedItem(seleccionActual);
        }
    }
    
    /**
     * Actualiza el combo box de materias con los códigos disponibles
     * @param codigosMaterias Lista de códigos de materias a mostrar
     */
    public void actualizarComboMaterias(List<String> codigosMaterias) {
        String seleccionActual = (String) comboMaterias.getSelectedItem();
        comboMaterias.removeAllItems();
        comboMaterias.addItem("Seleccione una materia");
        for (String codigo : codigosMaterias) {
            comboMaterias.addItem(codigo);
        }
        // Restaurar selección si aún existe
        if (codigosMaterias.contains(seleccionActual)) {
            comboMaterias.setSelectedItem(seleccionActual);
        }
    }
    
    /**
     * Actualiza la tabla de alumnos con la lista proporcionada
     * @param alumnos Lista de objetos Alumno a mostrar
     */
    public void actualizarTablaAlumnos(List<Alumno> alumnos) {
        modeloTablaAlumnos.setRowCount(0);
        for (Alumno alumno : alumnos) {
            Object[] fila = {
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEdad()
            };
            modeloTablaAlumnos.addRow(fila);
        }
    }
    
    /**
     * Actualiza la tabla de materias con la lista proporcionada
     * @param materias Lista de objetos Materia a mostrar
     */
    public void actualizarTablaMaterias(List<Materia> materias) {
        modeloTablaMaterias.setRowCount(0);
        for (Materia materia : materias) {
            Object[] fila = {
                materia.getCodigo(),
                materia.getNombre(),
                materia.getDescripcion()
            };
            modeloTablaMaterias.addRow(fila);
        }
    }
    
    /**
     * Actualiza la tabla de calificaciones con la lista proporcionada
     * @param calificaciones Lista de objetos Calificacion a mostrar
     */
    public void actualizarTablaCalificaciones(List<Calificacion> calificaciones) {
        modeloTablaCalificaciones.setRowCount(0);
        for (Calificacion calificacion : calificaciones) {
            Object[] fila = {
                calificacion.getIdAlumno(),
                calificacion.getCodigoMateria(),
                calificacion.getNota(),
                calificacion.getPeriodo()
            };
            modeloTablaCalificaciones.addRow(fila);
        }
    }
    
    /**
     * Muestra un reporte en el área de texto de reportes
     * @param reporte String con el contenido del reporte a mostrar
     */
    public void mostrarReporte(String reporte) {
        areaReportes.setText(reporte);
        areaReportes.setCaretPosition(0); // Scroll al inicio
    }
    
    // MÉTODOS PARA AGREGAR LISTENERS
    
    /**
     * Agrega un ActionListener al botón Agregar Alumno
     * @param listener ActionListener a agregar
     */
    public void agregarListenerAgregarAlumno(ActionListener listener) {
        btnAgregarAlumno.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al botón Listar Alumnos
     * @param listener ActionListener a agregar
     */
    public void agregarListenerListarAlumnos(ActionListener listener) {
        btnListarAlumnos.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al botón Agregar Materia
     * @param listener ActionListener a agregar
     */
    public void agregarListenerAgregarMateria(ActionListener listener) {
        btnAgregarMateria.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al botón Listar Materias
     * @param listener ActionListener a agregar
     */
    public void agregarListenerListarMaterias(ActionListener listener) {
        btnListarMaterias.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al botón Agregar Calificación
     * @param listener ActionListener a agregar
     */
    public void agregarListenerAgregarCalificacion(ActionListener listener) {
        btnAgregarCalificacion.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al botón Listar Calificaciones
     * @param listener ActionListener a agregar
     */
    public void agregarListenerListarCalificaciones(ActionListener listener) {
        btnListarCalificaciones.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al botón Promedio por Alumno
     * @param listener ActionListener a agregar
     */
    public void agregarListenerPromedioAlumno(ActionListener listener) {
        btnPromedioAlumno.addActionListener(listener);
    }
    
    /**
     * Agrega un ActionListener al botón Promedio por Materia
     * @param listener ActionListener a agregar
     */
    public void agregarListenerPromedioMateria(ActionListener listener) {
        btnPromedioMateria.addActionListener(listener);
    }
    
    // MÉTODOS PARA MOSTRAR MENSAJES
    
    /**
     * Muestra un mensaje de información al usuario
     * @param mensaje Texto del mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Muestra un mensaje de error al usuario
     * @param mensaje Texto del mensaje de error
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    

