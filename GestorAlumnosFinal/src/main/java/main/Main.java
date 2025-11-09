/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.Controlador;
import javax.swing.SwingUtilities;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author franko
 */
public class Main {
/**
 * Clase principal que inicia la aplicación y coordina el patrón MVC
 * Punto de entrada del sistema de gestión de notas
 * 
 * @author Sistema de Gestión de Notas
 * @version 1.0
 */
    /**
     * Método principal - entry point de la aplicación
     * Inicializa los componentes MVC y lanza la interfaz gráfica
     * 
     * @param args Argumentos de línea de comandos (no utilizados en esta aplicación)
     */
    public static void main(String[] args) {
        // Ejecutar en el Event Dispatch Thread de Swing para garantizar
        // la correcta ejecución de la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear e inicializar los tres componentes del patrón MVC
                Modelo modelo = new Modelo();
                Vista vista = new Vista();
                Controlador controlador = new Controlador(modelo, vista);
                
                // Hacer visible la ventana principal de la aplicación
                vista.setVisible(true);
            }
        });
    }
}    

