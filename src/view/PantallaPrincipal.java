package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Ventana principal de inicio de sesión y registro
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	
	// Archivo donde se guardan los usuarios registrados
	File Usuarios = new File("docs/Usuarios.txt");
	
	// Método principal - inicia la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			PantallaPrincipal frame = new PantallaPrincipal();
			frame.setVisible(true);
		});
	}

	// Constructor - configura la pantalla de inicio
	public PantallaPrincipal() {
		// Crear archivo de usuarios si no existe
		try {
		if(!Usuarios.exists()) {
			Usuarios.createNewFile();
			JOptionPane.showMessageDialog(null, "Archivo usuarios creado correctamente");
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error inesperado");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel superior con título
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(52, 152, 219));
		panelTitulo.setBounds(0, 0, 961, 135);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);

		JLabel titulo = new JLabel("Sistema de Gestión de Hospital ");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 35));
		titulo.setBounds(223, 21, 548, 40);
		panelTitulo.add(titulo);
		
		JLabel lblDJ = new JLabel("D & J");
		lblDJ.setForeground(Color.WHITE);
		lblDJ.setFont(new Font("Arial", Font.BOLD, 35));
		lblDJ.setBounds(403, 66, 548, 40);
		panelTitulo.add(lblDJ);

		// Título del área de login
		JLabel lblLogin = new JLabel("Inicio de sesión");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 35));
		lblLogin.setBounds(380, 173, 350, 47);
		contentPane.add(lblLogin);

		// Campo para nombre de usuario
		JLabel lblUsuario = new JLabel("Nombre de usuario:");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsuario.setBounds(380, 270, 200, 30);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(380, 305, 350, 35);
		contentPane.add(txtUsuario);

		// Campo para contraseña
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(380, 360, 200, 30);
		contentPane.add(lblPassword);

		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(380, 395, 350, 35);
		contentPane.add(txtContrasena);

		// Botón para registrar un nuevo usuario
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 // Obtener usuario y contraseña
				 String usuario = txtUsuario.getText();
				char[] passChars = txtContrasena.getPassword();
			 String contrasena = new String(passChars);

				
				try {
					// Crear escritor para el archivo
					FileWriter fW = new FileWriter(Usuarios, true);
					BufferedWriter bW = new BufferedWriter(fW);
					
					// Verificar que no haya campos vacíos
					if (txtUsuario.getText().isEmpty() || txtContrasena.getPassword().length == 0) {
					    JOptionPane.showMessageDialog(null, "Campos vacíos");
					}else {
						// Guardar usuario y contraseña en archivo
						bW.write(usuario + ";" + contrasena);
						bW.newLine();
						bW.close();
						JOptionPane.showMessageDialog(null, "Guardado correctamente");
						
					}

					
					
				}catch(Exception e1) {
					// Error al registrar
				}
				
				
				
			}
		});
		btnRegistrar.setBackground(new Color(46, 204, 113));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnRegistrar.setBounds(380, 470, 160, 40);
	
		contentPane.add(btnRegistrar);

		// Botón para iniciar sesión
		JButton btnInicioSesion = new JButton("Iniciar sesión");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  // Obtener credenciales ingresadas
				  String usuarioLogin = txtUsuario.getText();
			        char[] passChars = txtContrasena.getPassword();
			        String contrasenaLogin = new String(passChars);
				String texto = "";
				String textoCompleto = usuarioLogin + ";" + contrasenaLogin;
				
				try {
					// Leer archivo de usuarios
					FileReader fR = new FileReader(Usuarios);
					BufferedReader bR = new BufferedReader(fR);
					String linealeida = bR.readLine();
					
					// Leer todas las líneas del archivo
					while(linealeida !=null) {
						
						texto = texto + linealeida + "\n";
						linealeida = bR.readLine();
						}
					
					// Verificar campos vacíos
					if(txtUsuario.getText().isEmpty() || txtContrasena.getPassword().length == 0) {
						
						JOptionPane.showMessageDialog(null, "Usuario o contraseña vacio");
					}
					// Verificar credenciales
					else if(texto.contains(textoCompleto)) {
						JOptionPane.showMessageDialog(null, "Ingreso correcto");
						setVisible(false);
						MenuPrincipal menu1 = new MenuPrincipal();
						menu1.setVisible(true);
						bR.close();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Contraseña o Usuario incorrecto");
					}
					
				}catch(Exception e2) {
					
					JOptionPane.showMessageDialog(null, "Error inesperado");
					
				}
				
				
				
			}
		});
		btnInicioSesion.setBackground(new Color(52, 152, 219));
		btnInicioSesion.setForeground(Color.WHITE);
		btnInicioSesion.setFont(new Font("Arial", Font.BOLD, 18));
		btnInicioSesion.setBounds(570, 470, 160, 40);

		
		contentPane.add(btnInicioSesion);
		
		// Imagen de fondo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaPrincipal.class.getResource("/imagenes/imagen hospital.png")));
		lblNewLabel.setBounds(0, 119, 317, 505);
		contentPane.add(lblNewLabel);
	}
}