package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

/**
 * Ventana del menú principal del sistema hospitalario
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class MenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    // Método principal - inicia la aplicación
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MenuPrincipal frame = new MenuPrincipal();
            frame.setVisible(true);
        });
    }

    // Constructor - configura la interfaz del menú
    public MenuPrincipal() {
        setTitle("Menú Principal - Sistema Médico");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);

        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBounds(0, 0, 886, 100);
        panelTitulo.setBackground(new Color(52, 152, 219)); // Azul
        panelTitulo.setLayout(null);
        getContentPane().add(panelTitulo);

        JLabel lblTitulo = new JLabel("MENÚ PRINCIPAL");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(280, 30, 350, 40);
        panelTitulo.add(lblTitulo);

        // Panel lateral izquierdo
        JPanel panelLateral = new JPanel();
        panelLateral.setBounds(0, 100, 200, 573);
        panelLateral.setBackground(new Color(41, 128, 185));
        panelLateral.setLayout(null);
        getContentPane().add(panelLateral);
        
        // Imagen en panel lateral
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(0, 0, 267, 562);
        panelLateral.add(lblNewLabel_2);
        lblNewLabel_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/pasillo.png")));

        // Botón para gestionar pacientes
        JButton btnPacientes = new JButton("PACIENTES");
        btnPacientes.setBounds(280, 200, 220, 60);
        btnPacientes.setFont(new Font("Arial", Font.BOLD, 18));
        btnPacientes.setBackground(new Color(46, 204, 113)); // Verde
        btnPacientes.setForeground(Color.WHITE);
        btnPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana de pacientes
                PacienteJframe pacienteJframe = new PacienteJframe();
                pacienteJframe.setVisible(true);
                setVisible(false);
            }
        });
        getContentPane().add(btnPacientes);

        // Botón para gestionar doctores
        JButton btnDoctores = new JButton("DOCTORES");
        btnDoctores.setBounds(560, 200, 220, 60);
        btnDoctores.setFont(new Font("Arial", Font.BOLD, 18));
        btnDoctores.setBackground(new Color(155, 89, 182)); // Morado
        btnDoctores.setForeground(Color.WHITE);
        btnDoctores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana de doctores
                DoctorJframe doctorJframe = new DoctorJframe();
                doctorJframe.setVisible(true);
                setVisible(false);
            }
        });
        getContentPane().add(btnDoctores);

        // Botón para gestionar citas
        JButton btnCitas = new JButton("CITAS");
        btnCitas.setBounds(280, 358, 220, 60);
        btnCitas.setFont(new Font("Arial", Font.BOLD, 18));
        btnCitas.setForeground(Color.WHITE);
        btnCitas.setBackground(new Color(52, 152, 219)); // Azul
        btnCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana de citas
                CitaJframe citaJframe = new CitaJframe();
                citaJframe.setVisible(true);
                setVisible(false);
            }
        });
        getContentPane().add(btnCitas);

        // Botón para gestionar tratamientos
        JButton btnTratamientos = new JButton("TRATAMIENTOS");
        btnTratamientos.setBounds(560, 358, 220, 60);
        btnTratamientos.setFont(new Font("Arial", Font.BOLD, 18));
        btnTratamientos.setForeground(Color.WHITE);
        btnTratamientos.setBackground(new Color(230, 126, 34)); // Naranja
        btnTratamientos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana de tratamientos
                TratamientoJframe tratamientoJframe = new TratamientoJframe();
                tratamientoJframe.setVisible(true);
                setVisible(false);
            }
        });
        getContentPane().add(btnTratamientos);

        // Botón para cerrar sesión
        JButton btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBounds(720, 610, 140, 35);
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCerrarSesion.setBackground(new Color(231, 76, 60)); // Rojo
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
        getContentPane().add(btnCerrarSesion);
        
        // Iconos para cada opción del menú
        
        // Icono para tratamientos
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/tratamiento foto.png")));
        lblNewLabel.setBounds(625, 429, 118, 80);
        getContentPane().add(lblNewLabel);
        
        // Icono para citas
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/cita foto.png")));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(353, 420, 89, 80);
        getContentPane().add(lblNewLabel_1);
        
        // Icono para pacientes
        JLabel lblNewLabel_1_1 = new JLabel("New label");
        lblNewLabel_1_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/paciente imagen.png")));
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setBounds(353, 267, 89, 80);
        getContentPane().add(lblNewLabel_1_1);
        
        // Icono para doctores
        JLabel lblNewLabel_1_1_1 = new JLabel("New label");
        lblNewLabel_1_1_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/doctor foto.png")));
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setBounds(629, 267, 89, 80);
        getContentPane().add(lblNewLabel_1_1_1);
    }

    // Método para cerrar sesión y regresar a la pantalla de inicio
    void cerrarSesion() {
        PantallaPrincipal pantallaP = new PantallaPrincipal();
        pantallaP.setVisible(true);
        setVisible(false);
    }
}