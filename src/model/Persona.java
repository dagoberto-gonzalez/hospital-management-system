package model;

/**
 * Clase base que representa a una persona en el sistema médico. Sirve como
 * clase padre para Paciente y Doctor.
 * 
 * @author Jose Zamora & Dagoberto Gonzalez
 */
public class Persona {

	/**
	 * ATRIBUTOS
	 */
	private String id;
	private String nombre;
	private int edad;
	private String correo;

	/**
	 * Constructor vacío.
	 */
	public Persona() {
	}

	/**
	 * Constructor sobrecargado.
	 * 
	 * @param id     identificador único de la persona
	 * @param nombre nombre completo
	 * @param edad   edad de la persona
	 * @param correo correo de la persona
	 */
	public Persona(String id, String nombre, int edad, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
	}

	/**
	 * Obtiene el ID de la persona.
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}


	/**
	 * Establece el ID de la persona.
	 * 
	 * @param id nuevo id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la persona.
	 * 
	 * @param nombre nuevo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la edad de la persona.
	 * 
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad de la persona.
	 * 
	 * @param edad nueva edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}