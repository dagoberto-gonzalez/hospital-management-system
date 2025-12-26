package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Doctor;
import model.Paciente;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Ventana para gestionar citas
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class CitaJframe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtIdCita, txtFecha, txtHora, txtMotivo;
    private JTextField txtIdEditar, txtIdBorrar;
    private JComboBox<String> cbDoctor, cbPaciente;

    File archivoCita = new File("docs/Citas.txt");
    List<Doctor> listaDoctores = new ArrayList<Doctor>();
    List<Paciente> listaPacientes = new ArrayList<Paciente>();

    // Método principal
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CitaJframe frame = new CitaJframe();
            frame.setVisible(true);
        });
    }

    // Constructor
    public CitaJframe() {
        try {
            // Crear archivo si no existe
            if (!archivoCita.exists()) {
                archivoCita.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear archivo de citas");
        }

        setTitle("Gestión de Citas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 720);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(211, 211, 211));
        panelTitulo.setBounds(0, 0, 986, 100);
        panelTitulo.setLayout(null);
        contentPane.add(panelTitulo);

        JLabel lblTitulo = new JLabel("GESTIÓN DE CITAS");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setBounds(321, 29, 400, 40);
        panelTitulo.add(lblTitulo);

        // Sección de datos de la cita
        JLabel lblDatos = new JLabel("Datos de la cita:");
        lblDatos.setFont(new Font("Arial", Font.BOLD, 20));
        lblDatos.setBounds(230, 120, 300, 30);
        contentPane.add(lblDatos);

        // Campo ID de cita
        JLabel lblIdCita = new JLabel("ID de la cita:");
        lblIdCita.setFont(new Font("Arial", Font.PLAIN, 16));
        lblIdCita.setBounds(230, 165, 150, 25);
        contentPane.add(lblIdCita);

        txtIdCita = new JTextField();
        txtIdCita.setBounds(230, 195, 200, 30);
        contentPane.add(txtIdCita);

        // Campo Fecha
        JLabel lblFecha = new JLabel("Fecha (dd/MM/yyyy):");
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 16));
        lblFecha.setBounds(460, 165, 200, 25);
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(460, 195, 200, 30);
        contentPane.add(txtFecha);

        // Campo Hora
        JLabel lblHora = new JLabel("Hora (HH:mm):");
        lblHora.setFont(new Font("Arial", Font.PLAIN, 16));
        lblHora.setBounds(230, 240, 150, 25);
        contentPane.add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(230, 270, 200, 30);
        contentPane.add(txtHora);

        // Campo Motivo
        JLabel lblMotivo = new JLabel("Motivo de la consulta:");
        lblMotivo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblMotivo.setBounds(460, 240, 200, 25);
        contentPane.add(lblMotivo);

        txtMotivo = new JTextField();
        txtMotivo.setBounds(460, 270, 300, 30);
        contentPane.add(txtMotivo);

        // Combo para seleccionar Doctor
        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setFont(new Font("Arial", Font.PLAIN, 16));
        lblDoctor.setBounds(230, 315, 150, 25);
        contentPane.add(lblDoctor);

        cbDoctor = new JComboBox<>();
        cbDoctor.setBounds(230, 345, 300, 30);
        contentPane.add(cbDoctor);

        // Combo para seleccionar Paciente
        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPaciente.setBounds(560, 315, 150, 25);
        contentPane.add(lblPaciente);

        cbPaciente = new JComboBox<>();
        cbPaciente.setBounds(560, 345, 300, 30);
        contentPane.add(cbPaciente);

        // Cargar datos en los combos
        cargarDoctores();
        llenarComboDoctor();
        cargarPacientes();
        llenarComboPaciente();

        // Línea separadora
        JSeparator separator = new JSeparator();
        separator.setBounds(213, 416, 771, 2);
        contentPane.add(separator);

        // Botón Guardar - color naranja
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 128, 64));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 16));
        btnGuardar.setBounds(700, 429, 150, 40);
        contentPane.add(btnGuardar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar campos vacíos
                if (txtIdCita.getText().isEmpty() || txtFecha.getText().isEmpty() ||
                    txtHora.getText().isEmpty() || txtMotivo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No deje campos vacíos");
                    return;
                }

                try {
                    // Validar formato de fecha
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = sdf.parse(txtFecha.getText());

                    // Obtener selecciones de los combos
                    String seleccionDoctor = (String) cbDoctor.getSelectedItem();
                    String seleccionPaciente = (String) cbPaciente.getSelectedItem();

                    // Validar selección de doctor
                    if (seleccionDoctor == null || seleccionDoctor.equals("No hay doctores")) {
                        JOptionPane.showMessageDialog(null, "Seleccione un doctor válido");
                        return;
                    }

                    // Validar selección de paciente
                    if (seleccionPaciente == null || seleccionPaciente.equals("No hay pacientes")) {
                        JOptionPane.showMessageDialog(null, "Seleccione un paciente válido");
                        return;
                    }

                    // Separar ID y nombre de doctor y paciente
                    String[] partsDoctor = seleccionDoctor.split(" - ");
                    String[] partsPaciente = seleccionPaciente.split(" - ");

                    // Guardar en archivo
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCita, true));
                    bw.write(txtIdCita.getText() + ";" + txtFecha.getText() + ";" + 
                             txtHora.getText() + ";" + txtMotivo.getText() + ";" + 
                             partsDoctor[0] + ";" + partsDoctor[1] + ";" + 
                             partsPaciente[0] + ";" + partsPaciente[1]);
                    bw.newLine();
                    bw.close();

                    JOptionPane.showMessageDialog(null, "Cita guardada correctamente");
                    limpiarCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Sección para editar
        JLabel lblEditar = new JLabel("ID a editar:");
        lblEditar.setFont(new Font("Arial", Font.PLAIN, 14));
        lblEditar.setBounds(230, 505, 100, 25);
        contentPane.add(lblEditar);

        txtIdEditar = new JTextField();
        txtIdEditar.setBounds(330, 505, 150, 30);
        contentPane.add(txtIdEditar);

        // Botón Editar - color azul
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBackground(new Color(52, 152, 219));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEditar.setBounds(700, 480, 150, 40);
        contentPane.add(btnEditar);

        // Acción del botón Editar
        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBuscar = txtIdEditar.getText();
                if (idBuscar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un ID a editar");
                    return;
                }

                String nuevoContenido = "";
                boolean encontrado = false;

                try {
                    // Obtener selecciones actuales
                    String seleccionDoctor = (String) cbDoctor.getSelectedItem();
                    String seleccionPaciente = (String) cbPaciente.getSelectedItem();
                    
                    // Separar ID y nombre
                    String[] partsDoctor = seleccionDoctor.split(" - ");
                    String[] partsPaciente = seleccionPaciente.split(" - ");

                    // Leer archivo y buscar la cita
                    BufferedReader br = new BufferedReader(new FileReader(archivoCita));
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        if (linea.startsWith(idBuscar + ";")) {
                            // Reemplazar con nuevos datos
                            nuevoContenido += txtIdCita.getText() + ";" + txtFecha.getText() + ";" + 
                                             txtHora.getText() + ";" + txtMotivo.getText() + ";" + 
                                             partsDoctor[0] + ";" + partsDoctor[1] + ";" + 
                                             partsPaciente[0] + ";" + partsPaciente[1] + "\n";
                            encontrado = true;
                        } else {
                            nuevoContenido += linea + "\n";
                        }
                    }
                    br.close();

                    // Escribir archivo actualizado
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCita));
                    bw.write(nuevoContenido);
                    bw.close();

                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, "Cita editada correctamente");
                        limpiarCampos();
                        txtIdEditar.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al editar cita: " + ex.getMessage());
                }
            }
        });

        // Sección para borrar
        JLabel lblBorrar = new JLabel("ID a borrar:");
        lblBorrar.setFont(new Font("Arial", Font.PLAIN, 14));
        lblBorrar.setBounds(230, 555, 100, 25);
        contentPane.add(lblBorrar);

        txtIdBorrar = new JTextField();
        txtIdBorrar.setBounds(330, 555, 150, 30);
        contentPane.add(txtIdBorrar);

        // Botón Borrar - color rojo
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBackground(new Color(231, 76, 60));
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnBorrar.setBounds(700, 531, 150, 40);
        contentPane.add(btnBorrar);

        // Acción del botón Borrar
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idBorrar = txtIdBorrar.getText();
                if (idBorrar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un ID");
                    return;
                }

                String nuevoContenido = "";
                boolean eliminado = false;

                try {
                    // Leer archivo y eliminar la cita
                    BufferedReader br = new BufferedReader(new FileReader(archivoCita));
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        if (!linea.startsWith(idBorrar + ";")) {
                            nuevoContenido += linea + "\n";
                        } else {
                            eliminado = true;
                        }
                    }
                    br.close();

                    // Escribir archivo sin la cita eliminada
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCita));
                    bw.write(nuevoContenido);
                    bw.close();

                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Cita eliminada correctamente");
                        txtIdBorrar.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al borrar cita");
                }
            }
        });

        // Botón Mostrar - color gris
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBackground(new Color(149, 165, 166));
        btnMostrar.setForeground(Color.WHITE);
        btnMostrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnMostrar.setBounds(700, 582, 150, 40);
        contentPane.add(btnMostrar);

        // Acción del botón Mostrar
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Leer todas las citas del archivo
                    BufferedReader br = new BufferedReader(new FileReader(archivoCita));
                    String linea;
                    String resultado = "";

                    while ((linea = br.readLine()) != null) {
                        String[] citaMostrar = linea.split(";");
                        if (citaMostrar.length >= 8) {
                            resultado += "ID: " + citaMostrar[0] + "\n" +
                                        "Fecha: " + citaMostrar[1] + "\n" +
                                        "Hora: " + citaMostrar[2] + "\n" +
                                        "Motivo: " + citaMostrar[3] + "\n" +
                                        "Doctor: " + citaMostrar[4] + " - " + citaMostrar[5] + "\n" +
                                        "Paciente: " + citaMostrar[6] + " - " + citaMostrar[7] + "\n" +
                                        "---------------------------\n";
                        }
                    }
                    br.close();

                    if (resultado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay citas registradas");
                    } else {
                        JOptionPane.showMessageDialog(null, resultado);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al mostrar citas");
                }
            }
        });

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
        btnVolver.setBounds(825, 111, 135, 39);
        contentPane.add(btnVolver);
        
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });

        // Botón Cerrar sesión
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCerrarSesion.setBounds(825, 155, 135, 40);
        contentPane.add(btnCerrarSesion);
        
        // Imagen de fondo
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(CitaJframe.class.getResource("/imagenes/imagen citas.jpg")));
        lblNewLabel.setBounds(-18, 92, 235, 589);
        contentPane.add(lblNewLabel);
        
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
    }

    // Cargar doctores desde archivo
    void cargarDoctores() {
        try {
            File archivoDoctores = new File("docs/Doctores.txt");
            if (!archivoDoctores.exists()) {
                archivoDoctores.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(archivoDoctores));
            String linea;
            listaDoctores.clear();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 6) {
                    Doctor doctor = new Doctor();
                    doctor.setId(datos[0]);
                    doctor.setNombre(datos[1]);
                    try {
                        doctor.setEdad(Integer.parseInt(datos[2]));
                    } catch (NumberFormatException e) {
                        doctor.setEdad(0);
                    }
                    doctor.setEspecialidad(datos[3]);
                    try {
                        doctor.setAñosExperiencia(Integer.parseInt(datos[4]));
                    } catch (NumberFormatException e) {
                        doctor.setAñosExperiencia(0);
                    }
                    doctor.setCodigoMedico(datos[5]);
                    if (datos.length >= 7) {
                        doctor.setHorarioAtencion(datos[6]);
                    }
                    listaDoctores.add(doctor);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Llenar combo de doctores
    void llenarComboDoctor() {
        cbDoctor.removeAllItems();
        if (listaDoctores.isEmpty()) {
            cbDoctor.addItem("No hay doctores");
        } else {
            for (Doctor d : listaDoctores) {
                cbDoctor.addItem(d.getId() + " - " + d.getNombre());
            }
        }
    }

    // Cargar pacientes desde archivo
    void cargarPacientes() {
        try {
            File archivoPacientes = new File("docs/Pacientes.txt");
            if (!archivoPacientes.exists()) {
                archivoPacientes.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(archivoPacientes));
            String linea;
            listaPacientes.clear();

            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    String[] datos = linea.split(";");
                    if (datos.length >= 8) {
                        Paciente paciente = new Paciente();
                        paciente.setId(datos[0]);
                        paciente.setNombre(datos[1]);
                        try {
                            paciente.setEdad(Integer.parseInt(datos[2]));
                        } catch (NumberFormatException e) {
                            paciente.setEdad(0);
                        }
                        paciente.setTipoSangre(datos[3]);
                        paciente.setPadecimiento(datos[4]);
                        paciente.setAlergias(datos[5]);
                        try {
                            paciente.setPeso(Double.parseDouble(datos[6]));
                        } catch (NumberFormatException e) {
                            paciente.setPeso(0.0);
                        }
                        try {
                            paciente.setAltura(Double.parseDouble(datos[7]));
                        } catch (NumberFormatException e) {
                            paciente.setAltura(0.0);
                        }
                        listaPacientes.add(paciente);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Llenar combo de pacientes
    void llenarComboPaciente() {
        cbPaciente.removeAllItems();
        if (listaPacientes.isEmpty()) {
            cbPaciente.addItem("No hay pacientes");
        } else {
            for (Paciente p : listaPacientes) {
                cbPaciente.addItem(p.getId() + " - " + p.getNombre());
            }
        }
    }

    // Limpiar campos de texto
    void limpiarCampos() {
        txtIdCita.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtMotivo.setText("");
    }

    // Regresar al menú principal
    void volver() {
        MenuPrincipal menuP = new MenuPrincipal();
        menuP.setVisible(true);
        setVisible(false);
    }

    // Cerrar sesión y regresar a pantalla de inicio
    void cerrarSesion() {
        PantallaPrincipal pantallaP = new PantallaPrincipal();
        pantallaP.setVisible(true);
        setVisible(false);
    }
}