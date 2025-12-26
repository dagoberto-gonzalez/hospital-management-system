package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Doctor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
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
 * Ventana para gestionar doctores
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class DoctorJframe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtId, txtNombre, txtEdad, txtEspecialidad;
    private JTextField txtExperiencia, txtCodigoMedico, txtHorario;
    private JTextField txtIdEditar, txtIdBorrar;
    
    List<Doctor> listaDoctores = new ArrayList<Doctor>();
    File archivoDoctores = new File("docs/Doctores.txt");

    // Método principal
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DoctorJframe frame = new DoctorJframe();
            frame.setVisible(true);
        });
    }

    // Constructor
    public DoctorJframe() {
        try {
            // Crear archivo si no existe
            if (!archivoDoctores.exists()) {
                archivoDoctores.createNewFile();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear archivo de doctores");
        }

        setTitle("Gestión de Doctores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 750);
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel superior - título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(176, 196, 222));
        panelTitulo.setBounds(0, 0, 986, 100);
        panelTitulo.setLayout(null);
        contentPane.add(panelTitulo);

        JLabel lblTitulo = new JLabel("GESTIÓN DE DOCTORES");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setBounds(280, 30, 450, 40);
        panelTitulo.add(lblTitulo);

        // Sección de datos del doctor
        JLabel lblDatos = new JLabel("Datos del doctor:");
        lblDatos.setFont(new Font("Arial", Font.BOLD, 20));
        lblDatos.setBounds(230, 120, 250, 30);
        contentPane.add(lblDatos);

        // Campo ID
        JLabel lblId = new JLabel("ID:");
        lblId.setFont(new Font("Arial", Font.PLAIN, 16));
        lblId.setBounds(230, 165, 100, 25);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(230, 195, 200, 30);
        contentPane.add(txtId);

        // Campo Nombre
        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNombre.setBounds(460, 165, 200, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(460, 195, 300, 30);
        contentPane.add(txtNombre);

        // Campo Edad
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEdad.setBounds(230, 240, 100, 25);
        contentPane.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(230, 270, 100, 30);
        contentPane.add(txtEdad);

        // Campo Especialidad
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEspecialidad.setBounds(360, 240, 150, 25);
        contentPane.add(lblEspecialidad);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(360, 270, 200, 30);
        contentPane.add(txtEspecialidad);

        // Campo Experiencia
        JLabel lblExperiencia = new JLabel("Años de experiencia:");
        lblExperiencia.setFont(new Font("Arial", Font.PLAIN, 16));
        lblExperiencia.setBounds(590, 240, 200, 25);
        contentPane.add(lblExperiencia);

        txtExperiencia = new JTextField();
        txtExperiencia.setBounds(590, 270, 100, 30);
        contentPane.add(txtExperiencia);

        // Campo Código médico
        JLabel lblCodigoMedico = new JLabel("Código médico:");
        lblCodigoMedico.setFont(new Font("Arial", Font.PLAIN, 16));
        lblCodigoMedico.setBounds(230, 315, 150, 25);
        contentPane.add(lblCodigoMedico);

        txtCodigoMedico = new JTextField();
        txtCodigoMedico.setBounds(230, 345, 200, 30);
        contentPane.add(txtCodigoMedico);

        // Campo Horario
        JLabel lblHorario = new JLabel("Horario de atención:");
        lblHorario.setFont(new Font("Arial", Font.PLAIN, 16));
        lblHorario.setBounds(460, 315, 200, 25);
        contentPane.add(lblHorario);

        txtHorario = new JTextField();
        txtHorario.setBounds(460, 345, 300, 30);
        contentPane.add(txtHorario);

        // Línea separadora
        JSeparator separator = new JSeparator();
        separator.setBounds(217, 423, 746, 2);
        contentPane.add(separator);

        // Botón Guardar - color naranja
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(230, 126, 34));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 16));
        btnGuardar.setBounds(700, 447, 150, 40);
        contentPane.add(btnGuardar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar que todos los campos estén llenos
                if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || 
                    txtEdad.getText().isEmpty() || txtEspecialidad.getText().isEmpty() || 
                    txtExperiencia.getText().isEmpty() || txtCodigoMedico.getText().isEmpty() || 
                    txtHorario.getText().isEmpty()) {
                    
                    JOptionPane.showMessageDialog(null, "No deje campos vacíos");
                    return;
                }

                try {
                    // Convertir edad y experiencia a números
                    int edad = Integer.parseInt(txtEdad.getText());
                    int experiencia = Integer.parseInt(txtExperiencia.getText());
                    
                    // Validar que sean números positivos
                    if (edad < 0 || experiencia < 0) {
                        JOptionPane.showMessageDialog(null, "Edad y experiencia deben ser números positivos");
                        return;
                    }

                    // Crear objeto Doctor
                    Doctor doctor = new Doctor();
                    doctor.setId(txtId.getText());
                    doctor.setNombre(txtNombre.getText());
                    doctor.setEdad(edad);
                    doctor.setEspecialidad(txtEspecialidad.getText());
                    doctor.setAñosExperiencia(experiencia);
                    doctor.setCodigoMedico(txtCodigoMedico.getText());
                    doctor.setHorarioAtencion(txtHorario.getText());

                    // Guardar en archivo
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDoctores, true));
                    bw.write(doctor.getId() + ";" + doctor.getNombre() + ";" + 
                            doctor.getEdad() + ";" + doctor.getEspecialidad() + ";" + 
                            doctor.getAñosExperiencia() + ";" + doctor.getCodigoMedico() + ";" + 
                            doctor.getHorarioAtencion());
                    bw.newLine();
                    bw.close();

                    JOptionPane.showMessageDialog(null, "Doctor guardado correctamente");
                    limpiarCampos();
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Edad y experiencia deben ser números válidos");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar doctor: " + ex.getMessage());
                }
            }
        });

        // Campo para ID a editar
        JLabel lblIdEditar = new JLabel("ID a editar:");
        lblIdEditar.setFont(new Font("Arial", Font.PLAIN, 14));
        lblIdEditar.setBounds(257, 507, 100, 25);
        contentPane.add(lblIdEditar);

        txtIdEditar = new JTextField();
        txtIdEditar.setBounds(347, 505, 150, 30);
        contentPane.add(txtIdEditar);

        // Botón Editar - color azul
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBackground(new Color(52, 152, 219));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEditar.setBounds(700, 498, 150, 40);
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
                    // Convertir edad y experiencia a números
                    int edad = Integer.parseInt(txtEdad.getText());
                    int experiencia = Integer.parseInt(txtExperiencia.getText());
                    
                    // Validar que sean números positivos
                    if (edad < 0 || experiencia < 0) {
                        JOptionPane.showMessageDialog(null, "Edad y experiencia deben ser números positivos");
                        return;
                    }

                    // Leer archivo y buscar el doctor
                    BufferedReader br = new BufferedReader(new FileReader(archivoDoctores));
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        if (linea.startsWith(idBuscar + ";")) {
                            // Reemplazar con los nuevos datos
                            nuevoContenido += txtId.getText() + ";" + txtNombre.getText() + ";" + 
                                            txtEdad.getText() + ";" + txtEspecialidad.getText() + ";" + 
                                            txtExperiencia.getText() + ";" + txtCodigoMedico.getText() + ";" + 
                                            txtHorario.getText() + "\n";
                            encontrado = true;
                        } else {
                            nuevoContenido += linea + "\n";
                        }
                    }
                    br.close();

                    // Escribir el archivo actualizado
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDoctores));
                    bw.write(nuevoContenido);
                    bw.close();

                    if (encontrado) {
                        JOptionPane.showMessageDialog(null, "Doctor editado correctamente");
                        limpiarCampos();
                        txtIdEditar.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Edad y experiencia deben ser números válidos");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al editar doctor: " + ex.getMessage());
                }
            }
        });

        // Campo para ID a borrar
        JLabel lblIdBorrar = new JLabel("ID a borrar:");
        lblIdBorrar.setFont(new Font("Arial", Font.PLAIN, 14));
        lblIdBorrar.setBounds(257, 566, 100, 25);
        contentPane.add(lblIdBorrar);

        txtIdBorrar = new JTextField();
        txtIdBorrar.setBounds(347, 564, 150, 30);
        contentPane.add(txtIdBorrar);

        // Botón Borrar - color rojo
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBackground(new Color(231, 76, 60));
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnBorrar.setBounds(700, 554, 150, 40);
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
                    // Leer archivo y eliminar el doctor
                    BufferedReader br = new BufferedReader(new FileReader(archivoDoctores));
                    String linea;

                    while ((linea = br.readLine()) != null) {
                        if (!linea.startsWith(idBorrar + ";")) {
                            nuevoContenido += linea + "\n";
                        } else {
                            eliminado = true;
                        }
                    }
                    br.close();

                    // Escribir archivo sin el doctor eliminado
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDoctores));
                    bw.write(nuevoContenido);
                    bw.close();

                    if (eliminado) {
                        JOptionPane.showMessageDialog(null, "Doctor eliminado correctamente");
                        txtIdBorrar.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al borrar doctor");
                }
            }
        });

        // Botón Mostrar - color gris
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBackground(new Color(149, 165, 166));
        btnMostrar.setForeground(Color.WHITE);
        btnMostrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnMostrar.setBounds(700, 605, 150, 40);
        contentPane.add(btnMostrar);

        // Acción del botón Mostrar
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(archivoDoctores));
                    String linea;
                    String resultado = "";
                    int contador = 0;

                    // Leer todos los doctores del archivo
                    while ((linea = br.readLine()) != null) {
                        String[] doctorMostrar = linea.split(";");
                        if (doctorMostrar.length >= 7) {
                            contador++;                          
                            resultado += "DOCTOR #" + contador + "\n";
                            resultado += "════════════════════════════════════\n";
                            resultado += "ID: " + doctorMostrar[0] + "\n";
                            resultado += "Nombre: " + doctorMostrar[1] + "\n";
                            resultado += "Edad: " + doctorMostrar[2] + " años\n";
                            resultado += "Especialidad: " + doctorMostrar[3] + "\n";
                            resultado += "Experiencia: " + doctorMostrar[4] + " años\n";
                            resultado += "Código médico: " + doctorMostrar[5] + "\n";
                            resultado += "Horario: " + doctorMostrar[6] + "\n\n";
                        }
                    }
                    br.close();

                    if (contador == 0) {
                        JOptionPane.showMessageDialog(null, "No hay doctores registrados");
                    } else {
                        JOptionPane.showMessageDialog(null, resultado, 
                                                    "Lista de Doctores (" + contador + " registros)", 
                                                    JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al mostrar doctores");
                }
            }
        });

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
        btnVolver.setBounds(841, 111, 122, 30);
        contentPane.add(btnVolver);
        
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });

        // Botón Cerrar sesión
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCerrarSesion.setBounds(841, 142, 122, 30);
        contentPane.add(btnCerrarSesion);
        
        // Imagen de fondo
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(DoctorJframe.class.getResource("/imagenes/imagen doctores.jpg")));
        lblNewLabel.setBounds(0, 99, 220, 612);
        contentPane.add(lblNewLabel);
        
        btnCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
    }

    // Limpiar todos los campos
    void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtEspecialidad.setText("");
        txtExperiencia.setText("");
        txtCodigoMedico.setText("");
        txtHorario.setText("");
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