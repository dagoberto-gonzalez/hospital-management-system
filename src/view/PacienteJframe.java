package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import model.Paciente;
import javax.swing.ImageIcon;

/**
 * Ventana para gestionar pacientes
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class PacienteJframe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Campos de texto para los datos del paciente
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTipoSangre;
    private JTextField txtPadecimiento;
    private JTextField txtAlergias;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JTextField txtIdEditar;
    private JTextField txtIdBorrar;
    private JTextField textCorreo;
    
    // Lista de pacientes y archivo para guardar datos
    List <Paciente> listaPacientes = new ArrayList<Paciente>();
    File archivoPacientes = new File("docs/Pacientes.txt");

    // Método principal - inicia la ventana
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PacienteJframe frame = new PacienteJframe();
            frame.setVisible(true);
        });
    }

    // Constructor - configura la interfaz gráfica
    public PacienteJframe() {
    	// Crear archivo si no existe
    	try {
    	    if (!archivoPacientes.exists()) {
    	        archivoPacientes.createNewFile();
    	    }
    	} catch (Exception e) {
    	    JOptionPane.showMessageDialog(null, "Error al crear archivo de pacientes");
    	}

        setTitle("Gestión de Pacientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 800);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(46, 204, 113));
        panelTitulo.setBounds(0, 0, 986, 109);
        panelTitulo.setLayout(null);
        contentPane.add(panelTitulo);

        JLabel lblTitulo = new JLabel("GESTIÓN DE PACIENTES");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setBounds(310, 30, 450, 40);
        panelTitulo.add(lblTitulo);

        // Sección de datos del paciente
        JLabel lblDatos = new JLabel("Datos del paciente:");
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

        // Campo Nombre
        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNombre.setBounds(230, 235, 200, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(230, 265, 300, 30);
        contentPane.add(txtNombre);

        // Campo Edad
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEdad.setBounds(560, 165, 100, 25);
        contentPane.add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(560, 195, 100, 30);
        contentPane.add(txtEdad);

        // Campo Tipo de Sangre
        JLabel lblTipoSangre = new JLabel("Tipo de Sangre:");
        lblTipoSangre.setFont(new Font("Arial", Font.PLAIN, 16));
        lblTipoSangre.setBounds(560, 235, 150, 25);
        contentPane.add(lblTipoSangre);

        txtTipoSangre = new JTextField();
        txtTipoSangre.setBounds(560, 265, 100, 30);
        contentPane.add(txtTipoSangre);

        // Campo Padecimiento
        JLabel lblPadecimiento = new JLabel("Padecimiento:");
        lblPadecimiento.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPadecimiento.setBounds(230, 310, 150, 25);
        contentPane.add(lblPadecimiento);

        txtPadecimiento = new JTextField();
        txtPadecimiento.setBounds(230, 340, 300, 30);
        contentPane.add(txtPadecimiento);

        // Campo Alergias
        JLabel lblAlergias = new JLabel("Alergias:");
        lblAlergias.setFont(new Font("Arial", Font.PLAIN, 16));
        lblAlergias.setBounds(560, 310, 150, 25);
        contentPane.add(lblAlergias);

        txtAlergias = new JTextField();
        txtAlergias.setBounds(560, 340, 200, 30);
        contentPane.add(txtAlergias);

        // Campo Peso
        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPeso.setBounds(230, 385, 150, 25);
        contentPane.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(230, 415, 120, 30);
        contentPane.add(txtPeso);

        // Campo Altura
        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setFont(new Font("Arial", Font.PLAIN, 16));
        lblAltura.setBounds(380, 385, 150, 25);
        contentPane.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(380, 415, 120, 30);
        contentPane.add(txtAltura);

        // Línea separadora
        JSeparator separator = new JSeparator();
        separator.setBounds(200, 470, 786, 2);
        contentPane.add(separator);

        // Título de opciones
        JLabel lblOpciones = new JLabel("OPCIONES");
        lblOpciones.setFont(new Font("Arial", Font.BOLD, 22));
        lblOpciones.setBounds(450, 485, 200, 30);
        contentPane.add(lblOpciones);

        // Botón Guardar - color naranja
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(230, 126, 34));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 16));
        btnGuardar.setBounds(700, 530, 150, 40);
        contentPane.add(btnGuardar);

        // Acción del botón Guardar
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        		    // Verificar que todos los campos estén llenos
        		    if (txtId.getText().isEmpty() ||
        		        txtNombre.getText().isEmpty() ||
        		        txtEdad.getText().isEmpty() ||
        		        textCorreo.getText().isEmpty() ||
        		        txtTipoSangre.getText().isEmpty() ||
        		        txtPadecimiento.getText().isEmpty() ||
        		        txtAlergias.getText().isEmpty() ||
        		        txtPeso.getText().isEmpty() ||
        		        txtAltura.getText().isEmpty()) {

        		        JOptionPane.showMessageDialog(null, "No deje campos vacíos");
        		        return;
        		    }

        		    // Crear objeto Paciente con los datos
        		    Paciente paciente = new Paciente();

        		    paciente.setId(txtId.getText());
        		    paciente.setNombre(txtNombre.getText());
        		    paciente.setEdad(Integer.parseInt(txtEdad.getText()));
        		    paciente.setCorreo(textCorreo.getText());
        		    paciente.setTipoSangre(txtTipoSangre.getText());
        		    paciente.setPadecimiento(txtPadecimiento.getText());
        		    paciente.setAlergias(txtAlergias.getText());
        		    paciente.setPeso(Double.parseDouble(txtPeso.getText()));
        		    paciente.setAltura(Double.parseDouble(txtAltura.getText()));

        		    // Agregar a la lista en memoria
        		    listaPacientes.add(paciente);

        		    // Guardar en archivo
        		    BufferedWriter bw = new BufferedWriter(new FileWriter(archivoPacientes, true));
        		    bw.write(
        		        paciente.getId() + ";" +
        		        paciente.getNombre() + ";" +
        		        paciente.getEdad() + ";" +
        		        paciente.getCorreo() + ";" +
        		        paciente.getTipoSangre() + ";" +
        		        paciente.getPadecimiento() + ";" +
        		        paciente.getAlergias() + ";" +
        		        paciente.getPeso() + ";" +
        		        paciente.getAltura()
        		    );
        		    bw.newLine();
        		    bw.close();

        		    JOptionPane.showMessageDialog(null, "Paciente guardado correctamente");

        		    // Limpiar todos los campos después de guardar
        		    txtId.setText("");
        		    txtNombre.setText("");
        		    txtEdad.setText("");
        		    textCorreo.setText("");
        		    txtTipoSangre.setText("");
        		    txtPadecimiento.setText("");
        		    txtAlergias.setText("");
        		    txtPeso.setText("");
        		    txtAltura.setText("");

        		} catch (Exception ex) {
        		    JOptionPane.showMessageDialog(null, "Error al guardar paciente");
        		}
        	}
        });

        // Campo para ID a editar
        JLabel lblIdEditar = new JLabel("ID a editar:");
        lblIdEditar.setBounds(230, 540, 100, 25);
        contentPane.add(lblIdEditar);

        txtIdEditar = new JTextField();
        txtIdEditar.setBounds(330, 540, 150, 30);
        contentPane.add(txtIdEditar);

        // Botón Editar - color azul
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBackground(new Color(52, 152, 219));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEditar.setBounds(700, 580, 150, 40);
        contentPane.add(btnEditar);

        // Acción del botón Editar
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String idBuscar = txtIdEditar.getText();

                if (idBuscar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese el ID a editar");
                } else {
                    try {
                        // Leer archivo y buscar el paciente
                        BufferedReader br = new BufferedReader(new FileReader(archivoPacientes));
                        String linea;
                        String contenidoNuevo = "";
                        boolean encontrado = false;

                        while ((linea = br.readLine()) != null) {

                            if (linea.startsWith(idBuscar + ";")) {

                                // Verificar campos vacíos
                                if (txtId.getText().isEmpty() ||
                                    txtNombre.getText().isEmpty() ||
                                    txtEdad.getText().isEmpty() ||
                                    textCorreo.getText().isEmpty() ||
                                    txtTipoSangre.getText().isEmpty() ||
                                    txtPadecimiento.getText().isEmpty() ||
                                    txtAlergias.getText().isEmpty() ||
                                    txtPeso.getText().isEmpty() ||
                                    txtAltura.getText().isEmpty()) {

                                    JOptionPane.showMessageDialog(null, "No deje campos vacíos");
                                    br.close();
                                    return;
                                }

                                // Reemplazar la línea con los nuevos datos
                                contenidoNuevo +=
                                        txtId.getText() + ";" +
                                        txtNombre.getText() + ";" +
                                        txtEdad.getText() + ";" +
                                        textCorreo.getText() + ";" +
                                        txtTipoSangre.getText() + ";" +
                                        txtPadecimiento.getText() + ";" +
                                        txtAlergias.getText() + ";" +
                                        txtPeso.getText() + ";" +
                                        txtAltura.getText() + "\n";

                                encontrado = true;
                            } else {
                                contenidoNuevo = contenidoNuevo + linea + "\n";
                            }
                        }
                        br.close();

                        // Escribir archivo actualizado
                        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoPacientes));
                        bw.write(contenidoNuevo);
                        bw.close();

                        if (encontrado) {
                            JOptionPane.showMessageDialog(null, "Paciente editado correctamente");

                            // Limpiar todos los campos
                            txtIdEditar.setText("");
                            txtId.setText("");
                            txtNombre.setText("");
                            txtEdad.setText("");
                            textCorreo.setText("");
                            txtTipoSangre.setText("");
                            txtPadecimiento.setText("");
                            txtAlergias.setText("");
                            txtPeso.setText("");
                            txtAltura.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "ID no encontrado");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al editar paciente");
                    }
                }
        	}
        });

        // Campo para ID a borrar
        JLabel lblIdBorrar = new JLabel("ID a borrar:");
        lblIdBorrar.setBounds(230, 590, 100, 25);
        contentPane.add(lblIdBorrar);

        txtIdBorrar = new JTextField();
        txtIdBorrar.setBounds(330, 590, 150, 30);
        contentPane.add(txtIdBorrar);

        // Botón Borrar - color rojo
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBackground(new Color(231, 76, 60));
        btnBorrar.setForeground(Color.WHITE);
        btnBorrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnBorrar.setBounds(700, 630, 150, 40);
        contentPane.add(btnBorrar);

        // Acción del botón Borrar
        btnBorrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                File archivo = new File("docs/Pacientes.txt");
                String idBorrar = txtIdBorrar.getText();
                String contenidoNuevo = "";
                boolean encontrado = false;

                try {
                    // Leer archivo y eliminar el paciente
                    BufferedReader br = new BufferedReader(new FileReader(archivo));
                    String linea = br.readLine();

                    while (linea != null) {

                        // Cada línea empieza con el ID
                        if (!linea.startsWith(idBorrar + ";")) {
                            contenidoNuevo += linea + "\n";
                        } else {
                            encontrado = true;
                        }

                        linea = br.readLine();
                    }
                    br.close();

                    // Escribir archivo sin el paciente eliminado
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write(contenidoNuevo);
                    bw.close();

                    if (idBorrar.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese un ID");
                    } else if (encontrado) {
                        JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente");
                        txtIdBorrar.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al borrar paciente");
                }
        	}
        });

        // Botón Mostrar - color gris
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.setBackground(new Color(149, 165, 166));
        btnMostrar.setForeground(Color.WHITE);
        btnMostrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnMostrar.setBounds(700, 680, 150, 40);
        contentPane.add(btnMostrar);

        // Acción del botón Mostrar
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Leer todos los pacientes del archivo
                    BufferedReader br = new BufferedReader(new FileReader(archivoPacientes));
                    String linea;
                    String resultado = "";

                    while ((linea = br.readLine()) != null) {
                        String[] pacienteMostrar = linea.split(";");
                        if (pacienteMostrar.length >= 9) {
                            // Formatear la información del paciente
                            resultado += "ID: " + pacienteMostrar[0] + "\n" +
                                        "Nombre: " + pacienteMostrar[1] + "\n" +
                                        "Edad: " + pacienteMostrar[2] + " años\n" +
                                        "Correo: " + pacienteMostrar[3] + "\n" +
                                        "Tipo de sangre: " + pacienteMostrar[4] + "\n" +
                                        "Padecimiento: " + pacienteMostrar[5] + "\n" +
                                        "Alergias: " + pacienteMostrar[6] + "\n" +
                                        "Peso: " + pacienteMostrar[7] + " kg\n" +
                                        "Altura: " + pacienteMostrar[8] + " m\n" +
                                        "---------------------------\n";
                        }
                    }
                    br.close();

                    if (resultado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
                    } else {
                        JOptionPane.showMessageDialog(null, resultado);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al mostrar pacientes");
                }
            }
        });

        // Botón Volver al menú principal
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                volver();
        	}
        });
        btnVolver.setBounds(840, 120, 120, 30);
        contentPane.add(btnVolver);
        
        // Campo Correo
        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblCorreo.setBounds(560, 385, 150, 25);
        contentPane.add(lblCorreo);
        
        textCorreo = new JTextField();
        textCorreo.setBounds(560, 415, 200, 30);
        contentPane.add(textCorreo);
        
        // Botón Cerrar sesión
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cerrarSesion();
        	}
        });
        btnCerrarSesion.setBounds(840, 160, 120, 30);
        contentPane.add(btnCerrarSesion);
        
        // Imagen de fondo en el lateral
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(PacienteJframe.class.getResource("/imagenes/imagen pacientes (1).jpg")));
        lblNewLabel.setBounds(0, 81, 200, 661);
        contentPane.add(lblNewLabel);
    }
    
    // Método para volver al menú principal
    void volver(){
        MenuPrincipal menuP = new MenuPrincipal();
        menuP.setVisible(true);
        setVisible(false);
    }
    
    // Método para cerrar sesión
	void cerrarSesion(){
        PantallaPrincipal pantallaP = new PantallaPrincipal();
        pantallaP.setVisible(true);
        setVisible(false);
    }
}