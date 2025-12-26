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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Ventana para gestionar tratamientos médicos
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class TratamientoJframe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId, txtMedicamento, txtDosis, txtDuracion, txtInstrucciones;
    private JTextField txtIdEditar, txtIdBorrar;
    private JComboBox<String> cbDoctor, cbPaciente;

    File archivoTratamientos = new File("docs/Tratamientos.txt");
    List<Doctor> listaDoctores = new ArrayList<Doctor>();
    List<Paciente> listaPacientes = new ArrayList<Paciente>();

    // Método principal - inicia la ventana
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TratamientoJframe frame = new TratamientoJframe();
            frame.setVisible(true);
        });
    }

    // Constructor - configura la interfaz gráfica
    public TratamientoJframe() {
        // Crear archivo si no existe
        try {
            if (!archivoTratamientos.exists()) {
                archivoTratamientos.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear archivo");
        }

        setTitle("Gestión de Tratamientos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 720);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(102, 205, 170));
        panelTitulo.setBounds(0, 0, 986, 100);
        panelTitulo.setLayout(null);
        contentPane.add(panelTitulo);

        JLabel lblTitulo = new JLabel("GESTIÓN DE TRATAMIENTOS");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setBounds(250, 30, 500, 40);
        panelTitulo.add(lblTitulo);

        // Sección de datos del tratamiento
        JLabel lblDatos = new JLabel("Datos del tratamiento:");
        lblDatos.setFont(new Font("Arial", Font.BOLD, 20));
        lblDatos.setBounds(230, 120, 300, 30);
        contentPane.add(lblDatos);

        // Campo ID
        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Arial", Font.PLAIN, 16));
        lblId.setBounds(230, 165, 100, 25);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(230, 195, 200, 30);
        contentPane.add(txtId);

        // Campo Medicamento
        JLabel lblMedicamento = new JLabel("Medicamento:");
        lblMedicamento.setFont(new Font("Arial", Font.PLAIN, 16));
        lblMedicamento.setBounds(460, 165, 200, 25);
        contentPane.add(lblMedicamento);

        txtMedicamento = new JTextField();
        txtMedicamento.setBounds(460, 195, 300, 30);
        contentPane.add(txtMedicamento);

        // Campo Dosis
        JLabel lblDosis = new JLabel("Dosis:");
        lblDosis.setFont(new Font("Arial", Font.PLAIN, 16));
        lblDosis.setBounds(230, 240, 150, 25);
        contentPane.add(lblDosis);

        txtDosis = new JTextField();
        txtDosis.setBounds(230, 270, 200, 30);
        contentPane.add(txtDosis);

        // Campo Duración
        JLabel lblDuracion = new JLabel("Duración:");
        lblDuracion.setFont(new Font("Arial", Font.PLAIN, 16));
        lblDuracion.setBounds(460, 240, 150, 25);
        contentPane.add(lblDuracion);

        txtDuracion = new JTextField();
        txtDuracion.setBounds(460, 270, 200, 30);
        contentPane.add(txtDuracion);

        // Campo Instrucciones
        JLabel lblInstrucciones = new JLabel("Instrucciones:");
        lblInstrucciones.setFont(new Font("Arial", Font.PLAIN, 16));
        lblInstrucciones.setBounds(230, 315, 200, 25);
        contentPane.add(lblInstrucciones);

        txtInstrucciones = new JTextField();
        txtInstrucciones.setBounds(230, 345, 530, 30);
        contentPane.add(txtInstrucciones);

        // Combo para seleccionar Doctor
        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setFont(new Font("Arial", Font.PLAIN, 16));
        lblDoctor.setBounds(230, 390, 150, 25);
        contentPane.add(lblDoctor);

        cbDoctor = new JComboBox<>();
        cbDoctor.setBounds(230, 420, 300, 30);
        contentPane.add(cbDoctor);

        // Combo para seleccionar Paciente
        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPaciente.setBounds(560, 390, 150, 25);
        contentPane.add(lblPaciente);

        cbPaciente = new JComboBox<>();
        cbPaciente.setBounds(560, 420, 300, 30);
        contentPane.add(cbPaciente);

        // Cargar datos en los combos
        cargarDoctores();
        llenarComboDoctor();
        cargarPacientes();
        llenarComboPaciente();

        // Línea separadora
        JSeparator separator = new JSeparator();
        separator.setBounds(198, 461, 786, 2);
        contentPane.add(separator);

        // Botón Guardar - color naranja
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 128, 64));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 16));
        btnGuardar.setBounds(700, 474, 150, 40);
        contentPane.add(btnGuardar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar campos vacíos
                if (txtId.getText().isEmpty() || txtMedicamento.getText().isEmpty() ||
                    txtDosis.getText().isEmpty() || txtDuracion.getText().isEmpty() ||
                    txtInstrucciones.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No deje campos vacíos");
                    return;
                }

                try {
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
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTratamientos, true));
                    bw.write(txtId.getText() + ";" + txtMedicamento.getText() + ";" + 
                             txtDosis.getText() + ";" + txtDuracion.getText() + ";" + 
                             txtInstrucciones.getText() + ";" + partsDoctor[0] + ";" + 
                             partsDoctor[1] + ";" + partsPaciente[0] + ";" + partsPaciente[1]);
                    bw.newLine();
                    bw.close();

                    JOptionPane.showMessageDialog(null, "Tratamiento guardado");
                    limpiarCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            }
        });

        // Sección para editar
        JLabel lblEditar = new JLabel("ID a editar:");
        lblEditar.setFont(new Font("Arial", Font.PLAIN, 14));
        lblEditar.setBounds(230, 550, 100, 25);
        contentPane.add(lblEditar);

        txtIdEditar = new JTextField();
        txtIdEditar.setBounds(330, 550, 150, 30);
        contentPane.add(txtIdEditar);

        // Botón Editar - color azul
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBackground(new Color(52, 152, 219));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEditar.setBounds(700, 525, 150, 40);
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
                    // Leer archivo y buscar el tratamiento
                    BufferedReader br = new BufferedReader(new FileReader(archivoTratamientos));
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        if (linea.startsWith(idBuscar + ";")) {
                            // Obtener selecciones actuales
                            String seleccionDoctor = (String) cbDoctor.getSelectedItem();
                            String seleccionPaciente = (String) cbPaciente.getSelectedItem();
                            
                            // Separar ID y nombre
                            String[] partsDoctor = seleccionDoctor.split(" - ");
                            String[] partsPaciente = seleccionPaciente.split(" - ");
                            
                            // Reemplazar con nuevos datos
                            nuevoContenido += txtId.getText() + ";" + txtMedicamento.getText() + ";" + 
                                             txtDosis.getText() + ";" + txtDuracion.getText() + ";" + 
                                             txtInstrucciones.getText() + ";" + partsDoctor[0] + ";" + 
                                             partsDoctor[1] + ";" + partsPaciente[0] + ";" + partsPaciente[1] + "\n";
                            encontrado = true;
                        } else {
                            nuevoContenido += linea + "\n";
                        }
                    }
                    br.close();

                    // Escribir archivo actualizado
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTratamientos));
                    bw.write(nuevoContenido);
                    bw.close();

                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, "Tratamiento editado");
                        limpiarCampos();
                        txtIdEditar.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al editar: " + ex.getMessage());
                }
            }
        });

        // Sección para borrar
        JLabel lblBorrar = new JLabel("ID a borrar:");
        lblBorrar.setFont(new Font("Arial", Font.PLAIN, 14));
        lblBorrar.setBounds(230, 600, 100, 25);
        contentPane.add(lblBorrar);

        txtIdBorrar = new JTextField();
        txtIdBorrar.setBounds(330, 600, 150, 30);
        contentPane.add(txtIdBorrar);

        // Botón Borrar - color rojo
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBackground(new Color(231, 76, 60));
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnBorrar.setBounds(700, 576, 150, 40);
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
                    // Leer archivo y eliminar el tratamiento
                    BufferedReader br = new BufferedReader(new FileReader(archivoTratamientos));
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        if (!linea.startsWith(idBorrar + ";")) {
                            nuevoContenido += linea + "\n";
                        } else {
                            eliminado = true;
                        }
                    }
                    br.close();

                    // Escribir archivo sin el tratamiento eliminado
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTratamientos));
                    bw.write(nuevoContenido);
                    bw.close();

                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Tratamiento eliminado correctamente");
                        txtIdBorrar.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al borrar");
                }
            }
        });

        // Botón Mostrar - color gris
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBackground(new Color(149, 165, 166));
        btnMostrar.setForeground(Color.WHITE);
        btnMostrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnMostrar.setBounds(700, 627, 150, 40);
        contentPane.add(btnMostrar);

        // Acción del botón Mostrar
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Leer todos los tratamientos del archivo
                    BufferedReader br = new BufferedReader(new FileReader(archivoTratamientos));
                    String linea;
                    String resultado = "";

                    while ((linea = br.readLine()) != null) {
                        String[] tratamientoMostrar = linea.split(";");
                        if (tratamientoMostrar.length >= 9) {
                            // Formatear la información del tratamiento
                            resultado += "ID: " + tratamientoMostrar[0] + "\n" +
                                        "Medicamento: " + tratamientoMostrar[1] + "\n" +
                                        "Dosis: " + tratamientoMostrar[2] + "\n" +
                                        "Duración: " + tratamientoMostrar[3] + "\n" +
                                        "Instrucciones: " + tratamientoMostrar[4] + "\n" +
                                        "Doctor: " + tratamientoMostrar[5] + " - " + tratamientoMostrar[6] + "\n" +
                                        "Paciente: " + tratamientoMostrar[7] + " - " + tratamientoMostrar[8] + "\n" +
                                        "---------------------------\n";
                        }
                    }
                    br.close();

                    if (resultado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay tratamientos registrados");
                    } else {
                        JOptionPane.showMessageDialog(null, resultado);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al mostrar");
                }
            }
        });

        // Botón Volver al menú principal
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
        
        // Imagen de fondo en el lateral
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TratamientoJframe.class.getResource("/imagenes/tratamientos imagen.png")));
        lblNewLabel.setBounds(0, 96, 210, 585);
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
        txtId.setText("");
        txtMedicamento.setText("");
        txtDosis.setText("");
        txtDuracion.setText("");
        txtInstrucciones.setText("");
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