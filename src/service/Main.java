package service;

import view.PantallaPrincipal;

/**
 * Clase principal que inicia la aplicación de gestión hospitalaria.
 * Su función es inicializar la interfaz gráfica de inicio de sesión.
 * 
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class Main {

    /**
     * Método principal que ejecuta la aplicación.
     * Crea una instancia de la pantalla principal y la hace visible.
     * 
     */
    public static void main(String args[]) {
        PantallaPrincipal inicioSesion = new PantallaPrincipal();
        inicioSesion.setVisible(true);
    }
}